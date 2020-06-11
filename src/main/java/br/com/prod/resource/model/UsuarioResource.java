package br.com.prod.resource.model;


import com.fasterxml.jackson.annotation.JsonProperty;



public class UsuarioResource {

	
	
	private String id;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("senha")
	private String senha;
	@JsonProperty("nascimento")
	private String nascimento;
	@JsonProperty("endereco")
	private String endereco;
	@JsonProperty("privilege")
	private String privilege;
	
	public UsuarioResource() {
		
	}
	public UsuarioResource(String id, String firstName, String lastName, String email, String senha, String nascimento,
			String endereço, String privilege) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.senha = senha;
		this.nascimento = nascimento;
		this.endereco = endereço;
		this.privilege = privilege;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereço) {
		this.endereco = endereço;
	}
	
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	@Override
	public String toString() {
		return "UsuarioResource [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", senha=" + senha + ", nascimento=" + nascimento + ", endereço=" + endereco + "privilege=" + privilege +"]";
	}
	
}
