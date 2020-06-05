package br.com.prod.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResource {
	
	
	private String id;
	@JsonProperty("nome_produto")
	private String nome;
	@JsonProperty("valor")
	private String valor;
	@JsonProperty("description")
	private String desc;
	@JsonProperty("url_img")
	private String urlImg;
	
	public ProdutoResource(String nome, String valor, String desc, String urlImg) {
		
		this.nome = nome;
		this.valor = valor;
		this.desc = desc;
		this.urlImg = urlImg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProdutoResource [id=" + id + ", nome=" + nome + ", valor=" + valor + ", desc=" + desc + ", urlImg="
				+ urlImg + "]";
	}
	
}