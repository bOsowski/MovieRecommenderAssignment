package app;

import java.util.ArrayList;

import app.wrapperClasses.Item;

public class SelectionSort {

	
	public static void sort(ArrayList<Item> arrayList,String by)
	{
		int N = arrayList.size();
		for( int i = 0; i < N; i++){
			int min = i;
			for(int j = i+1; j < N; j++)
			{
				if(by.equals("date")){
				if(lessByDate(arrayList.get(j), arrayList.get(min)))
					min = j;
				}
				if(by.equals("rating")){
					if(lessByRating(arrayList.get(j), arrayList.get(min)))
						min = j;
				}
				if(by.equals("popularity")){
				if(lessByPopularity(arrayList.get(j), arrayList.get(min)))
					min = j;
				}
			}
			exch(arrayList, i, min);
		}
	}

	private static void exch(ArrayList<Item> arrayList, int i, int j) {
		Item swap = arrayList.get(i);
		arrayList.set(i,arrayList.get(j));
		arrayList.set(j,swap);
		
	}

	private static boolean lessByDate(Item v,Item w) {
		return v.compareToDate(w) < 0;
	}
	
	private static boolean lessByRating(Item v,Item w) {
		return v.compareToRating(w) < 0;
	}
	
	private static boolean lessByPopularity(Item v,Item w) {
		return v.compareToPopularity(w) < 0;
	}
	
	
	
	
	
}
