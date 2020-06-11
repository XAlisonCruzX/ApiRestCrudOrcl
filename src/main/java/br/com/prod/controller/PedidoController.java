package br.com.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.exception.PedidoNotFoundException;
import br.com.prod.resource.model.PedidoResource;
import br.com.prod.service.BuscarByIdPedidoService;
import br.com.prod.service.BuscarPedidoServiceImpl;
import br.com.prod.service.CadastroPedido;
import br.com.prod.service.UpdatePedidoService;


@RestController
@RequestMapping(value = "/api")
public class PedidoController {

	@Autowired
	private BuscarPedidoServiceImpl serviceBuscar;
	
	@Autowired
	private BuscarByIdPedidoService serviceId;
	
	@Autowired
	private CadastroPedido serviceCadastro;
	
	@Autowired
	private UpdatePedidoService serviceUpdate;
	
	//FINDALL
	@GetMapping(path = "/pedido")
	public List<Pedido> buscarPedido(){
		return serviceBuscar.buscarTodosOsPedidos();
			
	}
	
	//FINDBYID
	@GetMapping(path = "/pedido/id/{id}")
	public Pedido buscarPedidoPorId(
			@PathVariable(name = "id", required = true) Long idPedido) throws PedidoNotFoundException{
		
		return serviceId.buscarPorId(idPedido);
	}
	
	//DELETE BY ID
	@DeleteMapping(path = "/delete/pedido/{id}")
	public void deletePedido(
			@PathVariable(name = "id", required = true)Long idPedido) throws PedidoNotFoundException {
			
		serviceId.deletarPorId(idPedido);
			
	}
	//SAVE
	@PostMapping(path = "cpedido/save")
	public void salvarProduto(
			@RequestBody PedidoResource pedidoResource ){
		
		serviceCadastro.cadastro(pedidoResource);
			
	}
	
	//UPDATE
	@PutMapping(path = "cpedido/update/{id}")
	public Pedido updatePedido(
			@PathVariable(name = "id", required = true)Long idPedido,
			@RequestBody PedidoResource pedidoResource ){
		return serviceUpdate.updatePedido(idPedido, pedidoResource);
		
	}	
	
	
	
	
	
	
}
