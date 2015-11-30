package br.com.romani.services;

import br.com.romani.dtos.CashDeskDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.repositories.CashDeskRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CashDeskService {

    private final CashDeskRepositorie cashDeskRepositorie;

    @Autowired
    public CashDeskService(CashDeskRepositorie cashDeskRepositorie){
        this.cashDeskRepositorie = cashDeskRepositorie;
    }

    public List<CashDesk> getAll(){
        return null;
    }

    public Page<CashDesk> getPageableListOfAll(Pageable pageable){
        return cashDeskRepositorie.findAll(pageable);
    }

    public CashDesk save(CashDeskDto dto){
        CashDesk cashDesk = getCashDekFrom(dto);
        return cashDeskRepositorie.save(cashDesk);
    }

    private CashDesk getCashDekFrom(CashDeskDto dto) {
        CashDesk cashDesk = new CashDesk();
        cashDesk.setName(dto.getName());
        cashDesk.setDescription(dto.getDescription());
        cashDesk.setId(dto.getId());
        return cashDesk;
    }

    public CashDeskDto getDtoById(Integer id) {
        CashDesk cashDesk = cashDeskRepositorie.findOne(id);
        CashDeskDto dto = getDtoFrom(cashDesk);
        return dto;
    }

    private CashDeskDto getDtoFrom(CashDesk cashDesk) {
        CashDeskDto dto = new CashDeskDto();
        dto.setId(cashDesk.getId());
        dto.setName(cashDesk.getName());
        dto.setDescription(cashDesk.getDescription());
        return dto;
    }
}
