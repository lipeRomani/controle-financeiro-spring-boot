package br.com.romani.services;

import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.entities.Transaction;
import br.com.romani.repositories.CashDeskRepositorie;
import br.com.romani.repositories.TransactionRepositorie;
import br.com.romani.specifications.TransactionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import static org.springframework.data.jpa.domain.Specifications.where;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionRepositorie transactionRepositorie;
    private final CashDeskRepositorie cashDeskRepositorie;
    private final TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionService(TransactionRepositorie transactionRepositorie,
                              CashDeskRepositorie cashDeskRepositorie,
                              TransactionTypeService transactionTypeService){

        this.transactionRepositorie = transactionRepositorie;
        this.cashDeskRepositorie = cashDeskRepositorie;
        this.transactionTypeService = transactionTypeService;
    }

    public Transaction saveTransaction(TransactionDto dto){
        Transaction transaction = getEntityBy(dto);
        return transactionRepositorie.save(transaction);
    }

    private Transaction getEntityBy(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setValue(dto.getValue());
        transaction.setFlow(dto.getFlow());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        transaction.setCashDesk(cashDeskRepositorie.findOne(dto.getCashDeskId()));
        transaction.setTransactionType(transactionTypeService.findOne(dto.getTypeId()));
        return transaction;
    }

    public Map<Transaction.Flow,String> getMapTransactionFlow(){

        Map<Transaction.Flow, String> map = new HashMap<>();

        Transaction.Flow[] values = Transaction.Flow.values();

        for(Transaction.Flow flow : values){
            map.put(flow,flow.getDescription());
        }
        return map;
    }

    public Page<Transaction> getListByCashDesk(CashDesk cashDesk, Pageable pageable) {
        Specifications<Transaction> specifications = where(TransactionSpecification.findBy(cashDesk));
        return transactionRepositorie.findAll(specifications,pageable);
    }
}
