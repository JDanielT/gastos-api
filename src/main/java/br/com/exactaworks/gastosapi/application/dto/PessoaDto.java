package br.com.exactaworks.gastosapi.application.dto;

import br.com.exactaworks.gastosapi.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PessoaDto {

    private Long id;
    private String nome;

    private PessoaDto(Pessoa pessoa) {
        this.id   = pessoa.getId();
        this.nome = pessoa.getNome();
    }

    public static PessoaDto parse(Pessoa pessoa) {
        return new PessoaDto(pessoa);
    }

    public Pessoa toEntity() {
        return Pessoa.builder()
                .id(id)
                .nome(nome)
                .build();
    }

}