package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

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

import br.com.ifpe.oxefood.api.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.api.modelo.entregador.EntregadorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {
  @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/debug-raw")


    public List<Object[]> debugRawQuery() {
        System.out.println("--- INICIANDO BUSCA DE DEBUG RAW ---");
        // Esta consulta ignora qualquer restrição do Hibernate (@SQLRestriction)
        List<Object[]> results = entityManager.createNativeQuery("SELECT id, nome, habilitado FROM entregador").getResultList();
        
        System.out.println("Registros encontrados no banco PELA APLICAÇÃO:");
        if (results.isEmpty()) {
            System.out.println("NENHUM REGISTRO ENCONTRADO.");
        } else {
            results.forEach(record -> 
                System.out.println("ID: " + record[0] + ", Nome: " + record[1] + ", Habilitado: " + record[2])
            );
        }
        System.out.println("--- FIM DO DEBUG ---");
        
        return results;
    }
    

    

    private final EntregadorService service;

    public EntregadorController(EntregadorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {
        Entregador novoEntregador = service.save(request.build());
        return new ResponseEntity<>(novoEntregador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Entregador> findAll() {
        return service.findAll();
    }



    @GetMapping("/{id}")
    public Entregador findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable Long id, @RequestBody @Valid EntregadorRequest request) {
        Entregador entregadorAtualizado = service.update(id, request.build());
        return new ResponseEntity<>(entregadorAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}