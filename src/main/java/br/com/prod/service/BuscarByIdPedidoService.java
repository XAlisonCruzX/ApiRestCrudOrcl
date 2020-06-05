package br.com.prod.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.exception.PedidoNotFoundException;
import br.com.prod.repository.PedidoRepository;


@Service
public class BuscarByIdPedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Pedido buscarPorId(Long id) throws PedidoNotFoundException {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		Pedido pedido = null;
		if(!optionalPedido.isPresent()) {
			throw new PedidoNotFoundException(
					"Pedido não encontrado através do id");
		}else {
			pedido = optionalPedido.get();
		}
		return pedido;
	}
	
	public void deletarPorId(Long id) throws PedidoNotFoundException {
		
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		if(!optionalPedido.isPresent()) {
			throw new PedidoNotFoundException(
					"Pedido não encontrado através do id");
		}else {
			pedidoRepository.delete(optionalPedido.get());;
		}
		
	}
	
	
	
}
