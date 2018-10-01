package com.univer.berka.employeeranking.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univer.berka.employeeranking.exceptions.DocumentParsingException;
import com.univer.berka.employeeranking.service.EntryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class FrontController {
	
	private final EntryService service;	

	
	@PostMapping("/upload")
	public ModelAndView parseData(@RequestParam("file") MultipartFile file) throws IOException {
		log.info("Uploading file {}", file.getOriginalFilename());
		service.save(file);
		log.info("Uploading of file {} finished", file.getOriginalFilename());
		return new ModelAndView("success");
	}
	
	@ExceptionHandler(DocumentParsingException.class)
	public final ModelAndView handleUserNotFoundException(DocumentParsingException e) {
		ModelAndView model = new ModelAndView("parsingError");
		log.error("Error while parsing data file, reason: {} ", e.getMessage(), e);
		model.addObject("message", e.getMessage());
		return model;
	}
}
