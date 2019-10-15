package com.halbert.dao;

import com.halbert.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlanDao extends JpaRepository<Plan,Long> {
    @Query(value="select * from plan pl , patient pi where pi.id=pl.patient_id and pi.id=?1", nativeQuery = true)
    public List<Plan> getPlansByPatient(long patientId);
}
