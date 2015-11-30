package br.com.romani.controllers;

import br.com.romani.dtos.TransactionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/transaction")
@Transactional
public class TransactionController {

    @RequestMapping(method = RequestMethod.GET)
    public String listOfTransaction(Pageable pageable, Model model, TransactionDto transactionDto){

        return "transactional/list";
    }
}
