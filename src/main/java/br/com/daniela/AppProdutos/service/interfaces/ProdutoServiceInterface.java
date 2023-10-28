package br.com.daniela.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;



import br.com.daniela.AppProdutos.model.Produto;

public interface ProdutoServiceInterface {

  Produto save(Produto produto);// aqui quero dizer pegue o produto pelo id 
  Optional<Produto> getById(Long id);//optinal é quando eu digo pego o que tem na frente no caso o produto
  List<Produto> getAll(); //aqui eu digo pega todos os produtos
  Produto update(Produto produto); //aqui é para atualizar
  void delete(Long id); //aqui eu deleto por id
}

