package br.com.prod.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioNotFoundException;
import br.com.prod.repository.UsuarioRepository;

@Service
public class BuscarByIdUserService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscarPorId(Long id) throws UsuarioNotFoundException{
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		Usuario usuario = null;
		if(!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException(
					"Produto não encontrado através do id");
		}else {
			usuario = optionalUsuario.get();
		}
		
		
		return usuario;	
	}
	
	public void deletarPorId(Long id) throws UsuarioNotFoundException{
			
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if(!optionalUsuario.isPresent()) {
			throw new UsuarioNotFoundException(
					"Produto não encontrado através do id");
		}else {
			usuarioRepository.delete(optionalUsuario.get());;
		}
	}
	
	
	
}
