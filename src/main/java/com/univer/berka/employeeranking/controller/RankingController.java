package com.univer.berka.employeeranking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univer.berka.employeeranking.dto.ResponseEntryDTO;
import com.univer.berka.employeeranking.exceptions.DocumentParsingException;
import com.univer.berka.employeeranking.service.EntryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ranking")
@RequiredArgsConstructor
@SuppressWarnings("rawtypes")
public class RankingController {

	private final EntryService service;

	@PostMapping("/upload")
	public ResponseEntity parseData(@RequestParam("file") MultipartFile file) throws IOException {
		log.info("Uploading file {}", file.getOriginalFilename());
		service.save(file);
		log.info("Uploading of file {} finished", file.getOriginalFilename());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{user}")
	public ResponseEntity getUserActions(@PathVariable("user") final String user) {
		log.info("Recieved request for all actions for user: {}", user);
		List<ResponseEntryDTO> userActions = service.getByUser(user);
		if (userActions.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		log.info("Sending response for all actions for user: {}", user);
		return new ResponseEntity<>(userActions, HttpStatus.OK);
	}

	@ExceptionHandler(DocumentParsingException.class)
	public final ModelAndView handleUserNotFoundException(DocumentParsingException e) {
		ModelAndView model = new ModelAndView("parsingError");
		
		log.error("Error while parsing data file, reason: {} ", e.getMessage(), e);
		model.addObject("message", e.getMessage());
		return model;
	}

}
