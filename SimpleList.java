/**
 * Simple List Class
 * 
 * @author Adi Kulkarni
 * Class ID: 304
 * Assignment #: 2 
 * Description: This program is a simple list class that adds, removes, 
 * returns number of elements, searches, and returns a string of the array.
 */

package assign2;

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
		if(list.length == count) { //if array is at capacity
		    int tempList[] = new int[(int) Math.floor(list.length * 1.5)]; //create new array with 50 percent more elements
		    System.arraycopy(list, 0, tempList, 0, list.length); //copy elements into new array
		    list = tempList; //set list to new array
		    System.arraycopy(list, 0, list, 1, list.length - 1); //will shift the array elements by 1
		    list[0] = number; //add element to array
		    count++; 
		}
		else {
	        System.arraycopy(list, 0, list, 1, list.length - 1); //will shift the array elements by 1
	        list[0] = number; //adds number to beginning of array
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
        if (count < Math.floor(.75 * list.length) == true) { //if array is too big, meaning that count is less than 75 percent of list length
        	int[] tempList = new int[count]; //create new array with amount of elements
        	for(int i = 0; i < count; i++) { //copy elements in new array
        		tempList[i] = list[i];
        	}
        	list = tempList; //set list to new array
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
	
	/**
	 * first() Method
	 * 
	 * @return first element of the list.
	 */
	
	public int first() {
		if(count > 0) {
			return list[0];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * last() Method
	 * 
	 * @return last element of the list
	 */
	public int last() {
		if (count > 0) {
			return list[list.length - 1];
		}
		else {
			return -1;
		}
	}
	
	/**
	 * size() Method
	 * 
	 * @return size of the list	 
	 * */
	public int size() {
		return list.length;
	}
	
	/**
	 * append() Method
	 * 
	 * Append the passed number to the end of the list. 
	 **/
	public void append(int number) {
		if(list.length == count) {
		    int tempList[] = new int[(int) Math.floor(list.length * 1.5)];
		    System.arraycopy(list, 0, tempList, 0, list.length); 
		    list = tempList;
		    list[count] = number;
		    count++; 
		}
		else {
		    list[count] = number;
		    count++; 
		}
	}
	
}
