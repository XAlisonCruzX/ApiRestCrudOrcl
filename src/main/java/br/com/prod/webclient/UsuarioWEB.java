package br.com.prod.webclient;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.prod.datasource.model.Produto;
import br.com.prod.datasource.model.Usuario;
import br.com.prod.resource.model.UsuarioResource;

public class UsuarioWEB {

	
	private static Client client = ClientBuilder.newClient();
	private WebTarget baseTarget = client.target("http://localhost:8080/api/");
	
	public Usuario getById(String id) {
	
		WebTarget produtoTarget = this.baseTarget.path("usuario");
		WebTarget singleUsuarioTarget = produtoTarget.path("id/{id}");
		
		Usuario usuario = singleUsuarioTarget.resolveTemplate("id", id).request().get(Usuario.class);
		
		return usuario;
	}
	
	public List<Usuario> getAll() {
		
		WebTarget usuarioTarget = this.baseTarget.path("usuario");
		
		Response response = usuarioTarget.request().get();
		Usuario[] produto = (response.readEntity(Usuario[].class));
		List<Usuario> lstUsuario = new ArrayList<>();
		for(Usuario p:produto) {
			lstUsuario.add(p);
		}		
		return lstUsuario;
	}
	
	public Response save(UsuarioResource usuario) {
		
		WebTarget usuarioSaveTarget = this.baseTarget.path("cusuario/save");
		String date = usuario.getNascimento();
		usuario.setNascimento(date.substring(0,10).replace("-", "/"));
		
		
		Response postResponse = usuarioSaveTarget.request().post(Entity.json(usuario)); 
		
		return postResponse;
	}
	
	
	public Produto update(String id, Usuario usuario) {

		WebTarget usuarioUpdateTarget = this.baseTarget.path("cusuario/update/{id}");
		
		Response putResponse = usuarioUpdateTarget.resolveTemplate("id", id).request().put(Entity.json(usuario)); 
		
		return putResponse.readEntity(Produto.class);
	}
	
	public Response deleteById(String id) {
		
	
		WebTarget deleteTarget = this.baseTarget.path("delete/usuario/{id}");
		
		Response deleteResponse = deleteTarget.resolveTemplate("id", id).request().delete();
		return deleteResponse;
	}
	
	
}
