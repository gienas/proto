package pl.ene.tools;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 200; i++) {
			list.add(i);
		}

		Integer PACKAGE_SIZE = 100;
		List<Integer> subList;
		int start = 0;

		while (start < list.size()) {
			if (start + PACKAGE_SIZE < list.size()) {
				subList = list.subList(start, start + PACKAGE_SIZE);
			} else {
				subList = list.subList(start, list.size());
			}
			start += PACKAGE_SIZE;
			processList(list);
		}
	}

	public static void processList( List<Integer> list)
	{
		for ( Integer i: list)
		{
			System.out.println(i);
		}	
	}
	
	
	// public static List<Integer> getSublist()

}
