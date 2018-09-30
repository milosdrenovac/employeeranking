package com.univer.berka.employeeranking.service.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.univer.berka.employeeranking.dto.EntryDTO;
import com.univer.berka.employeeranking.dto.ResponseEntryDTO;
import com.univer.berka.employeeranking.model.Entry;
import com.univer.berka.employeeranking.repository.EntryRepository;
import com.univer.berka.employeeranking.service.EntryService;
import com.univer.berka.employeeranking.util.ExcelSheetParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {
	
	private final EntryRepository repository;
	
	@Override
	public void save(MultipartFile file) throws IOException {
		Collection<EntryDTO> read = ExcelSheetParser.read(file);
		read.forEach(e -> repository.save(new Entry(e)));
    }
	
	@Override
	public List<ResponseEntryDTO> getByUser(String user){

		Iterable<Entry> findAll = repository.findAll();
		
		return StreamSupport.stream(findAll.spliterator(), false)
				.filter(e -> user.equals(e.getEmployeeIdentity().getUser()))
				.map(e -> new ResponseEntryDTO(e))
				.collect(Collectors.toList());
	}

}
