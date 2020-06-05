package br.com.prod.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoResource {

	private String id;
	@JsonProperty("id_usuario")
	private String id_usuario;
	@JsonProperty("quantidade")
	private String quantidade;
	@JsonProperty("id_produto")
	private String id_produto;
	@JsonProperty("endereco")
	private String endereco;
	
	public PedidoResource(String id, String id_usuario, String quantidade, String id_produto, String endereco) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.quantidade = quantidade;
		this.id_produto = id_produto;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getId_produto() {
		return id_produto;
	}

	public void setId_produto(String id_produto) {
		this.id_produto = id_produto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "PedidoResource [id=" + id + ", id_usuario=" + id_usuario + ", quantidade=" + quantidade
				+ ", id_produto=" + id_produto + ", endereco=" + endereco + "]";
	}
	
}
