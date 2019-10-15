package com.halbert.controller;

import com.halbert.model.Patient;
import com.halbert.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientDao patientDao;

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {
        return patientDao.findAll();
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") long id) {
        return patientDao.getOne(id);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String create(@RequestParam(value = "name") String name,
                         @RequestParam(value = "org") String org) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setOrgId(org);
        patient.setRegTime(new Date());
        Patient newPatient = patientDao.saveAndFlush(patient);
        return newPatient.toString();
    }

    @RequestMapping(value = "/patient", method = RequestMethod.PUT)
    public String update(@RequestParam("id") long id, @RequestParam(value = "name", required = true) String name,
                         @RequestParam(value = "org", required = false) String org) {
        Patient patient = patientDao.getOne(id);
        patient.setName(name);
        patient.setOrgId(org);
        patient.setId(id);
        Patient patientNew = patientDao.saveAndFlush(patient);
        return patientNew.toString();
    }

    @RequestMapping(value = "/patients/{org}", method = RequestMethod.GET)
    public List<Patient> getOrgPatients(@PathVariable("org") String org) {
        return patientDao.findPatientsByOrgId(org);
    }

}
