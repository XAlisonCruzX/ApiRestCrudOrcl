package br.com.prod.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prod.repository.UsuarioRepository;
import br.com.prod.datasource.model.Usuario;

@Service
public class BuscarUsuarioServiceImpl {

	private static final Logger LOG = Logger.getLogger(BuscarUsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> buscarTodosOsUsuarios(){
		
		LOG.info("Serviço para buscar todos Produtos sendo executado");
		
		List<Usuario> listaUsuario = usuarioRepository.findAll();
	
		return listaUsuario;
	}
	
	
	
}
