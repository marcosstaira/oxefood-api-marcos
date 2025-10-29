package br.com.ifpe.oxefood.api.entregador;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    private String cpf;

    private String rg;

    @NotNull(message = "A data de nascimento é de preenchimento obrigatório")
    private LocalDate dataNascimento;

    @NotBlank(message = "O fone celular é de preenchimento obrigatório")
    private String foneCelular;

    private String foneFixo;
    
    private BigDecimal valorFrete;

    private String enderecoRua;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoUf;
    private String enderecoComplemento;

    private Boolean ativo;


    public Entregador build() {
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .valorFrete(valorFrete)
                .enderecoRua(enderecoRua)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoUf(enderecoUf)
                .enderecoComplemento(enderecoComplemento)
                .ativo(ativo)
                .build();
    }
}