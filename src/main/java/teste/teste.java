package teste;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.prod.datasource.model.Produto;

public class teste {
	
	private static Client client = ClientBuilder.newClient();
	private WebTarget baseTarget = client.target("http://192.168.0.100:8080/api/");
	
	public Produto getById(Long id) {
	
		WebTarget produtoTarget = this.baseTarget.path("produto");
		WebTarget singleProdutoTarget = produtoTarget.path("id/{id}");
		
		Produto produto  = singleProdutoTarget.resolveTemplate("id", id).request().get(Produto.class);
		
		return produto;
	}
	
	public List<Produto> getAll() {
		
		WebTarget produtoTarget = this.baseTarget.path("produto");
		
		Response response = produtoTarget.request().get();
		Produto[] produto = (response.readEntity(Produto[].class));
		List<Produto> lstProduto = new ArrayList<>();
		for(Produto p:produto) {
			lstProduto.add(p);
		}		
		return lstProduto;
	}
	
	public Response save(Produto produto) {
		
		WebTarget produtoSaveTarget = this.baseTarget.path("cproduto/save");
		Response postResponse = produtoSaveTarget.request().post(Entity.json(produto)); 
		
		return postResponse;
	}
	
	
	public Produto update(Long id, Produto produto) {

		WebTarget produtoUpdateTarget = this.baseTarget.path("cproduto/update/{id}");
		
		Response putResponse = produtoUpdateTarget.resolveTemplate("id", id).request().put(Entity.json(produto)); 
		
		return putResponse.readEntity(Produto.class);
	}
	
	public Response deleteById(Long id) {
		
	
		WebTarget deleteTarget = this.baseTarget.path("delete/produto/{id}");
		
		Response deleteResponse = deleteTarget.resolveTemplate("id", id).request().delete();
		return deleteResponse;
	}
	
	
	
	
	

}
