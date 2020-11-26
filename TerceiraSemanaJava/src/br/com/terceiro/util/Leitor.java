package br.com.terceiro.util;

import java.util.Scanner;

public class Leitor {

	public static String lerValor(String pergunta, Scanner sc) {
		System.out.println(pergunta);
		return sc.next();
	}

	public static Float lerValor(String pergunta, Scanner sc, Float valor) {
		System.out.println(pergunta);
		return sc.nextFloat();
	}

	public static Integer lerValor(String pergunta, Scanner sc, Integer valor) {
		System.out.println(pergunta);
		return sc.nextInt();
	}

	public static Character lerValor(String pergunta, Scanner sc, Character valor) {
		System.out.println(pergunta);
		String retorno = sc.next();
		return retorno.charAt(0);
	}

	public static void limparConsole() {
		try {

			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
			System.out.println("Erro....");
		}

	}

	public static Boolean lerValor(String pergunta, Scanner sc, Boolean b) {
		String retorno = "";
		do {
			System.out.println(pergunta);
			retorno = sc.next();
		} while (!retorno.toUpperCase().equals("SIM") && !retorno.toUpperCase().equals("NAO"));
		if (retorno.toUpperCase().equals("SIM")) {
			return true;
		} else {
			return false;
		}
	}

	public static Long lerValor(String pergunta, Scanner sc, Long l) {
		System.out.println(pergunta);
		return sc.nextLong();
	}

	public static void limparTela() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
