package test11;

public class RotatedSortedArray {

	// Returns index of x if it is present in arr[l.. r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        //Write your code here
    	if (arr == null || arr.length == 0) {
    		System.out.println("Empty array ");
    		return -1;
    	}
    	
    	// check left & right
    	if (l > r) {
    		//System.out.println("Invalid left/right index");
    		return -1;
    	}
    	// get mid
    	int mid = l+ (r - l)/2;
    	
    	//System.out.println(" l "+l+ " right "+r + " mid "+mid);
    	
    	if (arr[mid] == x) {
    		// found index
    		return mid;
    	} else {
    		// we have to check which half is sorted & which half is not
    		if (arr[l] <= arr[mid]) {
    			// left side is sorted
    			if (x < arr[mid] && x >= arr[l]) {
    				// target x, if present, in this half
    				r = mid - 1;
    			} else {
    				// explore right half
    				l = mid + 1;
    			}
    		} else if (arr[mid] <= arr[r]) {
    			// right side is sorted
    			if (x > arr[mid] && x <= arr[r]) {
    				// target x, if present, in this half
    				l = mid + 1;
    			} else {
    				// explore left half
    				r = mid - 1;
    			}
    		} else if (arr[l] > arr[mid]) {
    			// left side is unsorted, search here
    			r = mid - 1;
    		} else if (arr[mid] > arr[r]) {
    			// right side is unsorted, search here
    			l = mid + 1;
    		}
    		else {   			
    			//System.out.println("Target not found ");
    			return -1;
    		}    			
        }
    	return binarySearch(arr, l, r, x);
    }

    //
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int result;

        result = this.binarySearch(nums, 0, n - 1, target);
        if (result == -1)
            System.out.println("Element "+target+ " not present");
        else
            System.out.println("Element "+target+" found at index " + result);
        
        return result;
        
   	
    }
    // Driver method to test above
    public static void main(String args[])
    {
        RotatedSortedArray rsa = new RotatedSortedArray();
        
        int nums[] = { 4,5,6,7,0,1,2 };
        int target = 0;

        rsa.search(nums, target);
        
        target = 3;
        rsa.search(nums, target);
 
        int arr1[] = { 6, 7, 0, 1, 2, 4, 5};
        target = 0;
        nums = arr1;
        rsa.search(nums, target);
        
        target = 3;
        rsa.search(nums, target);

    }
}
