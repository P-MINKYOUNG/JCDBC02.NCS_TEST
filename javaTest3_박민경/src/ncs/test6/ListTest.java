package ncs.test6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListTest {
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Descending desc = new Descending();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 10 ; i++) {
			list.add(rand.nextInt(100) + 1);
		}
		
		for(int i = 1 ; i < 10 ; i++) {
			if(list.get(i-1) == list.get(i)) {
				i--;
			}
		}
		
		System.out.print("정렬 전 : ");
		display(list);
		System.out.println();
		
		Collections.sort(list, new Descending());
		System.out.print("정렬 후 : ");
		display(list);
		
		
		
	}
	
	public static void display(List list) {
		System.out.print(list);
	}

}
