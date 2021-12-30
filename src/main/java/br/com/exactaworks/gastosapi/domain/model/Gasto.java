package br.com.exactaworks.gastosapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pessoa_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_pessoa_id"))
    private Pessoa pessoa;

    private String descricao;

    private LocalDateTime data;

    private BigDecimal valor;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tag", joinColumns = @JoinColumn(name = "gasto_id"))
    private List<Tag> tags;

}
