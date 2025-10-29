package br.com.ifpe.oxefood.modelo.estado;

// Import da SUA Entidade Auditavel
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
// Imports do Jakarta Persistence
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
// Imports do Jakarta Validation
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
// Imports do Lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estado")
@Getter
@Setter
@Builder 
@NoArgsConstructor
@AllArgsConstructor 
public class Estado extends EntidadeAuditavel {

    @NotBlank(message = "O nome do estado é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A sigla do estado é obrigatória")
    @Size(min = 2, max = 2, message = "A sigla deve conter exatamente 2 caracteres")
    @Column(nullable = false, length = 2)
    private String sigla;
}