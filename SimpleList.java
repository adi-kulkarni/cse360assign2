/**
 * Simple List Class
 * 
 * @author Adi Kulkarni
 * Class ID: 304
 * Assignment #: 1 
 * Description: This program is a simple list class that adds, removes, 
 * returns number of elements, searches, and returns a string of the array.
 */

package assign1;

/**
 * Class
 * 
 * The Simple List class provides the means to manipulate a 10 element integer array.
 */

public class SimpleList {
	int[] list;
	int count;
	
	/**
	 * Constructor
	 * 
	 * Creates an instance of SimpleList with count set to 0 and an empty list with 10 elements.
	 */
	
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * add() Method
	 * 
	 * Add a number to the list and increment count.
	 * 	 
	 */
	
	public void add(int number) {
        System.arraycopy(list, 0, list, 1, list.length - 1); //will shift the array elements by 1
        list[0] = number; //adds number to beginning of array
        if(count == 10) {
        	//do nothing
        }
        else{
            count++;	
        }
	}
	
	/**
	 * remove() Method
	 * 
	 * Remove a number from the list and decrement count.
	 */
	
	public void remove(int number) {
		boolean numberFound = false;
		for(int index = 0; index < list.length - 1; index++) {
			if(list[index] == number) {
				numberFound = true;
			}
			if(numberFound) {
				list[index] = list[index + 1]; //shift elements in array to right by 1
			}
		}
		if(list[list.length - 1] == number) { //check if the last number in array is the number passed
			numberFound = true;
		}
		if(numberFound) {
			list[list.length - 1] = 0; //set last element to 0 because elements are shifted
			count--;
		}
	}
	
	/**
	 * count() Method
	 * 
	 * @return int that is the count of elements in the list.
	 */
	
	public int count() {
		return count; //returns the number of elements in the array
	}
	
	/**
	 * toString() Method
	 * 
	 * @return String that is the array elements of the list	
	 */
	
	public String toString() {
		String toString = "";
		for(int index = 0; index < list.length; index++) {
			if(index == list.length - 1) { // do not print space for last element
				toString += list[index];
			}
			else { 
				toString += list[index] + " ";
			}
		}
		return toString; //returns the array in a string form
	}
	
	/**
	 * search() Method
	 * 
	 * @return int that is the index of the user specified integer.
	 */
	
	public int search(int number) {
		int indexToReturn = -1;
		
		for(int index = 0; index < list.length; index++) {
			if(list[index] == number) {
				indexToReturn = index;
				index = list.length + 1; //leave the loop
			}
		}
		return indexToReturn; //returns the index of the passed number
	}
}
