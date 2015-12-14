package br.com.romani.dtos;

import br.com.romani.services.CashDeskService;
import br.com.romani.validators.Unique;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class CashDeskDto {
    private Integer id;

    @NotBlank
    @NotNull
    @Unique(service = CashDeskService.class,fieldName = "name")
    private String name;

    @NotBlank
    @NotNull
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
