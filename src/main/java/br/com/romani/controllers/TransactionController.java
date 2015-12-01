package br.com.romani.controllers;

import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.Transaction;
import br.com.romani.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/transaction")
@Transactional
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET)
    public String listOfTransaction(Pageable pageable, Model model, TransactionDto transactionDto){
        return "transactional/list";
    }

    @RequestMapping(value = "save",method = RequestMethod.GET)
    public String saveForm(TransactionDto transactionDto, Model model){
        model.addAttribute("transactionDto",transactionDto);
        model.addAttribute("flowList",transactionService.getMapTransactionFlow());
        return "transactional/form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveData(){

        return "redirect:";
    }
}
