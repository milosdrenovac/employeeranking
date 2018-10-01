package com.univer.berka.employeeranking.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmployeeIdentity implements Serializable {
	
	@Column(nullable = false, length = 10)
	private String user;
	
    @Column(nullable = false)
    private Date date;
    
    
    @Column(nullable = false, length = 10)
    private String zone;

}
