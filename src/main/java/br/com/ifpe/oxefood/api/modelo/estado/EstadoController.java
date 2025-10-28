
package br.com.ifpe.oxefood.api.modelo.estado;

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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/estado")
@CrossOrigin
public class EstadoController {
    @PersistenceContext
    private EntityManager entityManager;

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody @Valid EstadoRequest request) {
        Estado novoEstado = service.save(request.build());
        return new ResponseEntity<>(novoEstado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Estado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Estado findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody @Valid EstadoRequest request) {
        Estado estadoAtualizado = service.update(id, request.build());
        return new ResponseEntity<>(estadoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}