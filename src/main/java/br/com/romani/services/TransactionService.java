package br.com.romani.services;


import br.com.romani.dtos.TransactionDto;
import br.com.romani.entities.CashDesk;
import br.com.romani.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface TransactionService {
    Transaction saveTransaction(TransactionDto dto);
    Transaction getEntityBy(TransactionDto dto);
    Map<Transaction.Flow,String> getMapTransactionFlow();
    Page<Transaction> getListByCashDesk(CashDesk cashDesk, Pageable pageable);
}
