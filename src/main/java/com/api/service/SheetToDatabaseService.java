package com.api.service;

import com.api.entity.MedEntity;
import com.api.helper.Helper;
import com.api.repo.MedEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SheetToDatabaseService {

    @Autowired
    private MedEntityRepo medRepo;

    public void save(MultipartFile file) {

        try {
            List<MedEntity> products = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.medRepo.saveAll(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<MedEntity> getAllProducts() {
        return this.medRepo.findAll();
    }


}
