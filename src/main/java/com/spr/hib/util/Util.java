package com.spr.hib.util;

public class Util {

	
	//TODO use it later it returns 1y 2m 3w 6d 
	private static String convert(int days) {
		StringBuilder answer = new StringBuilder();
		int y, m, w, d ;
		y= m= w= d =0;
		
		if(days > 365) {
			y =  Math.abs(days/365);
			days -= y*365;
			answer.append(y +"y ");
		}
		
		if( days  > 30){
			m =  Math.abs(days/30);
			days -= m*30;
			answer.append(m +"m ");
		}
		
		if( days > 7 ){
			w =  Math.abs(days/7);
			days -= w*7;
			answer.append(w +"w ");
		}
		
		if( (days % 7) > 0){
			d =  days%7;
			answer.append(d +"d ");
		}
		
		return answer.toString();
	}
	//TODO delete
	public static void mainConvert(String[] args) {

		System.out.println(convert(-1) );
		System.out.println(convert(-7) );
		System.out.println(convert(0) );
		

		System.out.println(convert(1) );
		System.out.println(convert(7) );
		System.out.println(convert(8) );
		

		System.out.println(convert(28) );
		System.out.println(convert(31) );
		System.out.println(convert(32) );
		
		System.out.println(convert(37) );
		System.out.println(convert(38) );
		System.out.println(convert(44) );
		

		System.out.println(convert(365) );
		System.out.println(convert(366) );
		System.out.println(convert(500) );
	}
}
