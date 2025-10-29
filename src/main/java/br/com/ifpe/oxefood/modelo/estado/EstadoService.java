package br.com.ifpe.oxefood.modelo.estado; // <-- PACOTE CORRIGIDO

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ifpe.oxefood.api.estado.EstadoRequest; 


@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    @Transactional
    public Estado save(EstadoRequest request) { // <-- Recebe EstadoRequest

        Estado estado = new Estado();
        estado.setNome(request.getNome());
        estado.setSigla(request.getSigla());
       
        return repository.save(estado);
    }

    @Transactional
    public Estado update(Long id, EstadoRequest request) { // <-- Recebe EstadoRequest

        Estado estadoBD = this.findById(id);
        estadoBD.setNome(request.getNome());
        estadoBD.setSigla(request.getSigla());

        return repository.save(estadoBD);
    }

    @Transactional
    public void delete(Long id) {
        Estado estadoBD = this.findById(id); 
        repository.deleteById(estadoBD.getId());
    }

    public List<Estado> findAll() {
        return repository.findAll();
    }

    public Estado findById(Long id) {
        Optional<Estado> estado = repository.findById(id);
        
        if (estado.isEmpty()) {
            throw new RuntimeException("Estado não encontrado com o ID: " + id);
        }
        return estado.get();
    }
}