package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.MedEntity;
import com.api.repo.MedEntityRepo;
@RestController
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class MedQueryController {
	@Autowired
	MedEntityRepo medEntityRepo;
	
	@GetMapping("/medicines/listbycountry")
	public List<String> listMedByCountry(@RequestParam("country_name") String countryName){
		System.out.println("inside listMedByCountry");
		Optional<List<MedEntity>> optional=medEntityRepo.findAllByCountryName("nil");
		if(!optional.isPresent()) {
			System.out.println("Nothing Present");
			return null;
		}else {
			return optional.get().stream().filter(e->e.getCountryName().equalsIgnoreCase("nil"))
					.map(e->e.getMedicationName()).toList();
		}
	} 
	@GetMapping("/medicines/getmedicinebyname")
	public MedEntity getMedByName(@RequestParam("medication_name")String medicationName) {
		System.out.println("inside getMedByName");
		return medEntityRepo.findByMedicationName(medicationName).get();
	}

}





