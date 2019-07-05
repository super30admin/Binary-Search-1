public class SearchNotKnowSizeArray {

	public static void main(String[] args) {
		int s[] = {1,2,3,4,5,6,7,8,8,9,9,10}; //rotated
		SearchNotKnowSizeArraySolution ss= new SearchNotKnowSizeArraySolution();
		System.out.println(ss.search(s, 14));
	}
}

/*
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
 * Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence.
 * If it isn’t present, return -1.
 *
 */
class SearchNotKnowSizeArraySolution {
	public int search(int[] nums, int target) {
		try {


			//Here the main problem is the not knowing the length of the array,
			// Since the array is already sorted, then we can easily apply binary search to get the element position.
			//Task is here to find the position of the key in the ggiven.

			//assuming 0th element as left in array
			// assuming 1st element as high in the array.
			//if target < high, we can apply the the binary search algorithms
			//if target > high , make the new low as high and high = 2*high and repeat untill we search target.

			//reference geeks for geesks
			//->if it is greater than high index element then copy high index in low index and double the high index.
			//->if it is smaller, then apply binary search on high and low indices found.






			int left = 0, right = 1;
			//Make Sure  left is less than right.
			while (left <= right) {

				if (target == nums[right]) {
					return nums[right];
				}

				if(target< nums[right]) {
					return binarySearch(nums,left,right,target);
				}else if(target>nums[right])
				{
					left = right;
					right = 2* right; // will throw array index out of bound , if it is greater than array size.
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException Occured");

		}
		return -1;
	}

	int binarySearch(int[] arr, int l, int r, int x) {
			int indexOfKey = -1;

	    	// Think of the smaller problems  say n= 1 , i.e array has only one element.

	    	if( l == r) {
	    		if(arr[l] == x) return l;
	    		else return indexOfKey;
	    	}else {
	    		int mid = (l+r)/2;
	    		if(x == arr[mid]) {
	    			indexOfKey = mid;
	    			return indexOfKey;
	    		}else if (x <= arr[mid] ) {
	        		return binarySearch(arr,l,(mid-1),x); // searching  left half of the mid value.
	        	}else {
	        		return binarySearch(arr,(mid+1),r,x);  // searching right half of the mid value.
	        	}
	    	}
	    }

}
