package br.com.prod.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Produto;
import br.com.prod.exception.ProdutoNotFoundException;
import br.com.prod.repository.ProdutoRepository;

@Service
public class BuscarProdByIdService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public Produto buscarPorId(Long id) throws ProdutoNotFoundException {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		Produto produto = null;
		if(!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException(
					"Produto não encontrado através do id");
		}else {
			produto = optionalProduto.get();
		}
		return produto;
	}
	
	public void deletarPorId(Long id) throws ProdutoNotFoundException {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if(!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException(
					"Produto não encontrado através do id");
		}else {
			produtoRepository.delete(optionalProduto.get());;
		}
		
	}
	
	
}
