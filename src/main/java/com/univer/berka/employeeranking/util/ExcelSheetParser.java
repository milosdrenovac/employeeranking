package com.univer.berka.employeeranking.util;

import java.io.File;
import java.util.Collection;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import com.univer.berka.employeeranking.dto.EntryDTO;

public class ExcelSheetParser {
	
	public static Collection<EntryDTO> read(String path) {
		Xcelite xcelite = new Xcelite(new File(path));
		XceliteSheet sheet = xcelite.getSheet(0);
		SheetReader<EntryDTO> reader = sheet.getBeanReader(EntryDTO.class);
		return reader.read();
	}
}
