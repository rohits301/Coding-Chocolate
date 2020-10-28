import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		//write your code here
		for(int i=0; i<str.length(); i++){
		    for(int j=i+1; j<=str.length(); j++){ //j <= len to include last char
		        String sub = str.substring(i,j);
		        if(ispal(sub)){
		            System.out.println(sub);
		        }
		    }
		}
	}
	
	public static boolean ispal(String s){
	    int left = 0, right = s.length()-1;
	    while(left<=right){
	        if(s.charAt(left)!=s.charAt(right)){
	            return false;
	        }
	        left++;
	        right--;
	    }
	    
	    return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}