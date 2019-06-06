package dao;

import java.util.List;

import entity.Patient;

public interface PatientDao {
	Long savePatient(Patient patient);

	void updatePatient(Patient patient);

	void deletePatient(Long id);

	Patient findPatientById(Long id);

	List<Patient> findAllPatients();
}
