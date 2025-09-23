package br.com.ifpe.oxefood.modelo.entregador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    // JpaRepository<Entregador, Long> significa:
    // - Gerencia a entidade "Entregador"
    // - O tipo da chave primária (ID) é "Long"
}