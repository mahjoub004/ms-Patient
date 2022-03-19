package com.mspatient.controller;

import com.mspatient.model.Patient;
import com.mspatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired //c'est pour créer une instance
    private PatientService service;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient  patient){
        return service.savePatient (patient);
    }

    @PostMapping("/addPatients")
    public List<Patient> addPatients(@RequestBody List<Patient> patients){
        return service.savePatients(patients);
    }

    @GetMapping("/patients")
    public List<Patient> findAllPatient(){
        return service.getPatient();
    }

    @GetMapping("/patientById/{id}")
    public Patient getPatientById(@PathVariable Integer id){
        return service.getPatientById(id);
    }

    @PutMapping("/patientUpdate")
    public Patient updatePatientById(@RequestBody Patient patient){
        return service.updatePatient(patient);
    }

    @DeleteMapping("/patientDelete/{id}")
    public String getPatientByName(@PathVariable int id){
        return service.deletePatient(id);
    }


}
