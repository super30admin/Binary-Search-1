package BinarySearch1;

public class SearchRotatedSortedArray {
	  public int search(int[] nums, int target) {
	        if(nums == null || nums.length==0) return -1;
	          int left=0;
	        int right=nums.length-1;
	        while(left<= right){
	          int mid =  left+(right-left)/2;
	            if(nums[mid]==target) return mid;
	            //scenario:left is sorted
	             else if(nums[left]<=nums[mid]){
	                 //if sorted check range
	                 if(nums[left]<=target && nums[mid]> target){
	                     right=mid-1;
	                 }
	                 else{
	                     left=mid + 1;
	                 }
	             }
	            //scenario:right side is sorted
	else{
	    if(nums[mid]<target && nums[right]>=target){
	        left=mid+1;
	    }
	    else{
	        right=mid-1;
	    }
	}                 
	            
	        }
	        
	        return -1;
	        
	    }

}
