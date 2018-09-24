package com.univer.berka.employeeranking.repository;

import org.springframework.data.repository.CrudRepository;

import com.univer.berka.employeeranking.model.EmployeeIdentity;
import com.univer.berka.employeeranking.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, EmployeeIdentity>{

}
