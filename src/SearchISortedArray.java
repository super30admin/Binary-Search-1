
public class SearchISortedArray {
	
	public int search(int[] nums,int target)  
    { 
        int l = 0, h = 1; 
        int val = nums[0]; 
  
        while (val < target) 
        { 
            l = h;
            if(2*h < nums.length-1) 
               h = 2*h;              
            else
               h = nums.length-1; 
              
            val = nums[h];  
        } 
        return binarySearch(nums, l, h, target); 
    }
	
	public int binarySearch(int[] nums, int l, int r, int target) {
		if(l>r) {
			return -1;
		}
		int mid = (l+r)/2;
		if(nums[mid] == target) {
			return mid;
		}
		if(nums[mid] > target) {
			return binarySearch(nums, l, mid-1, target);
		}else {
			return binarySearch(nums, mid+1,r, target);
		}
	}

	public static void main(String[] args) {
		SearchISortedArray myObj = new SearchISortedArray();
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}; 
		System.out.println(myObj.search(arr, 130));
	}
}
//Time Complexity : O(logp)
//Space Complexity : O(logp)
//Did this code successfully run on Leetcode : Not found in leetcode
//Any problem you faced while coding this : No