package com.univer.berka.employeeranking.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univer.berka.employeeranking.dto.EntryDTO;
import com.univer.berka.employeeranking.model.Entry;
import com.univer.berka.employeeranking.service.EntryService;
import com.univer.berka.employeeranking.util.ExcelSheetParser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor	
@SuppressWarnings("rawtypes")
public class RankingController {
	
	private final EntryService service;	

	@PostMapping
	public ResponseEntity parseData() {
		//TODO replace hard-coded url with input from front end
		Collection<EntryDTO> read = ExcelSheetParser.read("C:/Users/Milos/Desktop/Book2.xlsx");
		read.forEach(e -> service.save(new Entry(e)));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{user}")
	public ResponseEntity getUserActions(@PathVariable("user") final String user) {
		List<Entry> userActions = service.getByUser(user);
		if(userActions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userActions, HttpStatus.OK);
	}

}
