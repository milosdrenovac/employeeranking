package com.univer.berka.employeeranking.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.univer.berka.employeeranking.dto.EntryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entry implements Serializable {
	
	@EmbeddedId
    private EmployeeIdentity employeeIdentity;
    
    @Column(nullable = false)
    private String depo;
    
    @Column(name = "time_spent", nullable = false, length = 80)
    private int timeSpent;
    
    @Column(name = "number_of_pallets", nullable = false, length = 80)
    private int numberOfPallets;
    
    @Column(name = "number_of_commission_units", nullable = false, length = 80)
    private int numberOfCommissionUnits;
    
    @Column(name = "number_of_units", nullable = false, length = 80)
    private int numberOfUnits;
    
    @Column(name = "number_of_lines", nullable = false, length = 80)
    private int numberOfLines;
    
    @Column(nullable = false, length = 80)
    private double weight;
    
    @Column(nullable = false, length = 80)
    private double volume;
    
    @Column(name = "number_of_commission_units_per_hour", nullable = false, length = 80)
    private int numberOfCommissionUnitsPerHour;
    
    public Entry(EntryDTO dto) {
    	this.employeeIdentity = new EmployeeIdentity(dto.getKorisnik(), new Timestamp(dto.getDatum().getTime()), dto.getZona());
    	this.depo = dto.getDepo();
    	this.timeSpent = dto.getVreme();
    	this.numberOfPallets = dto.getBrojPaleta();
    	this.numberOfCommissionUnits = dto.getBrojKomisionihJedinica();
    	this.numberOfUnits = dto.getBrojKomada();
    	this.numberOfLines = dto.getBrojLinija();
    	this.weight = dto.getTezina();
    	this.volume = dto.getVolumen();
    	this.numberOfCommissionUnitsPerHour = dto.getBrojKomisionihJedinicaNaSat();
    }
    
}
