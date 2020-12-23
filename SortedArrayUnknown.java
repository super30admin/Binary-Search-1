
public class SortedArrayUnknown {
	 public static int findhigh(int[] nums, int target) {
		 int val=nums[0];
		 int high=1,low=0;
		 while(val<target) {
			 low=high;
			 if(2*high<nums.length-1)
			 {
				 high=2*high;
			 }
			 else
			 {
				 high=nums.length-1;
			 }
			 val=nums[high];
	}
		 return binarysearch(nums, low, high, target);
	 }
	 public static int binarysearch(int nums1[],int low,int high,int target)
	 {
		 int mid=low+(high-low)/2;
		 System.out.println("low"+low+"high"+high+"mid="+mid);
		 if(high<low)
			 return -1;
		 if(nums1[high]==target)
			 return high;
		
		 if(target==nums1[mid])
		 {
			 return mid;
		 }
		 if (target > nums1[mid]) 
	            return binarysearch(nums1, (mid + 1), high, target); 
	       return binarysearch(nums1, low, (mid - 1), target); 
	 }
	 public static void main(String args[]) 
	    { 
	        // Let us search 3 in below array 
	        int arr1[] = { 3,1 }; 
	        int n = arr1.length; 
	        int key = 1; 
	        System.out.println("Index of the element is : "
	                           + findhigh(arr1,key)); 
	    } 

}
