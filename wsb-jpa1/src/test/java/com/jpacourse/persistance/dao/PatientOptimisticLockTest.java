package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.OptimisticLockingFailureException;


@DataJpaTest
class PatientOptimisticLockTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldThrowOptimisticLockException() {
        PatientEntity patient1 = patientRepository.findById((long)6).orElseThrow();
        PatientEntity patient2 = patientRepository.findById((long)3).orElseThrow();

        patient1.setLastName("Podolski");
        patientRepository.saveAndFlush(patient1);

        patient2.setLastName("Logowy");

        Assertions.assertThrows(
                OptimisticLockingFailureException.class,
                () -> {
                    patientRepository.saveAndFlush(patient2);
                }
        );
    }
}
