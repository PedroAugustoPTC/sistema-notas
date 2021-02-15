package br.com.tda.sistemanotas;

import br.com.tda.sistemanotas.util.DateFormatter;

public class Teste {

	public static void main(String[] args) {
		DateFormatter date = new DateFormatter();
		System.out.println(date.formatarDataParaOFront(date.formatarDataParaOBanco("14/05/2028")));

	}

}
