package br.com.daniela.AppProdutos.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // falo que é uma entidade jpa
@Table(name = "produtos") //aqui coloco o nome da tabela
public class Produto {

  //atributos
  //bigdecimal tem que importa'2
  @Id //aqui fala que é um id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//aqui eu falo que ela é autoincremento
  private Long id;
  
  @Column(nullable = false, unique = true)//aqui nullable eu digo que ele não pode ser nulo
  private String codigoBarras;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private BigDecimal preco;

  //construtores
  public Produto() {}
  
	public Produto(Long id, String codigoBarras, BigDecimal preco, String nome)
  {
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.preco = preco;
    this.nome=nome;
	}

 //funcoes para alterar o atribruto get e set
 
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCodigoBarras() {
    return codigoBarras;
  }
  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }
  public BigDecimal getPreco() {
    return preco;
  }
  public void setPreco(BigDecimal preco) {
    this.preco = preco;
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
    Produto other = (Produto) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

 
 

  
}
