package com.mspatient.service;

import com.mspatient.model.Patient;
import com.mspatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public void savePatientSansReturn(Patient patient){
        repository.save(patient);
    }

    public Patient savePatient(Patient patient){
        return repository.save(patient);//si n'existe pas < insert to > , si existe mis a jour <Update>
    }
    public List<Patient> savePatients(List<Patient> patients){
        return repository.saveAll(patients);
    }
    public List<Patient> getPatient(){
        return repository.findAll();
    }
    public Patient getPatientById(int id){
        return repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid patient Id : " + id));
    }
    public String deletePatient(int id){
        repository.deleteById(id);
        return "Patient number ** "+ id +" ** removed ??" ;
    }

    public Patient updatePatient(Patient patient){
        Patient existingPatient = repository.findById(patient.getId() ).orElse(null);
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setAdress(patient.getAdress());
        existingPatient.setGender(patient.getGender());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setBirthday(patient.getBirthday());
        return repository.save(existingPatient);
    }
}
