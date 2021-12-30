package br.com.exactaworks.gastosapi.domain.repository;

import br.com.exactaworks.gastosapi.domain.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
