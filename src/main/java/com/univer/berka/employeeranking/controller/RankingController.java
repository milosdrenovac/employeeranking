package com.univer.berka.employeeranking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univer.berka.employeeranking.dto.ResponseEntryDTO;
import com.univer.berka.employeeranking.service.EntryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
public class RankingController {

	private final EntryService service;

	@PostMapping("/upload")
	public ResponseEntity parseData(@RequestParam("file") MultipartFile file) throws IOException {
		service.save(file);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{user}")
	public ResponseEntity getUserActions(@PathVariable("user") final String user) {
		List<ResponseEntryDTO> userActions = service.getByUser(user);
		if (userActions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userActions, HttpStatus.OK);
	}

}
