package br.com.tda.sistemanotas.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateFormatter {

	public LocalDate formatarDataParaOBanco(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

		LocalDate localDate = LocalDate.parse(data, formatter);

		System.out.println(localDate);
		return localDate;
	}

	public String formatarDataParaOFront(LocalDate data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		return formatter.format(data);
	}
}
