package br.com.exactaworks.gastosapi.application.dto;

import br.com.exactaworks.gastosapi.domain.model.Gasto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GastoDto {

    private Long id;

    @NotNull
    @JsonProperty("pessoa")
    private PessoaDto pessoaDto;

    @NotBlank
    private String descricao;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime data;

    @NotNull
    private BigDecimal valor;

    private List<TagDto> tags;

    // TODO: usar MapStruct ou BeanUtils para converter entity <> dtos

    private GastoDto(Gasto gasto) {
        this.id        = gasto.getId();
        this.pessoaDto = PessoaDto.parse(gasto.getPessoa());
        this.descricao = gasto.getDescricao();
        this.data      = gasto.getData();
        this.valor     = gasto.getValor();
        this.tags      = gasto.getTags().stream().map(TagDto::parse).collect(Collectors.toList());
    }

    public static GastoDto parse(Gasto gasto) {
        return new GastoDto(gasto);
    }

    public Gasto toEntity() {
        return Gasto.builder()
                .id(id)
                .pessoa(pessoaDto.toEntity())
                .descricao(descricao)
                .data(data)
                .valor(valor)
                .tags(tags.stream().map(t -> t.toEntity()).collect(Collectors.toList()))
                .build();
    }

}
