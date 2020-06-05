package br.com.prod.datasource.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8116717860798256550L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long id_usuario;
	private int quantidade;
	private Long id_produto;
	private String endereco;
	
	public Pedido() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId_produto() {
		return id_produto;
	}

	public void setId_produto(Long id_produto) {
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
		return "Pedido [id=" + id + ", id_usuario=" + id_usuario + ", quantidade=" + quantidade + ", id_produto="
				+ id_produto + ", endereco=" + endereco + "]";
	}
	
	

	
	
	
	
	
}
