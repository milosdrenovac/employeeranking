package com.univer.berka.employeeranking.dto;

import java.util.Date;

import com.ebay.xcelite.annotations.Column;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EntryDTO {	
	
	@Column (name="Korisnik")
	private String korisnik;
	
	@Column (name="Datum", dataFormat="MM/d/yyyy")
	private Date datum;
	
	@Column (name="Depo:")
	private String depo;
	
	@Column (name="Zona")
	private String zona;
	
	@Column (name="Vreme")
	private int vreme;
	
	@Column (name="Broj paleta")
	private int brojPaleta;
	
	@Column (name="Br. Kom. Jedinica")
	private int brojKomisionihJedinica;
	
	@Column (name="Broj komada")
	private int brojKomada;
	
	@Column (name="Broj linija")
	private int brojLinija;
	
	@Column (name="Tezina(kg)")
	private double tezina;
	
	@Column (name="Volumen(dm3)")
	private double volumen;
	
	@Column (name="Br. JK/h")
	private int brojKomisionihJedinicaNaSat;

}
