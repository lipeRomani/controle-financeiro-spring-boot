package br.com.romani.services;


import br.com.romani.dtos.CashDeskDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.repositories.CashDeskRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CashDeskService extends FieldValueExists {

    List<CashDesk> getAll();
    Page<CashDesk> getPageableListOfAll(Pageable pageable);
    CashDesk save(CashDeskDto dto);
    CashDesk getCashDekFrom(CashDeskDto dto);
    CashDeskDto getDtoById(Integer id);
    CashDeskDto getDtoFrom(CashDesk cashDesk);
    void delete(Integer id);
    CashDesk findById(Integer id);

}
