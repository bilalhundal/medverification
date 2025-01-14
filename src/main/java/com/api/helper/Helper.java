package com.api.helper;

import com.api.entity.MedEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<MedEntity> convertExcelToListOfProduct(InputStream is) {
        List<MedEntity> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                MedEntity medEntity = new MedEntity();

                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    medEntity.setCountryName("nil");
                    switch (cid) {
                        case 0:
                        	medEntity.setMedicationName(cell.getStringCellValue());
                            break;
                        case 1:
                        	medEntity.setCategory(cell.getStringCellValue());
                            break;
                        case 2:
                        	medEntity.setLegality(cell.getStringCellValue());
                            break;
                        case 3:
                        	medEntity.setDosageRestriction(cell.getStringCellValue());
                            break;
                        case 4:
                        	medEntity.setRequiredDocuments(cell.getStringCellValue());
                            break;
                        case 5:
                        	medEntity.setSource(cell.getStringCellValue());
                            break; 
                        case 6:
                        	medEntity.setCountryImage(cell.getStringCellValue());
                            break;
                        case 7:
                        	medEntity.setMedicationImage(cell.getStringCellValue());
                            break;     
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(medEntity);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
