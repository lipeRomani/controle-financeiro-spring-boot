package br.com.romani.dtos;


import br.com.romani.entities.TransactionType;
import br.com.romani.services.TransactionTypeService;
import br.com.romani.validators.Unique;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Unique(uniqueField = "name",primaryKey = "id", entity = TransactionType.class)
public class TransactionTypeDto implements Serializable{

    private Integer id;

    @NotBlank
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
