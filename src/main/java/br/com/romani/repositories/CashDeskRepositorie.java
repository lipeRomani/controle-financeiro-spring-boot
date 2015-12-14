package br.com.romani.repositories;

import br.com.romani.entities.CashDesk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


public interface CashDeskRepositorie extends CrudRepository<CashDesk, Integer>, JpaSpecificationExecutor<CashDesk> {
    CashDesk save(CashDesk cashDesk);

    @Override
    Page<CashDesk> findAll(Specification<CashDesk> specification, Pageable pageable);

    Page<CashDesk> findAll(Pageable pageable);
    CashDesk findByName(String name);
}
