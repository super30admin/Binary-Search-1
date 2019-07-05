
public class SearchUnknownLengthArray_WithoutLength {

	public static int binarySearch(int[] nums, int left, int right, int target) {
		while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] == target) {
	        	return mid;
	        }
	        else if (nums[mid] < target ) {
	        	left = mid + 1;
	        }
	        else {
	        	right = mid - 1;
	        }
	    }
	    return -1;
	}
	
	public static int calBounds(int arr[], int lo, int hi, int val) {
		try {
			while(arr[hi] <= val) {
				lo = hi;
				hi = 2 * hi;
			}
		}
		catch (Exception e) {
			System.out.println("Out of bounds");
			try {
				while(arr[lo] < val) {
					if(arr[lo] == val)
					return lo - 1 ;
					lo++;
				}
			} catch (Exception e1) {
				System.out.println(-1);
			}
		}
		return binarySearch(arr, lo, hi, val);
	}
	
	// Driver method to test the above function 
    public static void main(String[] args)  
    { 
//    	SearchUnknownLengthArray_WithoutLength sa = new SearchUnknownLengthArray_WithoutLength();
    	
    	int nums[] = new int[]{3, 5, 7, 9, 10, 90,  
                100, 130, 140, 160, 170};
    	 System.out.println(calBounds(nums, 0, 1, 100));
    	 System.out.println(calBounds(nums, 0, 1, 1));
    	 System.out.println(calBounds(nums, 0, 1, 170));
       
    	
//        if (ans==-1) 
//            System.out.println("Element not found"); 
//        else
//            System.out.println("Element found at index " + ans); 
    }
	
}
