package br.com.romani.controllers;


import br.com.romani.dtos.CashDeskDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.services.CashDeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/cash-desk")
@Transactional
public class CashDeskController {

    @Autowired
    private CashDeskService cashDeskService;

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String saveForm(Model model, CashDeskDto cashDesk){
        if(cashDesk.getId() != null)
            cashDesk = cashDeskService.getDtoById(cashDesk.getId());

        model.addAttribute("cashDesk",cashDesk);
        return "cashdesk/form";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveData(
            @Valid @ModelAttribute("cashDesk") CashDeskDto cashDeskDto,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes){

        if(result.hasErrors())
            return saveForm(model, cashDeskDto);

        CashDesk save = cashDeskService.save(cashDeskDto);
        redirectAttributes.addFlashAttribute("successMsg","Caixa <strong>" + save.getName() + "</strong> salvo com sucesso!");
        return "redirect:/cash-desk";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Pageable pageable, Model model){
        Page<CashDesk> cashDesks = cashDeskService.getPageableListOfAll(pageable);
        model.addAttribute("cashDesks",cashDesks);
        return "cashdesk/list";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String remove(@PathVariable Integer id){
        cashDeskService.delete(id);
        return "Caixa deletado com sucesso!";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes){

        CashDesk cashDesk = cashDeskService.findById(id);
        if(cashDesk != null) {
            model.addAttribute("cashDesk", cashDesk);
        }else{
            redirectAttributes.addFlashAttribute("errorMsg","Este caixa não existe");
            return "redirect:/cash-desk";
        }
        return "cashdesk/detail";
    }
}
