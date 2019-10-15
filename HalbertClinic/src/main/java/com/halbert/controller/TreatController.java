package com.halbert.controller;

import com.halbert.model.TreatLog;
import com.halbert.service.TreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TreatController {
    @Autowired
    private TreatService treatService;

    @PostMapping("/treat")
    public void create(@RequestBody TreatLog log) {
        treatService.create(log);
    }

    @PutMapping("/treat")
    public void update(@RequestBody TreatLog log) {
        treatService.update(log);
    }

    @RequestMapping(value = "/treatLog/{planId}", method = RequestMethod.GET)
    public List<TreatLog> getPlan(@PathVariable("planId") long planId) {
        return treatService.query(planId);
    }

    /*@InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }*/
}
