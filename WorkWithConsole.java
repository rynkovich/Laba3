package action;

import initialization.Functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WorkWithConsole {
	
    public static void start_dialog(){
        Scanner scan = new Scanner(System.in);
        String string = "";

        System.out.println("Would you like to enter string manually? \n 1 - Yes. \n 2 - NO!");
        int parameter = 0;
        try{
            while(true){
            parameter = scan.nextInt();
            if((parameter != 1) && (parameter != 2))
                System.out.println("You must correctly answer the question!");
            else
                break;
            }            
            if(parameter == 1)
            	System.out.println("Enter the string ");
            else
            	System.out.println("Generation of the string ");
            string = create_string(parameter);
            operations_dialog(string);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public static String create_string(int parameter) throws Exception{
        if(parameter == 2){
        	StringBuilder ans = new StringBuilder();

            for(int i = 0; i < 6 + (int)(Math.random()*15); i++)
            	ans.append((char)(65 + (int)(Math.random()*26)));
            System.out.println(ans.toString());
            return ans.toString();
        }
        else{
            BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
            String line;
            char[] char_line;
            try{
                line = bis.readLine();
                char_line = line.toCharArray();
                if(char_line.length == 0){
                    System.out.println("The information entered does not match required."
                            + "The program will create uncomplicated string");
                    return "abc123";
                }
                else
                	return line;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
        return null;
   }
    
    public static void operations_dialog(String string){
        Scanner scan = new Scanner(System.in);
        String result = "";
        int[] key = {0, 0, 0};
        
        System.out.print("\n String: ");
        System.out.println(string);
        System.out.println("You can: \n 1 - Encrypt \n 2 - "
                + "Decrypt \n 3 - Exit \n What choose?");
        int parameter = 0;
        try{
            while(true){
            parameter = scan.nextInt();
            if((parameter != 1) && (parameter != 2)&& (parameter != 3))
                System.out.println("You must correctly answer the question!");
            else
                break;
            }
            switch(parameter){
                case 1:
                    System.out.print("String: ");
                    System.out.println(string);                                        
                    System.out.print("Key: ");                    
                    key = Functions.KeyGen(string);
                    System.out.println("{" + key[0] + ", " + key[1] + ", " + key[2] + "}");
                    System.out.print("Encrypted string: ");
                    result = Functions.Encrypt(string, key);
                    System.out.println(result);
                    
                    System.out.println("You can: \n 1 - Replace the current string to result "
                            + "\n 2 - Next \n What choose?");
                    while(true){
                    	parameter = scan.nextInt();
                    	if((parameter != 1) && (parameter != 2))
                    		System.out.println("You must correctly answer the question!");
                        else
                            break;
                    }
                    if(parameter == 1)
                    	operations_dialog(result);
                    else
                    	operations_dialog(string);
                    break;
                case 2:
                    System.out.print("String: ");
                    System.out.println(string);
                    System.out.println("Enter the first key-element ");
                    key[0] = scan.nextInt();
                    System.out.println("Enter the second key-element ");
                    key[1] = scan.nextInt();
                    System.out.println("Enter the third key-element ");
                    key[2] = scan.nextInt();
                    System.out.print("Decrypted string: ");
                    result = Functions.Decrypt(string, key);
                    System.out.println(result);
                    
                    System.out.println("You can: \n 1 - Replace the current string to result "
                            + "\n 2 - Next \n What choose?");
                    while(true){
                    	parameter = scan.nextInt();
                    	if((parameter != 1) && (parameter != 2))
                    		System.out.println("You must correctly answer the question!");
                        else
                            break;
                    }
                    if(parameter == 1)
                    	operations_dialog(result);
                    else
                    	operations_dialog(string);
                    break;
                case 3:
               	    System.out.println("Application quits...");
               	    break;               	 
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }finally{
        }
    }    
}
