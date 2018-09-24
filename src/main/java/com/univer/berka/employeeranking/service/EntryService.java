package com.univer.berka.employeeranking.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.univer.berka.employeeranking.model.Entry;
import com.univer.berka.employeeranking.repository.EntryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryService {
	
	private final EntryRepository repository;
	
	public Entry save(Entry e) {
        return repository.save(e);
    }
	
	public List<Entry> getByUser(String user){
		Iterable<Entry> findAll = repository.findAll();
		
		return StreamSupport.stream(findAll.spliterator(), false)
				.filter(e -> user.equals(e.getEmployeeIdentity().getUser()))
				.collect(Collectors.toList());
	}

}
