package br.com.daniela.AppProdutos.resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniela.AppProdutos.model.Produto;
import br.com.daniela.AppProdutos.service.ProdutoService;

@RestController //CONTROLADOR REST
@RequestMapping("/api/produtos") //aqui é a rota exemplo http://localhost:8080/api/produtos
public class ProdutoResource {


// aqui eu importo onde esta os nossos comandos implementados que no caso esta no Service
  private ProdutoService produtoService;

  @Autowired
  public ProdutoResource(ProdutoService produtoService)
  {
    this.produtoService=produtoService;
  }

  @GetMapping
  public ResponseEntity<List<Produto>> getAllProdutos()
  {
    List<Produto> produtos =produtoService.getAll();
    //aqui faço uma verificação para saber se tem , foi la no serviço pegou tudo e trouxe para ca
    //tenho produto aqui na tela, se sim blz mostra na tela se não ele é nulo
    if(produtos == null)
     return ResponseEntity.notFound().build();
    return ResponseEntity.ok(produtos);
  }
  
}
