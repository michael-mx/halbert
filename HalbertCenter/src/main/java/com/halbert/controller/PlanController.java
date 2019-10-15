package com.halbert.controller;

import com.halbert.dao.PatientDao;
import com.halbert.dao.PlanDao;
import com.halbert.model.Patient;
import com.halbert.model.Plan;
import com.halbert.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {

    @Autowired
    PlanService planService;

    @Autowired
    PlanDao planDao;

    @PostMapping("/plan")
    public String createPlan(@RequestBody Plan plan) {
        Plan newPlan = planService.createPlan(plan);
        return newPlan.toString();
    }

    @RequestMapping(value = "/plans", method = RequestMethod.GET)
    public List<Plan> getPlans() {
        return planDao.findAll();
    }

    @RequestMapping(value = "/plan/{id}", method = RequestMethod.GET)
    public Plan getPlan(@PathVariable("id") long id) {
        return planDao.getOne(id);
    }

    @RequestMapping(value = "/pat_plans/{pid}", method = RequestMethod.GET)
    public List<Plan> getPatPlans(@PathVariable("pid") long pid) {
        return planDao.getPlansByPatient(pid);
    }

}
