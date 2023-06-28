import java.util.Scanner;
import java.util.Arrays;

public class question1 {

	public static void main(String[] args) {
		
		//Question 1
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int arraySize = reader.nextInt();
		int i = 0;
		
		int[] array = new int[10];
		System.out.println("Enter the elements in the array: ");
		while(i < arraySize) {
			
			array[i] = reader.nextInt();
			i++;
		}
		System.out.println("Enter the search key: ");
		int key = reader.nextInt();

		//LINEAR Search
		boolean foundLinear = false;
		long startTimeL = System.nanoTime();
		long endTimeL   = System.nanoTime();
		long totalTimeL = 0;
		
		for (int j = 0; j < array.length; j++) {
			if (array[j] == key) {
				foundLinear = true;
				System.out.println("****Using linear Search****");
				
				System.out.println("Search key FOUND at index: " + j);
				totalTimeL = endTimeL - startTimeL;
				break;
			}
		}
		if (!foundLinear) {
			System.out.println("Search key NOT FOUND");
		}
				
		//INTERPOLATION Search
		Arrays.sort(array);
		boolean foundInterpolation = false;
		int low = 0, midI, high = array.length - 1;		
		
		long startTimeI = System.nanoTime();
		long endTimeI   = System.nanoTime();
		long totalTimeI = 0;
		while (low <= high) {
			int pos = (key - array[low]) / (array[high] - array[low]);
			
			midI = low + ((high-low) * pos);
						
			if (array[midI] == key) {
				System.out.println("****Using Interpolation Search****");
				System.out.println("Search key FOUND at index: " + midI);
				totalTimeI = endTimeI - startTimeI;
				foundInterpolation = true;
				break;
			}
			
			else if (key < array[midI]) {
				high = midI - 1;
				
			} else if (key > array[midI]) {
				low = midI + 1;
			}
		}
		
		if (!foundInterpolation) {
			System.out.println("Search key NOT FOUND");
		}
		
		//Question 2: Compare run times
		System.out.println("Interpolation run time: " + totalTimeI);
		System.out.println("Linear run time: " + totalTimeL);
		
		//Question 3
		//IMPROVED LINEAR Search - using a sorted array
		boolean foundLinearImproved = false;
		long startTimeLImproved = System.nanoTime();
		long endTimeLImproved   = System.nanoTime();
		long totalTimeLImproved = 0;
		int middle = array.length/2;
		
		
		if (key < array[middle]) {
			for (int k = middle; k <= 0; k--) {
				
				if (array[k] == key) {
					foundLinearImproved = true;
					System.out.println("****Using Improved linear Search****");
					
					System.out.println("Search key FOUND at index: " + k);
					totalTimeLImproved = endTimeLImproved - startTimeLImproved;
					break;
				}
			}
		}
		
		if (key >= array[middle]) {
			for (int k = middle; k < array.length; k++) {
				
				if (array[k] == key) {
					foundLinearImproved = true;
					System.out.println("****Using Improved linear Search****");
					
					System.out.println("Search key FOUND at index: " + k);
					totalTimeLImproved = endTimeLImproved - startTimeLImproved;
					break;
				}
			}
		}
		
		
		
		for (int k = 0; k < array.length; k++) {
			
			if (array[k] == key) {
				foundLinearImproved = true;
				System.out.println("****Using Improved linear Search****");
				
				System.out.println("Search key FOUND at index: " + k);
				totalTimeLImproved = endTimeLImproved - startTimeLImproved;
				break;
			}
		}
		if (!foundLinearImproved) {
			System.out.println("Search key NOT FOUND");
		}
		
		System.out.println("Improved Linear run time: " + totalTimeLImproved);
		
		/* After sorting the array, the linear search time improves by 10x! */
		
	
		//Answers Summary
		/* Question 1:See implementation above
		 * 
		 * 
		 * Question 2: 
		 * Linear run time: 1625 nanoseconds
		 * Interpolation run time: 750 nano seconds
		 * 
		 * Interpolation search ran quicker because the search size is reduced each iteration
		 * 
		 * 
		 * Question 3:The array is sorted, the run time is improved by 10x.
		 * 
		 * The improved linear algorithm will check the middle point, then start the linear searching algorithm based on the middle point. Will either increment or decrement. 
		 * 
		 * initial Linear search run time: 1625 nano seconds
		 * Improved linear search run time: 166 nano seconds
		 * 
		 * */

		reader.close();
	}
}
