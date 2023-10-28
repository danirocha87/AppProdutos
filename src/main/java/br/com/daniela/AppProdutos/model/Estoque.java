package br.com.daniela.AppProdutos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//atributos
@Entity //Aqui falo que é uma tabela para meu banco de dados 
@Table(name = "estoque") //aqui coloco o nome no meu banco de dados 
public class Estoque {
  
  @Id//aqui informo que é meu id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//aqui eu falo que ela é autoincremento
  private Long id;


  //aqui vou lincar meu estoque no produto
  //ela é um para um um produto relaciona a 1 estoque 
  @OneToOne(cascade = CascadeType.ALL)//aqui eu fiz uma estrategia de que se eu deletar um produto deleto o estoque tambem 
  @JoinColumn(name = "produto_id", referencedColumnName = "id")//aqui uso para dizer que o nome do meu campo vai ser produto_id
  private Produto produto;
  
  @Column(nullable = false)
  private Integer quantidade;
  
//construtores
public Estoque() {}

public Estoque(Long id, Produto produto, Integer quantidade)
{
  this.id= id;
  this.produto=produto;
  this.quantidade=quantidade;
}

public void adicionarEstoque(int quantidade)
{
  //aqui eu estou somanda a quantidade de estoque atual + somar com o que eu to passando
  this.quantidade += quantidade;
  // o += é a mesma coisa que this.quantidade = this.quantidade + quantidade
}

public void removerEstoque(int quantidade)
{
  this.quantidade -= quantidade;
  // o -= é a mesma coisa que this.quantidade = this.quantidade - quantidade
}


public Long getId() {
  return id;
}

public void setId(Long id) {
  this.id = id;
}

public Produto getProduto() {
  return produto;
}

public void setProduto(Produto produto) {
  this.produto = produto;
}

public Integer getQuantidade() {
  return quantidade;
}

public void setQuantidade(Integer quantidade) {
  this.quantidade = quantidade;
}

@Override
public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((id == null) ? 0 : id.hashCode());
  return result;
}

@Override
public boolean equals(Object obj) {
  if (this == obj)
    return true;
  if (obj == null)
    return false;
  if (getClass() != obj.getClass())
    return false;
  Estoque other = (Estoque) obj;
  if (id == null) {
    if (other.id != null)
      return false;
  } else if (!id.equals(other.id))
    return false;
  return true;
}

}
