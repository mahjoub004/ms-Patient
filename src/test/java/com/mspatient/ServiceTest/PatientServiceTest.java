package com.mspatient.ServiceTest;

import com.mspatient.model.Patient;
import com.mspatient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

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
        System.out.println(patient);
    }

@Test
    public void savePatients(){
    Patient patient2 = new Patient();
    patient2.setLastName("noe");
    patient2.setFirstName("david");
    patient2.setPhone("5365-2435-2536-55");
    patient2.setAdress("10 ALYON 600096 LYon cedex 01");
    patient2.setGender("F");
    LocalDate today = LocalDate.parse("2012-03-30");
    patient2.setBirthday(today);

    Patient patient1 = new Patient();
    patient1.setLastName("mack");
    patient1.setFirstName("cecile");
    patient1.setPhone("5365-2435-2536-55");
    patient1.setAdress("10 PARIS 75006 paris cedex 01");
    patient1.setGender("M");
    LocalDate todayPatient1 = LocalDate.parse("1987-03-29");
    patient2.setBirthday(todayPatient1);

    Collection<Patient> maListPatient;
     maListPatient = new ArrayList<Patient>();
     maListPatient.add(patient1);
     maListPatient.add(patient2);

    List<Patient> savedPatient = patientRepository.saveAll(maListPatient);

    for (Patient patient : savedPatient ) {
        System.out.println(patient);
    }
}

}
