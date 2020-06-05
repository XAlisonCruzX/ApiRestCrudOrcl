package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioResourceException;
import br.com.prod.repository.UsuarioRepository;
import br.com.prod.resource.model.UsuarioResource;

@Service
public class UpdateUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioConversor service;
	
	private static final Logger LOG = Logger.getLogger(UpdateUsuarioService.class);
	
	public Usuario updateUsuario(Long id, UsuarioResource usuarioResource) {
	
			 return usuarioRepository.findById(id).map(usuario ->{
				
				 
				usuario.setEmail(usuarioResource.getEmail());
				usuario.setEndereco(usuarioResource.getEmail());
				usuario.setFirstName(usuarioResource.getFirstName());
				usuario.setLastName(usuarioResource.getLastName());
				usuario.setSenha(usuarioResource.getSenha());
				try {
					usuario.setNascimento(service.checkDateUsuario(usuarioResource.getNascimento()));
				
				}catch(Exception e){
					LOG.error("Falha ao converter resource para entidade, resource: " + usuarioResource);					
				}
				usuario.setPrivilege(usuarioResource.getPrivilege());
				return usuarioRepository.save(usuario);
			})
			.orElseGet(() ->{
				
				Usuario conversor = null;
				
				try {
					conversor = service.conversor(usuarioResource);
				} catch (UsuarioResourceException e) {
					LOG.error("Erro no update Usuario: " + e.getMessage(), e);
				}
				conversor.setId(id);
				return usuarioRepository.save(conversor);
			});	
	}
	
	
}
