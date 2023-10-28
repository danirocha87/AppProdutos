package br.com.daniela.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniela.AppProdutos.exception.ResourceNotFoundException;
import br.com.daniela.AppProdutos.model.Estoque;
import br.com.daniela.AppProdutos.repository.EstoqueRepository;
import br.com.daniela.AppProdutos.service.interfaces.EstoqueServiceInterface;

@Service
public class EstoqueService implements EstoqueServiceInterface {

   //aqui eu crio um objeto para juntar o repository com o service
  private EstoqueRepository estoqueRepository;

  //aqui eu estou instanciando a classe de service com o construtor
  @Autowired
  public EstoqueService(EstoqueRepository estoqueRepository)
  {
    this.estoqueRepository=estoqueRepository;
  }

 //metodos implementados

  //aqui eu retorno o que tenho no repository
  @Override
  public Estoque save(Estoque estoque) {
    return estoqueRepository.save(estoque);
  }

  //aqui eu pego por id
  @Override
  public Optional<Estoque> getById(Long id) {
    return estoqueRepository.findById(id);
  }

  //aqui eu pego todos
  @Override
  public List<Estoque> getAll() {
    return estoqueRepository.findAll();
  }

  @Override
	public Estoque update(Estoque estoque) {
		Optional<Estoque> upEstoque = estoqueRepository.findById(estoque.getId());
		
		if(upEstoque.isPresent()) {
			Estoque newEstoque = upEstoque.get();
			newEstoque.setProduto(estoque.getProduto());
			newEstoque.setQuantidade(estoque.getQuantidade());
			return estoqueRepository.save(newEstoque);
		}
		return estoque;
	}

  @Override
  public void delete(Long id) {
   estoqueRepository.deleteById(id);
  }

  @Override
	public Estoque addQuantidade(Long id, int quantidade) {
		return estoqueRepository.findById(id) //AQUI EU TENTEI ACHAR O MEU ID
				.map(estoque -> { //AQUI ESTOU MAPEANDO E CRIEI UMA FUNCAO
					estoque.setQuantidade(estoque.getQuantidade() + quantidade);//AQUI EU PEGO A QUANTIDADE + O QUE QUERO ADICIONAR 
					return estoqueRepository.save(estoque); //AQUI RETORNO 
				}).orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado no ID: " + id));//AQUI É A CONDICAO DE ERRO 
	}

	@Override
	public Estoque delQuantidade(Long id, int quantidade) {
		return estoqueRepository.findById(id)//PEGO MEU ID
				.map(estoque -> {//MAPEANDO
					estoque.setQuantidade(estoque.getQuantidade() - quantidade);//AQUI EU PEGO A QUANTIDADE -A QUANTIDADE QUE EU QUERO
					return estoqueRepository.save(estoque);//AQUI EU DOU O RETORNO
				}).orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado no ID: " + id));
	}
  
}
