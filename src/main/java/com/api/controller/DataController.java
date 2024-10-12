package com.api.controller;

import com.api.entity.MedEntity;
import com.api.helper.Helper;
import com.api.service.SheetToDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class DataController {

    @Autowired
    private SheetToDatabaseService productService;

    @PostMapping("/sheetdata/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        System.out.println("hit");
    	if (Helper.checkExcelFormat(file)) {
            //true

            this.productService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/product")
    public List<MedEntity> getAllProduct() {
        return this.productService.getAllProducts();
    }

}
