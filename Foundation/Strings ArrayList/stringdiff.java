import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		// write your code here
	    StringBuilder sb = new StringBuilder();
	    char prev = str.charAt(0);
	    
	    for(int i=1; i<str.length(); i++){ //go till last char bec at last char, curr=last char & prev is appended
	        char curr = str.charAt(i);
	        int diff = curr - prev;
	        sb.append(prev);
	        sb.append(diff);
	        
	        prev = curr;
	    }
	    sb.append(str.charAt(str.length()-1)); //to append last char

		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}