package br.com.romani.repositories;

import br.com.romani.entities.TransactionType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer>, JpaSpecificationExecutor<TransactionType> {

    @Query("select t from TransactionType t")
    List<TransactionType> findAll();

    @Override
    TransactionType save(TransactionType transactionType);

   TransactionType findByName(String name);
}
