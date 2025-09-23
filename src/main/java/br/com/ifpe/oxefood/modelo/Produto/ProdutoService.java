package br.com.ifpe.oxefood.modelo.Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
public class ProdutoService {

  public List<Produto> listarTodos() {
  
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

 @Autowired
   private ProdutoRepository repository;

   @Transactional
   public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE);
       return repository.save(produto);
   }
   
}
