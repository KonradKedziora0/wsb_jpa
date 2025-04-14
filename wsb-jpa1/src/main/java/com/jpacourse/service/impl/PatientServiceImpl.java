package com.jpacourse.service.impl;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.AddressDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.service.AddressService;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }
    @Override
    @Transactional
    public PatientTO deletePatient(Long id) {
        if (patientDao.exists(id)) { // Używamy exists() z Dao
            PatientEntity entity = patientDao.findOne(id);
            patientDao.delete(id); // Używamy delete() z Dao
            return PatientMapper.mapToTO(entity);
        } else {
            return null;
        }
    }
}
