// Time Complexity :  O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

public class BinarySearch{
	
     public int search(int[] nums, int target) {
         //checking whether the input array is empty
         if(nums.length==0 || nums==null){
             return -1;
         }


        //finding the low and high indices
    	 int l = 0;
    	 int h = nums.length-1;
    	 int mid = 0;
    	 while(l<=h) {
    		 mid = l + (h-l)/2;
    		 
             //if the target is equal to middle element then we return the mid index
    		 if(nums[mid]==target) {
    			 return mid;
    		 }
    		 if(nums[l]<=nums[mid]) {                                                //checking whether the left half of the array is sorted
    			 if(target<nums[mid] && nums[l]<=target) {                           //checking the target is within the limits for the left half
    				 h = mid-1;
    			 }
    			 else {
    				 l = mid+1;
    			 }
    		 }
    		 else {
    			 if(target>nums[mid] && target<=nums[h]) {                             //checking the target is within the limits for the right half
    				 l = mid+1;
    			 }else {
    				 h = mid-1;
    			 }    			
    		 }
    	 }
    	 return -1;
    }
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] nums = {5,6,7,0,1,2};
		System.out.println(bs.search(nums, 2));
		
	}
}

