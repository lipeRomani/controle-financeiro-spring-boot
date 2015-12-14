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
public class CashDeskServiceImp implements CashDeskService {

    private final CashDeskRepositorie cashDeskRepositorie;

    @Autowired
    public CashDeskServiceImp(CashDeskRepositorie cashDeskRepositorie){
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

    public CashDesk getCashDekFrom(CashDeskDto dto) {
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

    public CashDeskDto getDtoFrom(CashDesk cashDesk) {
        CashDeskDto dto = new CashDeskDto();
        dto.setId(cashDesk.getId());
        dto.setName(cashDesk.getName());
        dto.setDescription(cashDesk.getDescription());
        return dto;
    }

    public void delete(Integer id) {
        CashDesk cashDesk = findById(id);
        cashDeskRepositorie.delete(cashDesk);
    }

    public CashDesk findById(Integer id){
        return cashDeskRepositorie.findOne(id);
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {

        if(!fieldName.equals("name"))
            throw new UnsupportedOperationException("File is unsupported");

        if(value == null)
            return false;

        CashDesk cashDesk = cashDeskRepositorie.findByName(value.toString());
        if(cashDesk == null)
            return false;

        return true;
    }
}
