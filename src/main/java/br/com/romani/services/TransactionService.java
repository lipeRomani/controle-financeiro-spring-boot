package br.com.romani.services;

import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.Transaction;
import br.com.romani.repositories.CashDeskRepositorie;
import br.com.romani.repositories.TransactionRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        transaction.setFlow(dto.getFow());
        transaction.setCashDesk(cashDeskRepositorie.findOne(dto.getCashDeskId()));
        return transaction;
    }
}
