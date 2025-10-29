package br.com.ifpe.oxefood.api.estado;

// Imports do Jakarta Validation
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoRequest {
    
    @NotBlank(message = "O nome do estado é obrigatório")
    private String nome;

    @NotBlank(message = "A sigla do estado é obrigatória")
    @Size(min = 2, max = 2, message = "A sigla deve conter exatamente 2 caracteres")
    private String sigla;
}