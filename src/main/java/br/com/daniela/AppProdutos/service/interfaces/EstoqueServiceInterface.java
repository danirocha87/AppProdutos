package br.com.daniela.AppProdutos.service.interfaces;

import java.util.List;
import java.util.Optional;
import br.com.daniela.AppProdutos.model.Estoque;

public interface EstoqueServiceInterface {

  Estoque save(Estoque estoque);// aqui quero dizer pegue o produto pelo id 
  Optional<Estoque> getById(Long id);//optinal é quando eu digo pego o que tem na frente no caso o produto
  List<Estoque>getAll(); //aqui eu digo pega todos os produtos
  Estoque update(Estoque estoque); //aqui eu digo para atualizar
  void delete(Long id); //aqui eu digo para deletar
  //aqui é sobre as duas funcoes que criamos de acrescentar e decrementar o estoque 
  Estoque addQuantidade(Long id, int quantidade); //aqui para adicionar
                   //aqui é o id que vou atualizar e qual e a quantidade
  Estoque delQuantidade(Long id, int quantidade);//aqui para deletar 
  
}
