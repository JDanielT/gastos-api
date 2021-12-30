package br.com.exactaworks.gastosapi.application.dto;

import br.com.exactaworks.gastosapi.domain.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TagDto {

    private String descricao;

    private TagDto(Tag tag) {
        this.descricao = tag.getDescricao();
    }

    public static TagDto parse(Tag tag) {
        return new TagDto(tag);
    }

    public Tag toEntity() {
        return Tag.builder()
                .descricao(descricao)
                .build();
    }

}
