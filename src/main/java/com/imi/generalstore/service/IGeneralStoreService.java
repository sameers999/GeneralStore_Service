package com.imi.generalstore.service;

import com.imi.generalstore.dto.GeneralStoreDTO;
import com.imi.generalstore.model.GeneralStoreData;

import java.util.List;

public interface IGeneralStoreService {
    GeneralStoreData insertGeneralStoreData(GeneralStoreDTO dto);

    List<GeneralStoreData> getAllProducts();

    GeneralStoreData getproductsByID(Long ProductId);
    List<GeneralStoreData> retrieveProducts();

    GeneralStoreData getproductByIdAPI(Long productId);
}
