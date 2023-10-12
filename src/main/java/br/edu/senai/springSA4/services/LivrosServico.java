package br.edu.senai.springSA4.services;

import java.util.List;

import br.edu.senai.springSA4.orm.Livros;

public interface LivrosServico {
	
public List<Livros> listarLivros();
	
	public Livros salvarLivros(Livros livros);
	
	public void apagarLivros(Integer id);
	
	public Livros consultarLivrosId(Integer id);
	
	public Livros atualizarLivros(Livros livros);

}
