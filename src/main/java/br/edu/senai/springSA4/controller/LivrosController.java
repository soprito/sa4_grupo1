package br.edu.senai.springSA4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.senai.springSA4.orm.Livros;
import br.edu.senai.springSA4.services.LivrosServico;

@Controller

  
public class LivrosController {
	
	@Autowired
	private LivrosServico servico;
	
	@GetMapping({"/"})
	public String path() {
        return "index";
    }
	
	@GetMapping({"/livros"})
	public String listarLivros(Model modelo) {
        modelo.addAttribute("livros", servico.listarLivros());
		return "livros";
    }
	
	@GetMapping("/livros/adicionar")
	public String adicionarLivros(Model modelo) {
		Livros objlivros = new Livros();
		modelo.addAttribute("livros", objlivros);
		return "livrosform";
	}
	
	@PostMapping("/livros")
	public String salvarLivros(@ModelAttribute("livros") Livros objlivros) {
		servico.salvarLivros(objlivros);
		return "redirect:/livros";
	}
	
	@GetMapping({"/livros/{id}"})
	public String apagarLivros(@PathVariable Integer id) {
		servico.apagarLivros(id);
		return "redirect:/livros";
	}
	
	@GetMapping({"/livros/editar/{id}"})
	public String editarLivros(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("livros", servico.consultarLivrosId(id));
		return "editarLivros";
	}
	
	@PostMapping("/livros/{id}")
	public String atualizarLivros(@PathVariable Integer id, @ModelAttribute("livros") Livros livros, Model modelo) {
		
		Livros liv = servico.consultarLivrosId(id);
		liv.setTitulo(livros.getTitulo());
		liv.setAutor(livros.getAutor());
		liv.setIsbn(livros.getIsbn());
		servico.atualizarLivros(liv);
		return "redirect:/livros";
	}

}
