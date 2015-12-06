package br.com.romani.entities;

import br.com.romani.entities.Transaction.Flow;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, Calendar> date;
	public static volatile SingularAttribute<Transaction, CashDesk> cashDesk;
	public static volatile SingularAttribute<Transaction, TransactionType> transactionType;
	public static volatile SingularAttribute<Transaction, String> description;
	public static volatile SingularAttribute<Transaction, Integer> id;
	public static volatile SingularAttribute<Transaction, BigDecimal> value;
	public static volatile SingularAttribute<Transaction, Flow> Flow;

}

