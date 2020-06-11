package br.com.prod.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioResourceException;
import br.com.prod.resource.model.UsuarioResource;

@Component
public class UsuarioConversor {

	public Usuario conversor(UsuarioResource usuarioResource) throws UsuarioResourceException {
		
		try {
			Usuario usuario = new Usuario();
			Date dateUsuario = checkDateUsuario(usuarioResource.getNascimento());
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
	
	public Date checkDateUsuario(String nascimento) throws UsuarioResourceException {
		Date aDate = null;
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			aDate = dateFormat.parse(nascimento);
			
			 
			 return aDate;
		}catch(Exception e) {
			throw new  UsuarioResourceException("Falha ao converter resource para entidade, nascimento: " + nascimento + "" + "parse:" + aDate);
		}
		
	}
	
}
