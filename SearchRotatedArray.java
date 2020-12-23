
public class SearchRotatedArray {
	 public static int search(int[] nums, int target) {
		 int pivot=-1;
	for(int i=1;i<nums.length;i++)
	{
		if(nums[i-1]>nums[i])
		{
			pivot=i-1;
			break;
		}
	}
	if(pivot==-1)
		return binarysearch(nums, 0, nums.length-1, target);
	 if (nums[pivot] == target) 
         return pivot; 
	if(nums[0]<=target)
	{
		return binarysearch(nums,0,pivot,target);
	}
return binarysearch(nums,pivot,nums.length-1,target);
	
	
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
	                           + search(arr1,key)); 
	    } 
}
