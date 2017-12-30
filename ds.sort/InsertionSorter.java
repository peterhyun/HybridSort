package ds.sort;

public class InsertionSorter<K extends Comparable<? super K>> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order using insertion sort algorithm.
	 */
	
	public void sort(Pair<K, ?>[] array, int left, int right) {
		for(int i=left+1;i<right+1;i++) {
			for(int j=i;(j>left)&&(array[j].getKey().compareTo(array[j-1].getKey())<0);j--) {
				Pair<K, ?> temp= array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}	
		}
	}
		
	// Hint: Maybe you need to create the helper methods.
}