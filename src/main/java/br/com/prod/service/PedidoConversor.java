package br.com.prod.service;

import org.springframework.stereotype.Component;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.exception.PedidoResourceException;
import br.com.prod.resource.model.PedidoResource;


@Component
public class PedidoConversor {

	public Pedido conversor(PedidoResource pedidoResource) throws PedidoResourceException {
		
		try {
			Pedido pedido = new Pedido();
			
			Long idProduto = checkIdsPedido(pedidoResource.getId_produto());
			Long idUsuario = checkIdsPedido(pedidoResource.getId_usuario());
			Integer quantidade = checkQuantidadePedido(pedidoResource.getQuantidade());
			
			pedido.setEndereco(pedidoResource.getEndereco());
			pedido.setId_produto(idProduto);
			pedido.setId_usuario(idUsuario);
			pedido.setQuantidade(quantidade);
			
			
			return pedido;
			
		}catch(Exception e) {
		     throw new PedidoResourceException(
		    		 "Falha ao converter resource para entidade, resource: " + pedidoResource);
		}
		
			
	}
	
	public Long checkIdsPedido(String valor) throws PedidoResourceException{
		
		try {
			return Long.parseLong(valor);
		}catch(Exception e) {
			throw new  PedidoResourceException("Falha ao converter resource para entidade, algum id: " + valor);
		}
	}
	
	public Integer checkQuantidadePedido(String valor) throws PedidoResourceException{
		
		try {
			return Integer.parseInt(valor);
		}catch(Exception e) {
			throw new  PedidoResourceException("Falha ao converter resource para entidade, quantidade: " + valor);
		}
	}
	
}
