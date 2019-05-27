package org.projet6.business.managerImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class ConvertisseurDate {
	
	 public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	        return dateToConvert.toInstant()
	                .atZone(ZoneId.systemDefault())
	                .toLocalDate();
	    }

}
