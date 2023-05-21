package edu.towson.cis.cosc442.project2.fibonacci;

public class CountSeven {
	public static int countSeven(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 7) {
				count++;
			}
		}
		return count;
	}
}
