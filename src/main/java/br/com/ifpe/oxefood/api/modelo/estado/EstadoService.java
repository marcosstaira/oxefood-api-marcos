package br.com.ifpe.oxefood.api.modelo.estado;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EstadoService {

    private final EstadoRepository repository;

    public EstadoService (EstadoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Estado save(Estado estado) {
    
        return repository.save(estado);
    }

    public List<Estado> findAll() {
        return repository.findAll();
    }

    public Estado findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado com o ID: " + id));
    }

    @Transactional
    public Estado update(Long id, Estado estadoAlterado) {
        Estado estadoExistente = this.findById(id);

        estadoAlterado.setId(estadoExistente.getId());
        estadoAlterado.setHabilitado(estadoExistente.getHabilitado());
        estadoAlterado.setVersao(estadoExistente.getVersao());
        estadoAlterado.setDataCriacao(estadoExistente.getDataCriacao());
        
        return this.save(estadoAlterado);
    }

    @Transactional
    public void delete(Long id) {
        Estado estado = this.findById(id);
        estado.setHabilitado(false); 
        this.save(estado);
    }
}