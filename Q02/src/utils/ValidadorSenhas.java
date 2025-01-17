package utils;

public class ValidadorSenhas {
	public static Integer howManyAreMissing(String senha) {
		int count = 0;
		if(!containNumber(senha)) {
			count+=1;
		}
		if(!containUpperCase(senha)) {
			count+=1;
		}
		if(!containLowerCase(senha)) {
			count+=1;
		}
		if(!containSpecialCaractere(senha)) {
			count+=1;
		}
		return count;
	}
	
	public static boolean containNumber(String senha) {
		String nums = "1234567890";
		char[] chars = nums.toCharArray();
		
		
		for(char ch : chars) {
			if(senha.indexOf(ch) != -1) {
				return true;
			}
		}
		
		return false;		
	}
	
	public static boolean containUpperCase(String senha) {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ�";
		char[] chars = upperCase.toCharArray();
		
		for(char ch : chars) {
			if(senha.indexOf(ch) != -1) {
				return true;
			}
		}
		return false;		
	}
	
	public static boolean containLowerCase(String senha) {
		String lowerCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ�".toLowerCase();
		char[] chars = lowerCase.toCharArray();
		
		for(char ch : chars) {
			if(senha.indexOf(ch) != -1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containSpecialCaractere(String senha) {
		String special = "!@#$%^&*()-+";
		char[] chars = special.toCharArray();
		
		for(char ch : chars) {
			if(senha.indexOf(ch) != -1) {
				return true;
			}
		}
		return false;
	}
	
	public static Integer isStrongPassword(String senha) {
		if(senha.length() >= 6) {
			return ValidadorSenhas.howManyAreMissing(senha);
		}
		else {
			if(senha.length() <= 3) {
				return 6 - senha.length();
			}
			else {
				return 6 - senha.length() + ValidadorSenhas.howManyAreMissing(senha) - ((6 - senha.length()));
			}
		}	
	}
}
