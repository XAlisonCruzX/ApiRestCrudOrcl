package br.com.prod.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Produto;
import br.com.prod.repository.ProdutoRepository;


@Service
public class BuscarProdutoServiceImpl {

	private static final Logger LOG = Logger.getLogger(BuscarProdutoServiceImpl.class);
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodosOsProdutos(){
		
		LOG.info("Serviço para buscar todos Produtos sendo executado");
		
		List<Produto> listaProduto = produtoRepository.findAll();
		
	
		return listaProduto;
		
	}
	
}
