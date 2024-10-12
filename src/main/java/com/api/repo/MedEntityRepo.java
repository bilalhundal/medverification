package com.api.repo;

import com.api.entity.MedEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedEntityRepo extends JpaRepository<MedEntity,Integer> {
	Optional<List<MedEntity>> findAllByCountryName(String countryName);
	Optional<MedEntity> findByMedicationName(String medicationName);
}
