package com.univer.berka.employeeranking.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.ebay.xcelite.annotations.Column;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EntryDTO {	
	
	@NotBlank
	@Column (name="Korisnik")
	private String korisnik;
	
	@NotBlank
	@Column (name="Datum", dataFormat="MM/d/yyyy")
	private Date datum;
	
	@NotBlank
	@Column (name="Depo:")
	private String depo;
	
	@NotBlank
	@Column (name="Zona")
	private String zona;
	
	@NotBlank
	@Column (name="Vreme")
	private int vreme;
	
	@NotBlank
	@Column (name="Broj paleta")
	private int brojPaleta;
	
	@NotBlank
	@Column (name="Br. Kom. Jedinica")
	private int brojKomisionihJedinica;
	
	@NotBlank
	@Column (name="Broj komada")
	private int brojKomada;
	
	@NotBlank
	@Column (name="Broj linija")
	private int brojLinija;
	
	@NotBlank
	@Column (name="Tezina(kg)")
	private double tezina;
	
	@NotBlank
	@Column (name="Volumen(dm3)")
	private double volumen;
	
	@NotBlank
	@Column (name="Br. JK/h")
	private int brojKomisionihJedinicaNaSat;

}
