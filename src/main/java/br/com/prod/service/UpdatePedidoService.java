package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.exception.PedidoResourceException;
import br.com.prod.repository.PedidoRepository;
import br.com.prod.resource.model.PedidoResource;
@Service
public class UpdatePedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoConversor service;
	
	private static final Logger LOG = Logger.getLogger(UpdatePedidoService.class);
	
	public Pedido updatePedido(Long id, PedidoResource pedidoResource) {
		
		
		return pedidoRepository.findById(id).map(pedido ->{
			pedido.setEndereco(pedidoResource.getEndereco());
			try {
				pedido.setId_produto(service.checkIdsPedido(pedidoResource.getId_produto()));
				pedido.setId_usuario(service.checkIdsPedido(pedidoResource.getId_usuario()));
				pedido.setQuantidade(service.checkQuantidadePedido(pedidoResource.getQuantidade()));
			}catch(Exception e){
				LOG.error("Falha ao converter resource para entidade, resource: " + pedidoResource);					
			}
			return pedidoRepository.save(pedido);
		})
		.orElseGet(() ->{
			Pedido conversor = null;
			
			try {
				conversor = service.conversor(pedidoResource);
			} catch (PedidoResourceException e) {
				LOG.error("Erro no update Usuario: " + e.getMessage(), e);
			}
			conversor.setId(id);
			return pedidoRepository.save(conversor);
			
		})		
		;
		
	}
	
	
}
