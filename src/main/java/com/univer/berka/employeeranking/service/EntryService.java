package com.univer.berka.employeeranking.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.univer.berka.employeeranking.dto.ResponseEntryDTO;

public interface EntryService {
	
	public void save(MultipartFile file) throws IOException;
	
	public List<ResponseEntryDTO> getByUser(String user);

}
