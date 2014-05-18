package initialization;

public class Functions {
	
	public static int[] KeyGen(String str){
		int[] key = {0, 0, 0};
		
		switch(str.length()%3){
		    case 0:
		    	key[0] = str.length() - 3;
		    	key[1] = str.length() - 2;
		    	key[2] = str.length() - 1;
		    	break;
		    case 1:
		    	key[0] = str.length() - 1;
		    	key[1] = str.length() - 3;
		    	key[2] = str.length() - 2;
		    	break;
		    case 2:
		    	key[0] = str.length() - 2;
		    	key[1] = str.length() - 1;
		    	key[2] = str.length() - 3;
		    	break;
		}
		if(str.length() <= 2)
			key[2] = 0;
		if(str.length() == 1)
			key[1] = 0;
		return key;
	}
	
	public static String Encrypt(String string, int[] key){
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i <= key[0]; i = i + 3)
			ans.append(string.charAt(i));
		for(int i = 1; i <= key[1]; i = i + 3)
			ans.append(string.charAt(i));
		for(int i = 2; i <= key[2]; i = i + 3)
			ans.append(string.charAt(i));
		
		return ans.toString();
	}
	
	public static String Decrypt(String str, int[] key){
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < str.length(); i ++)
			ans.append("a");
		
		int k = 0;
		for(int i = 0; i <= key[0]; i = i + 3, k++)
			ans.setCharAt(i, str.charAt(k));
		for(int i = 1; i <= key[1]; i = i + 3, k++)
			ans.setCharAt(i, str.charAt(k));
		for(int i = 2; i <= key[2]; i = i + 3, k++)
			ans.setCharAt(i, str.charAt(k));
		
		return ans.toString();
	}

}

//str0.setCharAt(2, 'E');