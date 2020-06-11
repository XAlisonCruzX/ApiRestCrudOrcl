package br.com.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.UsuarioNotFoundException;
import br.com.prod.resource.model.UsuarioResource;
import br.com.prod.service.BuscarByIdUserService;
import br.com.prod.service.BuscarUsuarioServiceImpl;
import br.com.prod.service.CadastroUsuario;
import br.com.prod.service.UpdateUsuarioService;
@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	private BuscarUsuarioServiceImpl serviceBuscar;
	@Autowired
	private BuscarByIdUserService serviceId;
	@Autowired
	private CadastroUsuario serviceCadastro;
	@Autowired
	private UpdateUsuarioService serviceUpdate;
	
	//FINDALL
	@GetMapping(path = "/usuario")
	public List<Usuario> buscarUsuario(){	
		return serviceBuscar.buscarTodosOsUsuarios();	
	}
	//FINDBYID
	@GetMapping(path = "/usuario/id/{id}")
	public Usuario buscarUsuarioPorId(
			@PathVariable(name = "id", required = true)Long idUsuario) throws UsuarioNotFoundException {
		
		return serviceId.buscarPorId(idUsuario);
	}
	//DELETEBYID
	@DeleteMapping(path = "/delete/usuario/{id}")
	public void deleteUsuario(
			@PathVariable(name = "id", required = true)Long idUsuario) throws UsuarioNotFoundException {	
		
		serviceId.deletarPorId(idUsuario);
	}
	
	//SAVE
	@PostMapping(path = "cusuario/save")
	public void salvarUsuario(
			@RequestBody UsuarioResource usuarioResource ){
		
		serviceCadastro.cadastro(usuarioResource);
		
	}
	
	//UPDATE
	@PutMapping(path = "cusuario/update/{id}")
	public Usuario updateUsuario(
			@PathVariable(name = "id", required = true)Long idUsuario,
			@RequestBody UsuarioResource usuarioResource ){
		return serviceUpdate.updateUsuario(idUsuario, usuarioResource);
		
	}
	
	
	
	
	
	
}
