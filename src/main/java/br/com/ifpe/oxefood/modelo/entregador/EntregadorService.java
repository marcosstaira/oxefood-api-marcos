package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    private final EntregadorRepository repository;

    // Injeção de dependência via construtor (prática recomendada)
    public EntregadorService(EntregadorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Entregador save(Entregador entregador) {
        // Aqui você pode adicionar regras de negócio antes de salvar
        // Ex: validar CPF, verificar se já existe, etc.
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
        // Garante que o entregador com o ID especificado existe antes de tentar atualizar
        Entregador entregadorExistente = this.findById(id);

        // Copia as propriedades, mas mantém o ID e os dados de auditoria
        entregadorAlterado.setId(entregadorExistente.getId());
        entregadorAlterado.setHabilitado(entregadorExistente.getHabilitado());
        entregadorAlterado.setVersao(entregadorExistente.getVersao());
        entregadorAlterado.setDataCriacao(entregadorExistente.getDataCriacao());
        
        return this.save(entregadorAlterado);
    }

    @Transactional
    public void delete(Long id) {
        // Em vez de deletar de verdade, faremos um "soft delete"
        Entregador entregador = this.findById(id);
        entregador.setHabilitado(false); // Apenas desabilita o entregador
        this.save(entregador);
    }
}
