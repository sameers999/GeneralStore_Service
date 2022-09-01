package com.imi.generalstore.controller;

import com.imi.generalstore.dto.GeneralStoreDTO;
import com.imi.generalstore.dto.ResponseDTO;
import com.imi.generalstore.model.GeneralStoreData;
import com.imi.generalstore.service.IGeneralStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/products")
public class GeneralStoreController {

    @Autowired
    IGeneralStoreService service;

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertGeneralStoreData(@Valid @RequestBody GeneralStoreDTO dto) {
        GeneralStoreData generalStoreData = service.insertGeneralStoreData(dto);
        ResponseDTO responseDTO = new ResponseDTO("product Registered to generalStore",generalStoreData );
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllProducts() {
        List<GeneralStoreData> list = service.getAllProducts();
        ResponseDTO responseDTO = new ResponseDTO("List of Products in GeneralStore", list);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getGeneralStoreData/{productId}")
    public GeneralStoreData getproductByIdAPI(@PathVariable Long productId){
        System.out.println("Test");
        GeneralStoreData generalStoreData = service.getproductByIdAPI(productId);
        return generalStoreData;
    }
}
