package com.univer.berka.employeeranking.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import com.univer.berka.employeeranking.dto.EntryDTO;
import com.univer.berka.employeeranking.exceptions.DocumentParsingException;

public class ExcelSheetParser {

	public static Collection<EntryDTO> read(MultipartFile file) throws IOException {
		File convFile = convert(file);
		Xcelite xcelite = new Xcelite(convFile);
		XceliteSheet sheet = xcelite.getSheet(0);
		SheetReader<EntryDTO> reader = sheet.getBeanReader(EntryDTO.class);
		Collection<EntryDTO> read = null;
		try {
			read = reader.read();
		} catch (IllegalArgumentException e) {
			throw new DocumentParsingException(e.getMessage());
		}
		convFile.delete();
		return read;
	}

	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}
