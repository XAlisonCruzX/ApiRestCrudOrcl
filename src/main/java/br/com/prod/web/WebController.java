package br.com.prod.web;




import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.prod.datasource.model.Pedido;
import br.com.prod.datasource.model.Produto;
import br.com.prod.datasource.model.Usuario;
import br.com.prod.exception.ProdutoResourceException;
import br.com.prod.resource.model.UsuarioResource;
import br.com.prod.webclient.PedidoWEB;
import br.com.prod.webclient.ProdutoWEB;
import br.com.prod.webclient.UsuarioWEB;


@Controller()
@RequestMapping("/web")
public class WebController {
	ProdutoWEB pWEB = new ProdutoWEB();
	PedidoWEB peWEB = new PedidoWEB();
	UsuarioWEB uWEB = new UsuarioWEB();
	Usuario userLogin;
	boolean logado = false;
	Pedido newPedido;
	List<Produto> ofertas;
	List<Produto> produtos;
	List<Usuario> usuarios;
	List<Pedido> pedidos;
	List<Produto> carrinho = new ArrayList<>();
	
	
	@GetMapping(value = "/produto/all" )
	public ModelAndView produtoAll() {
		
		
		ModelAndView mv = new ModelAndView();
		Iterable<Produto> all = pWEB.getAll();
		mv.setViewName("Produtos");
		mv.addObject("produtos", all);
		mv.addObject("logado", this.logado);		
		mv.addObject("usuario", (Usuario) this.userLogin);
		
		return mv;
	}
	
	@GetMapping(value = "/produto/carrinho" )
	public ModelAndView produtoCarrinho() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("carrinho");
		
		mv.addObject("logado", this.logado);		
		mv.addObject("usuario", (Usuario) this.userLogin);
		mv.addObject("carrinho", (ArrayList<Produto>) this.carrinho);
		return mv;
	}
	@GetMapping(value = "/produto/pedido" )
	public ModelAndView produtoPedido() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("form");
		
		mv.addObject("logado", this.logado);		
		mv.addObject("usuario", (Usuario) this.userLogin);
		mv.addObject("compra", (Pedido) this.newPedido);
		return mv;
	}
	@GetMapping(value = "/produto/menu" )
	public ModelAndView produtoMenu() {
		
		ModelAndView mv = new ModelAndView();
		List<Produto> ofertas  = pWEB.getAll();
		this.produtos = ofertas;
		for(int i = 0; i< ofertas.size(); i++) {
			ofertas.remove(i);
		}
		this.ofertas = ofertas;
		mv.setViewName("index");	
				
		mv.addObject("produtos", ofertas);
		mv.addObject("logado", this.logado);		
		mv.addObject("usuario", (Usuario) this.userLogin);

		
		return mv;
	}
	
	@GetMapping(value = "/produto/cad" )
	public ModelAndView produtoCad(@ModelAttribute Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cadastro");	
		
		
		mv.addObject("logado", this.logado);
		mv.addObject("usuario", (Usuario) this.userLogin);
		
		return mv;
	}
	
	@PostMapping(value = "/produto/cad" )
	public String produtoCadastro(UsuarioResource usuario) throws  ParseException {
		usuario.setPrivilege("user");			
		uWEB.save(usuario);
		return "redirect:/web/produto/all";
	}
	
	@PostMapping(value = "/produto/pedido" )
	public String produtoPedido(Pedido pedido) {
		peWEB.save(pedido);
		return "redirect: /web/produto/carrinho";
	}
	
	@PostMapping(value = "/produto/save" )
	public String produto(Produto produto) {
		pWEB.save(produto);
		return "redirect:/web/produto/all";
	}
	
	@PostMapping(value = "produto/login")
	public String userLogin(@ModelAttribute Usuario usuario) {
		List<Usuario> usuarios = uWEB.getAll();
		this.usuarios = usuarios;
		for(Usuario u : usuarios) {
			if(u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha())) {			
				this.userLogin = u;							
			}
		}
		
		if(this.userLogin != null) {
			this.logado = true;
						
		
		}else {
			this.logado = false;
		
		}
				
		return "redirect:/web/produto/menu";
	}
	
	@PostMapping(value = "/produto/logout")
	public String userLogout(@ModelAttribute Usuario usuario) {		
		
		this.userLogin = null;
		this.logado = false;
	
		
		return "redirect:/web/produto/menu";
	}
	
	@PostMapping(value = "/produto/addcart")
	public String userAddCart(String id) throws ProdutoResourceException {		
		Produto produto = pWEB.getById(id);
		this.carrinho.add(produto);			
		return "redirect:/web/produto/carrinho";
	}
	@PostMapping(value = "/produto/removecart")
	public String userRemoveCart(String id) throws ProdutoResourceException {		
		
		for(int i = 0; i<this.carrinho.size(); i++) {
			if(id.equals(this.carrinho.get(i).getId().toString())){
				this.carrinho.remove(i);
			}
			
			
			
		}
				
		return "redirect:/web/produto/carrinho";
	}
	
	@PostMapping(value = "/produto/compra")
	public String userFinalizar(String id) {		
	
		if(this.logado == false) {
			return "redirect:/web/produto/carrinho";
		}else {
			Produto produto = pWEB.getById(id);
			Pedido p = new Pedido();
			p.setId_produto(produto.getId());
			p.setId_usuario(this.userLogin.getId());
			p.setEndereco(this.userLogin.getEndereco());
			p.setQuantidade(1);
			this.newPedido = p;
			
			return "redirect:/web/produto/pedido";
		}
		
	}
	
	@GetMapping(value = "/produto/compra/add")
	public String userFinalizar() {		
		peWEB.save(this.newPedido);
		
		for(int i = 0; i< this.carrinho.size(); i++) {
			if(this.carrinho.get(i).getId().equals(this.newPedido.getId_produto())) {
				this.carrinho.remove(i);				
			}						
		}
		
		return "redirect:/web/produto/carrinho";
	}
	
	

	
	
	
	
	
	
	
}
