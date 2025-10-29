package br.com.ifpe.oxefood.modelo.cidade;

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
@RequestMapping("/api/cidade")
@CrossOrigin
public class CidadeController {
  @PersistenceContext
    private EntityManager entityManager;

    private final CidadeService service;

    public CidadeController(CidadeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody @Valid CidadeRequest request) {
        Cidade novaCidade = service.save(request.build());
        return new ResponseEntity<>(novaCidade, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Cidade> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cidade findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> update(@PathVariable Long id, @RequestBody @Valid CidadeRequest request) {
        Cidade cidadeAtualizada = service.update(id, request.build());
        return new ResponseEntity<>(cidadeAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}