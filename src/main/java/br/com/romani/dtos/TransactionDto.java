package br.com.romani.dtos;

import br.com.romani.entities.Transaction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class TransactionDto {

    private Integer id;

    @NotNull
    private Double value;

    @NotNull
    private Transaction.Flow flow;

    @NotNull
    private Integer cashDeskId;

    @NotBlank
    @NotNull
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
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

    public Integer getCashDeskId() {
        return cashDeskId;
    }

    public void setCashDeskId(Integer cashDeskId) {
        this.cashDeskId = cashDeskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction.Flow getFlow() {
        return flow;
    }

    public void setFlow(Transaction.Flow flow) {
        this.flow = flow;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
