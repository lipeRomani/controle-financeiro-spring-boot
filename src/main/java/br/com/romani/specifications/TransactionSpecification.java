package br.com.romani.specifications;


import br.com.romani.entities.CashDesk;
import br.com.romani.entities.Transaction;
import br.com.romani.entities.Transaction_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TransactionSpecification {

    public static Specification<Transaction> findBy(CashDesk cashDesk){
        return new Specification<Transaction>() {
            @Override
            public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Transaction_.cashDesk),cashDesk);
            }
        };
    }

}
