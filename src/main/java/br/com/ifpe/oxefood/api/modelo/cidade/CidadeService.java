package br.com.ifpe.oxefood.api.modelo.cidade;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service

public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService (CidadeRepository repository) {
        this.repository = repository;
    }

     @Transactional
    public Cidade save(Cidade cidade) {
    
        return repository.save(cidade);
    }

    public List<Cidade> findAll() {
        return repository.findAll();
    }

    public Cidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrado com o ID: " + id));
    }

    @Transactional
    public Cidade update(Long id, Cidade cidadeAlterada) {
        Cidade cidadeExistente = this.findById(id);

        cidadeAlterada.setId(cidadeExistente.getId());
        cidadeAlterada.setHabilitado(cidadeExistente.getHabilitado());
        cidadeAlterada.setVersao(cidadeExistente.getVersao());
        cidadeAlterada.setDataCriacao(cidadeExistente.getDataCriacao());
        
        return this.save(cidadeAlterada);
    }

    @Transactional
    public void delete(Long id) {
        Cidade cidade = this.findById(id);
        cidade.setHabilitado(false); 
        this.save(cidade);
    }
}