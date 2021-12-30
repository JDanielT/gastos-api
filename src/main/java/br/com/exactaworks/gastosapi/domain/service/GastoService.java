package br.com.exactaworks.gastosapi.domain.service;

import br.com.exactaworks.gastosapi.domain.model.Gasto;
import br.com.exactaworks.gastosapi.domain.repository.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository repository;

    public Gasto salvar(Gasto gasto) {
        return repository.save(gasto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<Gasto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Page<Gasto> listar(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by("id"));
        return repository.findAll(pageable);
    }

}
