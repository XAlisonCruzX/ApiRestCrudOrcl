package br.com.prod.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioResourceException;
import br.com.prod.resource.model.UsuarioResource;

@Component
public class UsuarioConversor {

	public Usuario conversor(UsuarioResource usuarioResource) throws UsuarioResourceException {
		
		try {
			Usuario usuario = new Usuario();
			LocalDate dateUsuario = checkDateUsuario(usuarioResource.getNascimento());
			usuario.setNascimento(dateUsuario);
			usuario.setFirstName(usuarioResource.getFirstName());
			usuario.setLastName(usuarioResource.getLastName());
			usuario.setEmail(usuarioResource.getEmail());
			usuario.setSenha(usuarioResource.getSenha());
			usuario.setEndereco(usuarioResource.getEndereco());
			usuario.setPrivilege(usuarioResource.getPrivilege());
			
			return usuario;
			
		}catch(Exception e) {
		     throw new UsuarioResourceException(
		    		 "Falha ao converter resource para entidade, resource: " + usuarioResource);
		} 
		
			
	}
	
	public LocalDate checkDateUsuario(String nascimento) throws UsuarioResourceException {
		try {
			return LocalDate.parse(nascimento);
		}catch(Exception e) {
			throw new  UsuarioResourceException("Falha ao converter resource para entidade, nascimento: " + nascimento);
		}
	}
	
}
