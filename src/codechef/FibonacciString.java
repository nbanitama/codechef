package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciString {

	private static void check(char[] data) {
		int[] sum = new int[26];
		
		for(char x : data) {
			sum[(int)x - 97]++;
		}
		
		int[] newData = constructData(sum);
		newData = quickSort(newData, 0, newData.length-1);
		
		boolean isBreak = false;
		
		if(newData.length >= 4) {
			if(newData[3] == newData[2] + newData[0])
				newData = swap(newData, 0, 1);
		}
		
		for(int i=2 ; i<newData.length ; i++) {
			if(newData[i] != newData[i-1] + newData[i-2]) {
				isBreak = true;
				break;
			}
		}
		
		if(isBreak)
			System.out.println("Not");
		else
			System.out.println("Dynamic");
	}
	
	private static int[] swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
		return data;
	}
	
	private static int[] quickSort(int[] data, int start, int pivot) {
		if(start > pivot)
			return data;
		int index = start;
		for(int i=start ; i<pivot ; i++) {
			if(data[i] <= data[pivot]) {
				data = swap(data, i, index++);
			}
		}
		
		data = swap(data, pivot, index);
		data = quickSort(data, start, index-1);
		data = quickSort(data, index+1, pivot);
		
		return data;
	}
	
	private static int[] constructData(int[] data) {
		int[] temp = new int[0];
		for(int i=0 ; i<data.length ; i++) {
			if(data[i] > 0) {
				temp = Arrays.copyOf(temp, temp.length+1);
				temp[temp.length-1] = data[i];
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0 ; i<t ; i++) {
			check(sc.next().toCharArray());
		}
		sc.close();
	}

}
