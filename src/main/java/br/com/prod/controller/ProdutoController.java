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

import br.com.prod.datasource.model.Produto;
import br.com.prod.exception.ProdutoNotFoundException;
import br.com.prod.resource.model.ProdutoResource;
import br.com.prod.service.BuscarProdByIdService;
import br.com.prod.service.BuscarProdutoServiceImpl;
import br.com.prod.service.CadastroProduto;
import br.com.prod.service.UpdateProdutoService;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	
	@Autowired
	private BuscarProdutoServiceImpl serviceBuscar;
	@Autowired
	private CadastroProduto serviceCadastro;
	@Autowired
	private BuscarProdByIdService serviceId;
	@Autowired
	private UpdateProdutoService serviceUpdate;
	
	//FINDBYID
	@GetMapping(path = "/produto/id/{id}")
	public Produto buscarProdutoPorId(
			@PathVariable(name = "id", required = true) Long idProduto) throws ProdutoNotFoundException{
		
		return serviceId.buscarPorId(idProduto);
	}
	
	//FINDALL
	@GetMapping(path = "/produto")
	public List<Produto> buscarProduto(){
		return serviceBuscar.buscarTodosOsProdutos();
		
	}
	
	//SAVE
	@PostMapping(path = "cproduto/save")
	public void salvarProduto(
			@RequestBody ProdutoResource produtoResource ){
		
		serviceCadastro.cadastro(produtoResource);
		
	}
	//DELETE BY ID
	@DeleteMapping(path = "/delete/produto/{id}")
	public void deleteProduto(
			@PathVariable(name = "id", required = true)Long idProduto) throws ProdutoNotFoundException {
		
		serviceId.deletarPorId(idProduto);
		
	}
	//UPDATE
	@PutMapping(path = "cproduto/update/{id}")
	public void updateUsuario(
			@PathVariable(name = "id", required = true)Long idUsuario,
			@RequestBody ProdutoResource produtoResource ){
		serviceUpdate.updateProduto(idUsuario, produtoResource);
		
	}
	

	
}
