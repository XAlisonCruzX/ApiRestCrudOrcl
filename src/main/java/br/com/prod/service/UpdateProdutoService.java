package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Produto;
import br.com.prod.exception.ProdutoResourceException;
import br.com.prod.repository.ProdutoRepository;
import br.com.prod.resource.model.ProdutoResource;

@Service
public class UpdateProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoConversor service;
	private static final Logger LOG = Logger.getLogger(UpdateProdutoService.class);
	
	public Produto updateProduto(Long id, ProdutoResource produtoResource) {
		return produtoRepository.findById(id).map(produto ->{
			produto.setDesc(produtoResource.getDesc());
			produto.setNome(produtoResource.getNome());
			produto.setUrlImg(produtoResource.getUrlImg());
			try {
				produto.setValor(service.checkValorProduto(produtoResource.getValor()));
			} catch (ProdutoResourceException e) {
				LOG.error("Falha ao converter resource para entidade, resource: " + produtoResource);
			}
			return produtoRepository.save(produto);
			
		})
		.orElseGet(() ->{
			
			Produto conversor = null;
			try {
				conversor = service.conversor(produtoResource);
			} catch (ProdutoResourceException e) {
				e.printStackTrace();
			}
			conversor.setId(id);
			return produtoRepository.save(conversor);
			
			
			
		});
		
		
		
	}
	
	
}
