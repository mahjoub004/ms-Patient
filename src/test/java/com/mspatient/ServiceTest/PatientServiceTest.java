package com.mspatient.ServiceTest;

import com.mspatient.model.Patient;
import com.mspatient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository ;

    @Test
    public void savePatient(){
        Patient patient = new Patient();
        patient.setLastName("Fred");
        patient.setFirstName("carmen");
        patient.setPhone("5365-2435-2536-55");
        patient.setAdress("10 ALLEE DE LYON 6006 LYon cedex 01");
        patient.setGender("F");
        LocalDate today = LocalDate.parse("2019-03-29");
        patient.setBirthday(today);

        Patient savedPatient = patientRepository.save(patient);

        assertThat(savedPatient).isNotNull();
        assertThat(savedPatient.getId()).isGreaterThan(0);
    }


}
