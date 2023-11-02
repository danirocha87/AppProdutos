package br.com.daniela.AppProdutos.resource;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniela.AppProdutos.model.Produto;
import br.com.daniela.AppProdutos.service.ProdutoService;

@RestController //CONTROLADOR REST
@CrossOrigin(origins = "*")
@RequestMapping("/api/produtos") //aqui é a rota exemplo http://localhost:8080/api/produtos
public class ProdutoResource {


// aqui eu importo onde esta os nossos comandos implementados que no caso esta no Service
  private ProdutoService produtoService;

  @Autowired
  public ProdutoResource(ProdutoService produtoService)
  {
    this.produtoService=produtoService;
  }

  @GetMapping // aqui pego todos 
  public ResponseEntity<List<Produto>> getAllProdutos()
  {
    List<Produto> produtos =produtoService.getAll();
    //aqui faço uma verificação para saber se tem , foi la no serviço pegou tudo e trouxe para ca
    //tenho produto aqui na tela, se sim blz mostra na tela se não ele é nulo
    if(produtos == null)
     return ResponseEntity.notFound().build();
    return ResponseEntity.ok(produtos);
  }

  
  @GetMapping("/{id}") //http://localhost:8080/api/produtos/12 -aqui pelo pego id
	public ResponseEntity<Optional<Produto>> getById(@PathVariable Long id){//uso PathVariable para poder ligar o id do getByID com o id do GetMapping
		Optional<Produto> produto = produtoService.getById(id);
		if(produto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(produto);
	}


@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto){
		Produto newProduto = produtoService.save(produto);
		if(newProduto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newProduto);
	}



  @PutMapping //aqui eu atualizo a informacao
	public ResponseEntity<Produto> update(@RequestBody Produto produto){
		Produto newProduto = produtoService.update(produto);
		if(newProduto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newProduto);
	}

  @DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
