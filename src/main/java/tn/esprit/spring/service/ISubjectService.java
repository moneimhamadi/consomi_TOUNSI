package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Subject;



public interface ISubjectService {
	
	Subject addSubject(Subject s);

	Subject updateSubject(Subject s);

	boolean deleteSubject(int id);

	Optional<Subject> retrieveSubject(int id);
	
	List<Subject> retrieveAllSubject();


}
