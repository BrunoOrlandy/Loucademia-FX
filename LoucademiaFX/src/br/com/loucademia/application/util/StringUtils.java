package br.com.loucademia.application.util;

public class StringUtils {

	public static boolean isEmpty(String s) {
		
		if (s == null) {
			return true;
		}
		
		return s.trim().length() == 0;
	}
	
	public static String leftZeroes(int value, int finalSize) {
		
		// Permite formatar Strings concatenando zeros à esquerda
		// String.format(padrão de formatação, valor a ser formatado)
		return String.format("%0" + finalSize + "d", value);
	}
	
	public static void main(String[] args) {
		
		String str = "abc";
		
		boolean b = StringUtils.isEmpty(str);
		System.out.println(str + ": " + b);
		
		str = "   ";
		b = StringUtils.isEmpty(str);
		System.out.println(str + ": " + b);
		
		str = "  a  ";
		b = StringUtils.isEmpty(str);
		System.out.println(str + ": " + b);
		
		str = null;
		b = StringUtils.isEmpty(str);
		System.out.println(str + ": " + b);
		
		int v = 100;
		System.out.println(StringUtils.leftZeroes(v, 6));
		System.out.println(StringUtils.leftZeroes(1235, 8));
		System.out.println(StringUtils.leftZeroes(0, 4));
	}
}
