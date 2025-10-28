package br.com.ifpe.oxefood.api.modelo.cidade;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CidadeRequest
 {

    private String nome;
    private Integer qtdPopulacao;
    private Boolean ehCapital;
    private LocalDate dataFundacao;

    public Cidade build() {
        return Cidade.builder()
                .nome(nome)
                .qtdPopulacao(qtdPopulacao)
                .ehCapital(ehCapital)
                .dataFundacao(dataFundacao)
                .build();
    }
}