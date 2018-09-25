package com.univer.berka.employeeranking.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.univer.berka.employeeranking.dto.EntryDTO;
import com.univer.berka.employeeranking.model.Entry;
import com.univer.berka.employeeranking.repository.EntryRepository;
import com.univer.berka.employeeranking.util.ExcelSheetParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryService {
	
	private final EntryRepository repository;
	
	public void save(MultipartFile file) throws IOException {
		Collection<EntryDTO> read = ExcelSheetParser.read(file);
		read.forEach(e -> repository.save(new Entry(e)));
    }
	
	public List<Entry> getByUser(String user){
		
		Iterable<Entry> findAll = repository.findAll();
		
		return StreamSupport.stream(findAll.spliterator(), false)
				.filter(e -> user.equals(e.getEmployeeIdentity().getUser()))
				.collect(Collectors.toList());
	}

}
