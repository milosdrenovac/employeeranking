package com.univer.berka.employeeranking.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.ebay.xcelite.annotations.Column;
import com.univer.berka.employeeranking.util.PatternRegex;

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
	@Pattern(regexp=PatternRegex.INTEGER_REGEX, message="NE MOZE")
	@Column (name="Vreme")
	private int vreme;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.INTEGER_REGEX)
	@Column (name="Broj paleta")
	private int brojPaleta;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.INTEGER_REGEX)
	@Column (name="Br. Kom. Jedinica")
	private int brojKomisionihJedinica;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.INTEGER_REGEX)
	@Column (name="Broj komada")
	private int brojKomada;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.INTEGER_REGEX)
	@Column (name="Broj linija")
	private int brojLinija;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.DOUBLE_REGEX)
	@Column (name="Tezina(kg)")
	private double tezina;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.DOUBLE_REGEX)
	@Column (name="Volumen(dm3)")
	private double volumen;
	
	@NotBlank
	@Pattern(regexp=PatternRegex.INTEGER_REGEX)
	@Column (name="Br. JK/h")
	private int brojKomisionihJedinicaNaSat;

}
