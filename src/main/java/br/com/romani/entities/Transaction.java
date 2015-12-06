package br.com.romani.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value",precision = 10,scale = 2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private Flow Flow;

    @ManyToOne
    @JoinColumn(name = "cash_desk_id")
    private CashDesk cashDesk;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Transaction.Flow getFlow() {
        return Flow;
    }

    public void setFlow(Transaction.Flow flow) {
        Flow = flow;
    }

    public CashDesk getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(CashDesk cashDesk) {
        this.cashDesk = cashDesk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public enum Flow {
        IN("Entrada"), OUT("Saida");

        private String description;

        private Flow(String description){
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
