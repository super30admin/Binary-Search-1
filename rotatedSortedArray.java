//Time Complexity : O(log n) as we are performing binary search
//Space Complexity : O(n) where n is size of Array. 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Yes, index is not prining correctly

//Your code here along with comments explaining your approach

/*Step 1: creating rotated array where either left of mid or right of mid will be sorted and opposite ill be unsorted
 * Step 2: If we find target at the middle, print middle index
 * Step 3: If we don't find target at the middle, we will comapare the target from the middle in sorted array that is if left part is sorted then is target is less than ledt mid or greater than left mid. 
 Step 4: iF less then high will be mid-1 and if greater than low will be mid+1. Same 3 and 4 steps repeat if target lies at right side sorted array. If targte not found or if array is empty return false or return target is not present
 */

import java.util.Scanner;
public class rotatedSortedArray {

	public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 1;
        
        int n = nums.length;
        
        int low=0;
        int high= n-1;
        
        while(low <= high)
        {
            int mid= low + ((high-low)/2);  // to prevent integer overflow
           
            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[low] <= nums[mid])//if left part is sorted
            {
                if(target >= nums[low] && target < nums[mid])
                {
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            else{  //right part is sorted
                if(target > nums[mid] && target <= nums[high])
                {
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in); 
		System.out.println("Enter the number of elements you want in an array \n");
	    	int in = inp.nextInt(); 
	    	int[] num= new int[in];
	    	System.out.println("Enter the integer element you want to add in Array");
	    	for(int i=0; i<in; i++)
	    	{
	    		Scanner sc= new Scanner(System.in); 
	    		
	    		num[i]=sc.nextInt();
	    	}
	    	System.out.println("Please enter the target integer element you want to check into Array");
	    		Scanner sc= new Scanner(System.in); 
	    		int targt =sc.nextInt();
	    		int result=search(num, targt);
	    		if(result == -1) {
	    			System.out.println("Target is not present in Array");
	    		}else {
	    			System.out.println("Target is present in Array");
	    		}
	}

}
