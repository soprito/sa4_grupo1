package br.edu.senai.springSA4.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senai.springSA4.orm.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {

}
