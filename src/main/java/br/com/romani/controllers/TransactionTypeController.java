package br.com.romani.controllers;


import br.com.romani.dtos.TransactionTypeDto;
import br.com.romani.dtos.ViewAjaxDto;
import br.com.romani.entities.TransactionType;
import br.com.romani.helpers.ValidationErrorHelper;
import br.com.romani.services.TransactionTypeService;
import br.com.romani.services.TransactionTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/type")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ViewAjaxDto<?> save(@Valid @RequestBody TransactionTypeDto dto,
                            BindingResult bindingResult){

       if(bindingResult.hasErrors()){
            ValidationErrorHelper errorHelper = new ValidationErrorHelper(bindingResult, HttpStatus.BAD_REQUEST);
            return new ViewAjaxDto<ValidationErrorHelper>(errorHelper);
        }

        TransactionType transactionType = transactionTypeService.save(dto);
        return new ViewAjaxDto<TransactionType>(transactionType);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TransactionType> getAll(){
        return transactionTypeService.getAll();
    }
}
