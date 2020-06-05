package br.com.prod.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioResourceException;
import br.com.prod.repository.UsuarioRepository;
import br.com.prod.resource.model.UsuarioResource;

@Service
public class CadastroUsuario {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioConversor service;
	
	private static final Logger LOG = Logger.getLogger(CadastroUsuario.class);
	
	public void cadastro(UsuarioResource usuarioResource){
		
		
		try {
			Usuario usuario  = service.conversor(usuarioResource);
			usuarioRepository.saveAndFlush(usuario);
		} catch (UsuarioResourceException e) {
			LOG.error("Erro ao salvar produto: " + e.getMessage(), e);
		}
	
		
	}	
}
	

