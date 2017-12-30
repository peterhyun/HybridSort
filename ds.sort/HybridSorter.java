package ds.sort;

import java.lang.reflect.Array;

public class HybridSorter<K extends Comparable<? super K>> {
	InsertionSorter<K> insertionSort = new InsertionSorter<K>();
	private final int RUN = 32;
	Pair<K,?>[] temp;
	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */

	public Pair<K,?> search(Pair<K,?>[] array, int k) {
		return array[k];
	}
	
	public void sort(Pair<K, ?>[] array, int left, int right) {
		temp = new Pair[array.length];
		sortHelp(array,temp,left,right);
	}
	public void sortHelp(Pair<K, ?>[] array, Pair<K, ?>[] temp, int left, int right) {
		int i, j, k, mid=(left+right)/2;
		if(left==right)
			return;
		if((mid-left) >= RUN)
			sortHelp(array,temp,left,mid);
		else
			insertionSort.sort(array, left, mid);
		if((right-mid)>RUN)
			sortHelp(array,temp,mid+1,right);
		else
			insertionSort.sort(array,mid+1,right);
		for(i=left;i<=mid;i++)
			temp[i] = array[i];
		for(j=1;j<=right-mid;j++)
			temp[right-j+1] = array[j+mid];
		for(i=left,j=right,k=left;k<=right;k++) {
			if(temp[i].getKey().compareTo(temp[j].getKey())<0) {
				array[k] = temp[i++];
			}
			else {
				array[k] = temp[j--];
			}
		}
	}
	// Hint: Maybe you need to create the helper methods.

}
