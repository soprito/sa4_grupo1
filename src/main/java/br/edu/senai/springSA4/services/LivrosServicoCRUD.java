	package br.edu.senai.springSA4.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senai.springSA4.orm.Livros;
import br.edu.senai.springSA4.repository.LivrosRepository;

@Service

public class LivrosServicoCRUD implements LivrosServico{
	@Autowired
	private LivrosRepository repositorio;
	
	public List<Livros> listarLivros(){
		return (List<Livros>)repositorio.findAll();
	}
	
	public Livros salvarLivros(Livros livros) {
		return repositorio.save(livros);
	}
	
	public void apagarLivros(Integer id) {
		repositorio.deleteById(id);
	}
	
	public Livros consultarLivrosId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Livros atualizarLivros(Livros livros) {
		return repositorio.save(livros);
	}
}
