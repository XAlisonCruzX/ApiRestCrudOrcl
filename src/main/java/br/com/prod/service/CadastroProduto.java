package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Produto;
import br.com.prod.exception.ProdutoResourceException;
import br.com.prod.repository.ProdutoRepository;
import br.com.prod.resource.model.ProdutoResource;

@Service
public class CadastroProduto {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoConversor service;
	
	private static final Logger LOG = Logger.getLogger(CadastroProduto.class);
	
	
	public void cadastro(ProdutoResource produtoResource){
		
		try {
			Produto produto = service.conversor(produtoResource);
			produtoRepository.saveAndFlush(produto);
		} catch (ProdutoResourceException e) {
			LOG.error("Erro ao salvar produto: " + e.getMessage(), e);
		}
	
		
	}	
}
