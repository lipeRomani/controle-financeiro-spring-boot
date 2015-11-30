package br.com.romani.dtos;

import br.com.romani.entities.Transaction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

public class TransactionDto {

    private Integer id;

    @NotNull
    private Double value;

    @NotNull
    private Transaction.Flow fow;

    @NotNull
    private Integer cashDeskId;

    @NotBlank
    @NotNull
    private String description;

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

    public Transaction.Flow getFow() {
        return fow;
    }

    public void setFow(Transaction.Flow fow) {
        this.fow = fow;
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
}
