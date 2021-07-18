import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		//write your code here
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<str.length(); i++){
		    int ch = str.charAt(i);
		    if(ch>=65 && ch<=90){
		        ch += 32;
		    }else{
		        ch -= 32;
		    }
		    char c = (char)ch;
		    sb.append(c);
		}
		
		return sb.toString();
	}
	
	public static String cleanercode(String str){
	    StringBuilder sb = new StringBuilder(str); //of str itself
		
		for(int i=0; i<str.length(); i++){
		    char ch = str.charAt(i);    //char
		    if(ch>='A' && ch<='Z'){ //if in upper
		        char c = (char)(ch + 'a' - 'A');    //cast from int to char; calc new from chars only w/o ascii
		        sb.setCharAt(i, c);
		    }else{  //if in lower
		        char c = (char)(ch + 'A' - 'a');    //change to upper
		        sb.setCharAt(i, c);
		    }
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
// 		System.out.println(toggleCase(str));
		System.out.println(cleanercode(str));
	}

}