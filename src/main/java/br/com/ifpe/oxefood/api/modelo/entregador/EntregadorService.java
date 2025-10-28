package br.com.ifpe.oxefood.api.modelo.entregador;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    private final EntregadorRepository repository;

    public EntregadorService(EntregadorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Entregador save(Entregador entregador) {
    
        return repository.save(entregador);
    }

    public List<Entregador> findAll() {
        return repository.findAll();
    }

    public Entregador findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado com o ID: " + id));
    }

    @Transactional
    public Entregador update(Long id, Entregador entregadorAlterado) {
        Entregador entregadorExistente = this.findById(id);

        entregadorAlterado.setId(entregadorExistente.getId());
        entregadorAlterado.setHabilitado(entregadorExistente.getHabilitado());
        entregadorAlterado.setVersao(entregadorExistente.getVersao());
        entregadorAlterado.setDataCriacao(entregadorExistente.getDataCriacao());
        
        return this.save(entregadorAlterado);
    }

    @Transactional
    public void delete(Long id) {
        Entregador entregador = this.findById(id);
        entregador.setHabilitado(false); 
        this.save(entregador);
    }
}
