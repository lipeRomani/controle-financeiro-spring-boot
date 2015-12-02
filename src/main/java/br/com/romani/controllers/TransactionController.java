package br.com.romani.controllers;

import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.entities.Transaction;
import br.com.romani.services.CashDeskService;
import br.com.romani.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
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

    @Autowired
    private CashDeskService cashDeskService;

    @RequestMapping(method = RequestMethod.GET)
    public String listOfTransaction(Pageable pageable, Model model, TransactionDto transactionDto){
        return "transactional/list";
    }

    @RequestMapping(value = "save/{cashDeskID}",method = RequestMethod.GET)
    public String saveForm(
            TransactionDto transactionDto,
            Model model,
            @PathVariable("cashDeskID") Integer cashDeskId,
            RedirectAttributes redirectAttributes){

        CashDesk cashDesk = cashDeskService.findById(cashDeskId);

        if(cashDesk == null) {
            redirectAttributes.addFlashAttribute("errorMsg","É necessário um caixa existente para cadastrar uma transação");
            return "redirect:/cash-desk";
        }

        model.addAttribute("cashDesk",cashDesk);
        model.addAttribute("transactionDto",transactionDto);
        model.addAttribute("flowList",transactionService.getMapTransactionFlow());
        return "transactional/form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveData(TransactionDto transactionDto){

        return "";
    }
}
