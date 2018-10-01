package com.univer.berka.employeeranking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univer.berka.employeeranking.dto.ResponseEntryDTO;
import com.univer.berka.employeeranking.service.EntryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {

	private final EntryService service;

	@GetMapping("/{user}")
	public ResponseEntity<List<ResponseEntryDTO>> getUserActions(@PathVariable("user") final String user) {
		log.info("Recieved request for all actions for user: {}", user);
		List<ResponseEntryDTO> userActions = service.getByUser(user);
		if (userActions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		log.info("Sending response for all actions for user: {}", user);
		return new ResponseEntity<List<ResponseEntryDTO>>(userActions, HttpStatus.OK);
	}



}
