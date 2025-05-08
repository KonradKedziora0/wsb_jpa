package com.jpacourse.persistance.repository;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    @Query("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName")
    List<PatientEntity> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM PatientEntity p WHERE SIZE(p.visits) >= :minVisits")
    List<PatientEntity> findPatientsWithMoreThanXVisits(@Param("minVisits") int minVisits);

    @Query("SELECT p FROM PatientEntity p WHERE p.dateOfBirth > :date")
    List<PatientEntity> findByDateOfBirthAfter(@Param("date") LocalDate date);

}
