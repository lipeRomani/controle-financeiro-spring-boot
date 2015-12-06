package br.com.romani.services;

import br.com.romani.dtos.TransactionTypeDto;
import br.com.romani.entities.TransactionType;
import br.com.romani.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository){

        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType save(TransactionTypeDto dto) {
        TransactionType transactionType = getTransactionTypeBy(dto);
        return transactionTypeRepository.save(transactionType);
    }

    public TransactionType getTransactionTypeBy(TransactionTypeDto dto) {
        TransactionType transactionType = new TransactionType();
        transactionType.setId(dto.getId());
        transactionType.setName(dto.getName());
        return transactionType;
    }

    public List<TransactionType> getAll() {
        return transactionTypeRepository.findAll();
    }

    public Map<Integer, String> getMapList() {
        List<TransactionType> typeList = getAll();
        HashMap<Integer, String> map = new HashMap<>();

        for (TransactionType type : typeList)
            map.put(type.getId(), type.getName());

        return map;
    }

    public TransactionType findOne(Integer id){
        return transactionTypeRepository.findOne(id);
    }
}
