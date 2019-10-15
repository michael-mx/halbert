package com.halbert.service;

import com.halbert.dao.PatientDao;
import com.halbert.dao.PlanDao;
import com.halbert.dao.ShotDao;
import com.halbert.model.Patient;
import com.halbert.model.Plan;
import com.halbert.model.Shot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    PatientDao patientDao;
    @Autowired
    PlanDao planDao;
    @Autowired
    ShotDao shotDao;

    public Plan createPlan(Plan plan){
        Patient patient = patientDao.findByName(plan.getPatient().getName());
        if(patient==null){
            patient = plan.getPatient();
            patient.setRegTime(new Date());
            plan.setPatient(patient);
        }else{
            plan.setPatient(patient);
        }

        Plan newPlan = planDao.save(plan);

        return plan;
    }
}
