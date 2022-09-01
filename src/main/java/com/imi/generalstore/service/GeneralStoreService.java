package com.imi.generalstore.service;

import com.imi.generalstore.dto.GeneralStoreDTO;
import com.imi.generalstore.exception.GeneralStoreException;
import com.imi.generalstore.model.GeneralStoreData;
import com.imi.generalstore.repository.GeneralStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class GeneralStoreService implements IGeneralStoreService {
    @Autowired
    GeneralStoreRepository repository;


    @Override
    public GeneralStoreData insertGeneralStoreData(GeneralStoreDTO dto) {
        GeneralStoreData generalStoreData = new GeneralStoreData(dto);
        repository.save(generalStoreData);
        return generalStoreData;
    }

    @Override
    public List<GeneralStoreData> getAllProducts() {
        List<GeneralStoreData> list = repository.findAll();
        if (list.isEmpty()) {
            throw new NullPointerException("there are no Products inserted yet");
        }
        return list;
    }


    @Override
    public GeneralStoreData getproductByIdAPI(Long productId) {
        Optional<GeneralStoreData> generalStoreData =repository.findById(productId);
        if (generalStoreData.isEmpty()){
            throw new GeneralStoreException("there are no Productswith given Id");
        }
        return generalStoreData.get();
    }

	@Override
	public GeneralStoreData getproductsByID(Long ProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeneralStoreData> retrieveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
