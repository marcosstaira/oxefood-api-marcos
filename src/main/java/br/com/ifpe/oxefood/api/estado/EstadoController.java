package br.com.ifpe.oxefood.api.estado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.ifpe.oxefood.modelo.estado.Estado;
import br.com.ifpe.oxefood.modelo.estado.EstadoService;
// Import do Jakarta Validation
import jakarta.validation.Valid; 

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*")
public class EstadoController {

    @Autowired
    private EstadoService service; 

    @PostMapping
    public ResponseEntity<Estado> create(@Valid @RequestBody EstadoRequest request) { // <-- @Valid agora é 'jakarta'
        Estado estadoSalvo = service.save(request); 
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @Valid @RequestBody EstadoRequest request) { // <-- @Valid agora é 'jakarta'
        Estado estadoAtualizado = service.update(id, request);
        return ResponseEntity.ok(estadoAtualizado);
    }

    // ... (O restante dos métodos Delete e Get não mudam) ...
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Estado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id) {
        Estado estado = service.findById(id);
        return ResponseEntity.ok(estado);
    }
}