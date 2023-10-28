package br.com.daniela.AppProdutos.exception;


public class ResourceNotFoundException  extends RuntimeException{
  
  public ResourceNotFoundException(String message)
  {
    super(message);
  }
  
}
