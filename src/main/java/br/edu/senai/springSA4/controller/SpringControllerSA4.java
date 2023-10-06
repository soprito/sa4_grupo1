package br.edu.senai.springSA4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.senai.springSA4.orm.Categoria;
import br.edu.senai.springSA4.services.CategoriaServico;

@Controller
public class SpringUC9Controller {
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping({"/"})
	public String path() {
        return "index";
    }
	
	@GetMapping({"/categorias"})
	public String listarCategorias(Model modelo) {
        modelo.addAttribute("categoria", servico.listarCategorias());
		return "categorias";
    }
	
	@GetMapping("/categorias/adicionar")
	public String adicionarCategorias(Model modelo) {
		Categoria objcategoria = new Categoria();
		modelo.addAttribute("categoria", objcategoria);
		return "categoriaform";
	}
	
	@PostMapping("/categoria")
	public String salvarCategorias(@ModelAttribute("categoria") Categoria objcategoria) {
		servico.salvarCategorias(objcategoria);
		return "redirect:/categorias";
	}
}
