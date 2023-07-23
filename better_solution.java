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
		
		
	System.out.println(kth_mult(6));
		
		
	}
	
	/*Each value is 3 or 5 or 7 * some past value,so i can set pointers to track wich value they stopped
	 * and test
	 */
	
	private static int operate(List<Integer> cache,int[] ptr_3,int[] ptr_5,int[] ptr_7){
		
		int val_3 = 3*cache.get(ptr_3[0]+1);
		int val_5 = 5*cache.get(ptr_5[0]+1);
		int val_7 = 7*cache.get(ptr_7[0]+1);
		
		if(val_3 <= val_5 && val_3 <= val_7){
			ptr_3[0]++;
			if(val_3 == val_5){
				ptr_5[0]++;
			}
			if(val_3 == val_7){
				ptr_7[0]++;
			}
			return val_3;
		}
		if(val_5 <= val_3 && val_5 <= val_7){
			ptr_5[0]++;
			if(val_5 == val_3){
				ptr_5[0]++;
			}
			if(val_5 == val_7){
				ptr_7[0]++;
			}
			return val_5;
		}
		if(val_7 <= val_3 && val_7 <= val_5){
			ptr_7[0]++;
			if(val_7 == val_3){
				ptr_3[0]++;
			}
			if(val_7 == val_5){
				ptr_5[0]++;
			}
			return val_7;
		}
		
		return -1;
		
	}
	
	private static int kth_mult(int k,List<Integer> cache,int[] ptr_3,int[] ptr_5,int[] ptr_7){
		
		if(cache.size() >= k+1 && cache.get(k) != null) {
			return cache.get(k);
		}
		
		for(int i = cache.size();i <= k;i++){
			
			int curr = operate(cache,ptr_3,ptr_5,ptr_7);
			if(curr != -1){
				cache.add(curr);
			}
			else{
				System.out.println("Invalid operation.");
				return -1;
			}
			
		}
		return cache.get(k);
		
	}
	
	private static int kth_mult(int k){
		
		List<Integer> cache = new ArrayList<>(Arrays.asList(1,3,5,7));
		
		int[] ptr_3 = {0};
		int[] ptr_5 = {0};
		int[] ptr_7 = {0};
		
		return kth_mult(k,cache,ptr_3,ptr_5,ptr_7);
		
	}
	
}
