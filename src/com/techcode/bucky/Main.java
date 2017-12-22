package com.techcode.bucky;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Double> values = new ArrayList<>();
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Введите степень первого многочлена:");
		int degree = reader.nextInt();
		
		for (int i=0; i < degree; i++) {
			System.out.printf("x^%d:", i);
	        values.add(reader.nextDouble());
	    }
		
		Poly poly1 = new Poly(values);
		
		values.clear();
		
		System.out.println("Введите степень второго многочлена:");
		degree = reader.nextInt();
		for (int i=0; i < degree; i++) {
			System.out.printf("x^%d:", i);
	        values.add(reader.nextDouble());
	    }
		
		Poly poly2 = new Poly(values);
		
		System.out.printf("Полином 1: ");
		poly1.printQuotient();
		System.out.println();
		
		System.out.printf("Полином 2: ");
		poly2.printQuotient();
		System.out.println();
		
		/* вызов статического метода класса Poly */
		Poly result = Poly.div(poly1, poly2);
		
		System.out.printf("Целая часть: ");
		result.printQuotient();
		System.out.println();
		
		System.out.printf("Остаток: ");
		result.printRemainder();
		System.out.println();
	}
}
