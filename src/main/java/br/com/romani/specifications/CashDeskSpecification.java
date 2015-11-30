package br.com.romani.specifications;


import br.com.romani.entities.CashDesk;
import br.com.romani.entities.CashDesk_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CashDeskSpecification {

    public static Specification<CashDesk> getAll(){
        return new Specification<CashDesk>() {
            @Override
            public Predicate toPredicate(Root<CashDesk> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(CashDesk_.name),"%%");
            }
        };
    }
}
