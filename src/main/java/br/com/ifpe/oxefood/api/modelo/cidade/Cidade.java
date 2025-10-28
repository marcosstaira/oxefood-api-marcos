package br.com.ifpe.oxefood.api.modelo.cidade;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Cidade")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cidade extends EntidadeAuditavel  {
  
   @Column
   private String nome;

   @Column
   private Integer qtdPopulacao;

   @Column
   private Boolean ehCapital;

   @Column
   private LocalDate dataFundacao;

}
