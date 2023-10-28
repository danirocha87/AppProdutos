package br.com.daniela.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniela.AppProdutos.model.Produto;
import br.com.daniela.AppProdutos.repository.ProdutoRepository;
import br.com.daniela.AppProdutos.service.interfaces.ProdutoServiceInterface;

@Service
public class ProdutoService implements ProdutoServiceInterface {

  //aqui eu crio um objeto para juntar o repository com o service
  private ProdutoRepository produtoRepository;

  //aqui eu estou instanciando a classe de service com o construtor
  @Autowired
  public ProdutoService(ProdutoRepository produtoRepository)
  {
    this.produtoRepository=produtoRepository;
  }

  //metodos implementados
  @Override
  public Produto save(Produto produto) {
   return produtoRepository.save(produto);//aqui eu retorno o que tenho no repository
  }

  @Override
  public Optional<Produto> getById(Long id) {
   return produtoRepository.findById(id);
  }

  @Override
  public List<Produto> getAll() {
   return produtoRepository.findAll();
  }

  //aqui eu faço uma verificacao do produto que estou pegando 
  @Override
	public Produto update(Produto produto) {
		//encontrei o produto
		Optional<Produto> upProduto = produtoRepository.findById(produto.getId());
		
		//se ele existir, atualizar:
		if(upProduto.isPresent()) {
			Produto newProduto = upProduto.get();
			newProduto.setCodigoBarras(produto.getCodigoBarras());
			newProduto.setNome(produto.getNome());
			newProduto.setPreco(produto.getPreco());
			return produtoRepository.save(newProduto);
		}
		return produto;
	}

  @Override
  public void delete(Long id) {
   produtoRepository.deleteById(id);
  }
  
}
