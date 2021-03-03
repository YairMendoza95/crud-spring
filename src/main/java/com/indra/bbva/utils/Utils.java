package com.indra.bbva.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static Date formatoFecha(String fecha) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		return dateFormat.parse(fecha);
	}
}
