package br.com.prod.datasource.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	

	private static final long serialVersionUID = -38044173568094954L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String nome;
	private float valor;
	@Column(name= "description")
	private String desc;
	@Column(name= "url_img")
	private String urlImg;
	
	public Produto(Long id, String nome, float valor, String desc, String urlImg) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.desc = desc;
		this.urlImg = urlImg;
	}

	public Produto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id =  id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
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
	public void setUrlImg(String url_img) {
		this.urlImg = url_img;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", desc=" + desc + ", urlImg=" + urlImg
				+ "]";
	}
	
	
	
}
