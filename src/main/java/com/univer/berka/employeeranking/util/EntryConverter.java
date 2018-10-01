package com.univer.berka.employeeranking.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.univer.berka.employeeranking.dto.EntryDTO;
import com.univer.berka.employeeranking.model.EmployeeIdentity;
import com.univer.berka.employeeranking.model.Entry;

@Component
public class EntryConverter implements Converter<EntryDTO, Entry>{

	@Override
	public Entry convert(EntryDTO dto) {
		Entry entry = new Entry();
		entry.setEmployeeIdentity(new EmployeeIdentity(dto.getKorisnik(), new Date(dto.getDatum().getTime()), dto.getZona()));
		entry.setDepo(dto.getDepo());
		entry.setTimeSpent(dto.getVreme());
		entry.setNumberOfPallets(dto.getBrojPaleta());
		entry.setNumberOfCommissionUnits(dto.getBrojKomisionihJedinica());
		entry.setNumberOfUnits(dto.getBrojKomada());
		entry.setNumberOfLines(dto.getBrojLinija());
		entry.setWeight(dto.getTezina());
		entry.setVolume(dto.getVolumen());
		entry.setNumberOfCommissionUnitsPerHour(dto.getBrojKomisionihJedinicaNaSat());
    	return entry;
	}
	
	public List<Entry> convertList(Collection<EntryDTO> read){
		List<Entry> retList = new ArrayList<>();
		read.forEach(dto -> retList.add(convert(dto)));
		return retList;
	}

}
