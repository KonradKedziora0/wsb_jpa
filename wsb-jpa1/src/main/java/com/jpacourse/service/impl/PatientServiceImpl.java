package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.repository.VisitRepository;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;
    private final VisitRepository visitRepository;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao, VisitRepository visitRepository)
    {
        patientDao = pPatientDao;
        this.visitRepository = visitRepository;
    }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }
    @Override
    @Transactional
    public PatientTO deletePatient(Long id) {
        if (patientDao.exists(id)) {
            PatientEntity entity = patientDao.findOne(id);
            patientDao.delete(id);
            return PatientMapper.mapToTO(entity);
        } else {
            return null;
        }
    }

    @Override
    public List<VisitEntity> findAllVisitsByPatientId(Long id) {
        return visitRepository.findAllByPatientId(id);
    }
}
