package br.com.exactaworks.gastosapi.application.controller;

import br.com.exactaworks.gastosapi.application.dto.GastoDto;
import br.com.exactaworks.gastosapi.domain.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService gastoService;

    @PostMapping
    public ResponseEntity<GastoDto> salvar(@Valid @RequestBody GastoDto gastoDto) {
        var resultado = gastoService.salvar(gastoDto.toEntity());
        return ResponseEntity.ok(GastoDto.parse(resultado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoDto> buscarPorId(@PathVariable Long id) {
        var resultado = gastoService.buscarPorId(id);
        if(resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GastoDto.parse(resultado.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        gastoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page> listar(@RequestParam int pagina,
                                       @RequestParam int tamanho) {
        var resultado = gastoService.listar(pagina, tamanho);
        return ResponseEntity.ok(resultado);
    }

}
