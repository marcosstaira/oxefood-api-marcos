package br.com.ifpe.oxefood.api.modelo.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Produto save(Produto produto) {
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    @Transactional
    public Produto update(Long id, Produto produtoAlterado) {
        Produto produtoExistente = this.findById(id);

        produtoExistente.setCodigo(produtoAlterado.getCodigo());
        produtoExistente.setTitulo(produtoAlterado.getTitulo());
        produtoExistente.setDescricao(produtoAlterado.getDescricao());
        produtoExistente.setValorUnitario(produtoAlterado.getValorUnitario());
        produtoExistente.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produtoExistente.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        
        return repository.save(produtoExistente);
    }

    @Transactional
    public void delete(Long id) {
        Produto produto = this.findById(id);
        produto.setHabilitado(false); 
        repository.save(produto);
    }
}