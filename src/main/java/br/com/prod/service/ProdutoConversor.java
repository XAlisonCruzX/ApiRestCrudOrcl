package br.com.prod.service;

import org.springframework.stereotype.Component;

import br.com.prod.datasource.model.Produto;
import br.com.prod.exception.ProdutoResourceException;
import br.com.prod.resource.model.ProdutoResource;

@Component
public class ProdutoConversor {

	public Produto conversor(ProdutoResource produtoResource) throws ProdutoResourceException {
		
		try {
			
			Produto produto = new Produto();
			float valor = checkValorProduto(produtoResource.getValor());
			
			produto.setValor(valor);
			produto.setDesc(produtoResource.getDesc());
			produto.setNome(produtoResource.getNome());
			produto.setUrlImg(produtoResource.getUrlImg());
			
			return produto;
			
		}catch(Exception e) {
		     throw new ProdutoResourceException(
		    		 "Falha ao converter resource para entidade, resource: " + produtoResource);
		}
		
			
	}
	
	public float checkValorProduto(String valor) throws ProdutoResourceException{
		
		try {
			return Float.parseFloat(valor);
		}catch(Exception e) {
			throw new  ProdutoResourceException("Falha ao converter resource para entidade, valor: " + valor);
		}
	}
	
}
