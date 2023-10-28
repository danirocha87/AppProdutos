package br.com.daniela.AppProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.daniela.AppProdutos.model.Produto;

@Repository //aqui indico que é um repositorio
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

  
  
}
