package br.com.romani.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double value;

    @Enumerated(EnumType.STRING)
    private Flow Flow;

    @ManyToOne
    @JoinColumn(name = "cash_desk_id")
    private CashDesk cashDesk;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
