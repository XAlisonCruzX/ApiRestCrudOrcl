package br.com.prod.webclient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.prod.datasource.model.Pedido;

public class PedidoWEB {

	private static Client client = ClientBuilder.newClient();
	private WebTarget baseTarget = client.target("http://localhost:8080/api/");
	
	public Pedido getById(String id) {
	
		WebTarget pedidoTarget = this.baseTarget.path("pedido");
		WebTarget singlePedidoTarget = pedidoTarget.path("id/{id}");
		
		Pedido pedido  = singlePedidoTarget.resolveTemplate("id", id).request().get(Pedido.class);
		
		return pedido;
	}
	
	public List<Pedido> getAll() {
		
		WebTarget pedidoTarget = this.baseTarget.path("pedido");
		
		Response response = pedidoTarget.request().get();
		Pedido[] pedido = (response.readEntity(Pedido[].class));
		List<Pedido> lstPedido = new ArrayList<>();
		for(Pedido p:pedido) {
			lstPedido.add(p);
		}		
		return lstPedido;
	}
	
	public Response save(Pedido pedido) {
		
		WebTarget pedidoSaveTarget = this.baseTarget.path("cpedido/save");
		Response postResponse = pedidoSaveTarget.request().post(Entity.json(pedido)); 
		
		return postResponse;
	}
	
	
	public Pedido update(String id, Pedido pedido) {

		WebTarget pedidoUpdateTarget = this.baseTarget.path("cpedido/update/{id}");
		
		Response putResponse = pedidoUpdateTarget.resolveTemplate("id", id).request().put(Entity.json(pedido)); 
		
		return putResponse.readEntity(Pedido.class);
	}
	
	public Response deleteById(String id) {
		
	
		WebTarget deleteTarget = this.baseTarget.path("delete/pedido/{id}");
		
		Response deleteResponse = deleteTarget.resolveTemplate("id", id).request().delete();
		return deleteResponse;
	}
	
}
