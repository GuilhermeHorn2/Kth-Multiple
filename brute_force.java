package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	
	
	
	public static void main(String[] args) {
		
		
	
		System.out.println(kth_mult(9));
		
	}
	//brute force solution
	
	private static boolean is_valid(int n){
		
		//check if n is a number of the form : 7^x * 5^y * 3^z
		
		if(n == 1 || n == 3 || n == 5 || n == 7){
			return true;
		}
		

		for(int i = 3;i <= 7;i+= 2){
			
			if(n % i == 0 && is_valid(n/i)){
				return true;
			}
			
		}
		return false;
	}
	
	private static int kth_mult(int k){
		
		int c = 0;
		int curr = 1;
		while(c < k){
			
			if(is_valid(curr)){
				c++;
			}
			curr++;
		}
		return curr-1;
	}
	
}
