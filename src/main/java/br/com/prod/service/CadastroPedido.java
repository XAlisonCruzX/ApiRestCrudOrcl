package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.exception.PedidoResourceException;
import br.com.prod.repository.PedidoRepository;
import br.com.prod.resource.model.PedidoResource;


@Service
public class CadastroPedido {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoConversor service;
	
	private static final Logger LOG = Logger.getLogger(CadastroPedido.class);
	
	public void cadastro(PedidoResource pedidoResource){
		
		try {
			Pedido pedido = service.conversor(pedidoResource);
			pedidoRepository.saveAndFlush(pedido);
		} catch (PedidoResourceException e) {
			LOG.error("Erro ao salvar pedido: " + e.getMessage(), e);
		}
	
	}
	
}
