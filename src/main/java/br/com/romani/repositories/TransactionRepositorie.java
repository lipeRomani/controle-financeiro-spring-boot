package br.com.romani.repositories;


import br.com.romani.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepositorie extends CrudRepository<Transaction, Integer>, JpaSpecificationExecutor<Transaction> {

    Transaction save(Transaction transaction);

    @Override
    Page<Transaction> findAll(Specification<Transaction> specification, Pageable pageable);
}
