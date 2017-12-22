package com.techcode.bucky;

import java.util.ArrayList;
import java.util.Arrays;

public class Poly {
	
	/* целая часть */
	public ArrayList<Double> quotient;
	
	/* остаток */
	public ArrayList<Double> remainder;
	public int degree;
	
	public Poly(ArrayList<Double> values) {
		quotient = new ArrayList<>();

		for (Double val : values) {
			quotient.add(val);
		}
		
		degree = values.size();
	}
	
	public void setRemainder(Double[] vars) {
		remainder = new ArrayList<>();
		
		for (Double val : vars) {
			remainder.add(val);
		}
	}
	
	public void printRemainder() {
		for(int i=0; i < remainder.size(); i++) {
			Double value = remainder.get(remainder.size() - i - 1);
			
			if(value == 0)
				continue;
			
			System.out.printf("%.2fx^%d", value, remainder.size() - 1 - i);

			if(i < remainder.size() - 1) {
				System.out.printf(" +  ");
			}
		}
		
		System.out.println();
	}
	
	public void printQuotient() {
		
		for(int i=0; i < quotient.size(); i++) {
			Double value = quotient.get(quotient.size() - i - 1);
			
			if(value == 0)
				continue;
			
			System.out.printf("%.2fx^%d", value, quotient.size() - 1 - i);
			
			if(i < quotient.size() - 1) {
				System.out.printf(" + ");
			}
		}
		System.out.println();
	}
	
	public Double getQuotient(int index) {
		return quotient.get(index);
	}
	
	public Double[] getQuotientArray() {
		Double[] res = new Double[quotient.size()];
		res = quotient.toArray(res);
		return res;
	}
	
	public static Poly div(Poly a, Poly b) {
		Double[] dividend = a.getQuotientArray();
		Double[] divisor = b.getQuotientArray();
		
		Double[] remainder = Arrays.copyOf(dividend,dividend.length);
		Double[] quotient = new Double[remainder.length - divisor.length + 1];
		  
        for (int i = 0; i < quotient.length; i++)
        {
            double coeff = remainder[remainder.length - i - 1] / divisor[divisor.length-1];
            quotient[quotient.length - i - 1] = coeff;
            for (int j = 0; j < divisor.length; j++)
            {
                remainder[remainder.length - i - j - 1] -= coeff * divisor[divisor.length - j - 1];
            }
        }
        
        ArrayList<Double> remainderList  = new ArrayList<>();
        for (Double d: remainder) {
        	remainderList.add(d);
        }
        
        ArrayList<Double> quotientList  = new ArrayList<>();
        for (Double d: quotient) {
        	quotientList.add(d);
        }
        
        Poly res = new Poly(quotientList);
        res.setRemainder(remainder);
        
        return res;
	}
}


