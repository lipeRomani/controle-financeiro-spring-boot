package br.com.romani.services;

import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.Transaction;
import br.com.romani.repositories.CashDeskRepositorie;
import br.com.romani.repositories.TransactionRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionRepositorie transactionRepositorie;
    private final CashDeskRepositorie cashDeskRepositorie;

    @Autowired
    public TransactionService(TransactionRepositorie transactionRepositorie, CashDeskRepositorie cashDeskRepositorie){
        this.transactionRepositorie = transactionRepositorie;
        this.cashDeskRepositorie = cashDeskRepositorie;
    }

    public Transaction saveTransaction(TransactionDto dto){
        Transaction transaction = getEntityBy(dto);
        return transactionRepositorie.save(transaction);
    }

    private Transaction getEntityBy(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setValue(dto.getValue());
        transaction.setFlow(dto.getFlow());
        transaction.setCashDesk(cashDeskRepositorie.findOne(dto.getCashDeskId()));
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
}
