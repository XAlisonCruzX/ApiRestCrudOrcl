package br.com.prod.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.repository.PedidoRepository;

@Service
public class BuscarPedidoServiceImpl {
	
	private static final Logger LOG = Logger.getLogger(BuscarPedidoServiceImpl.class);
	
	@Autowired
	private PedidoRepository PedidoRepository;
	
	public List<Pedido> buscarTodosOsPedidos(){
		
		LOG.info("Serviço para buscar todos Pedidos sendo executado");
		
		List<Pedido> listaPedido = PedidoRepository.findAll();
		
	
		return listaPedido;
		
	}
}
