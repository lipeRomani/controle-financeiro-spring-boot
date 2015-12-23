package br.com.romani.services;

import br.com.romani.dtos.TransactionTypeDto;
import br.com.romani.entities.TransactionType;

import java.util.List;
import java.util.Map;

public interface TransactionTypeService {
    TransactionType save(TransactionTypeDto dto);
    TransactionType getTransactionTypeBy(TransactionTypeDto dto);
    List<TransactionType> getAll();
    Map<Integer, String> getMapList();
    TransactionType findOne(Integer id);
}
