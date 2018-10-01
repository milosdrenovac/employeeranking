package com.univer.berka.employeeranking.dto;

import java.sql.Date;

import com.univer.berka.employeeranking.model.Entry;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseEntryDTO {

	private String user;

	private Date date;

	private String zone;

	private int timeSpent;

	private int numberOfPallets;

	private int numberOfCommissionUnits;

	private int numberOfUnits;

	private int numberOfLines;

	private double weight;

	private double volume;

	private int numberOfCommissionUnitsPerHour;

	public ResponseEntryDTO(Entry entry) {

		this.user = entry.getEmployeeIdentity().getUser();
		this.date = entry.getEmployeeIdentity().getDate();
		this.zone = entry.getEmployeeIdentity().getZone();
		this.timeSpent = entry.getTimeSpent();
		this.numberOfPallets = entry.getNumberOfPallets();
		this.numberOfCommissionUnits = entry.getNumberOfCommissionUnits();
		this.numberOfUnits = entry.getNumberOfUnits();
		this.numberOfLines = entry.getNumberOfLines();
		this.weight = entry.getWeight();
		this.volume = entry.getVolume();
		this.numberOfCommissionUnitsPerHour = entry.getNumberOfCommissionUnitsPerHour();

	}

}
