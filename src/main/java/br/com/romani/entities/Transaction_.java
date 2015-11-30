package br.com.romani.entities;

import br.com.romani.entities.Transaction.Flow;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, Calendar> date;
	public static volatile SingularAttribute<Transaction, CashDesk> cashDesk;
	public static volatile SingularAttribute<Transaction, String> description;
	public static volatile SingularAttribute<Transaction, Integer> id;
	public static volatile SingularAttribute<Transaction, Double> value;
	public static volatile SingularAttribute<Transaction, Flow> Flow;

}

