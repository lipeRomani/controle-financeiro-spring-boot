package br.com.romani.dtos;

import br.com.romani.entities.Transaction;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Calendar;

public class TransactionDto {

    private Integer id;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal value;

    @NotNull
    private Transaction.Flow flow;

    @NotNull
    private Integer cashDeskId;

    @NotNull
    private Integer typeId;

    @NotBlank(message = "{transaction.description.notBlank}")
    @NotNull
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
