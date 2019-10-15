package com.halbert.dao;

import com.halbert.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {
    public List<Patient> findPatientsByOrgId(String orgId);
    public Patient findByName(String name);
}
