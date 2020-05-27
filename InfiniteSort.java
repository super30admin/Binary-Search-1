/**
 * Time Complexity : O(nlogn) 
 */
class InfinteSort{
	static int search(int nums[], int low, int high, int target) 
	{ 
        if (low>high) 
            return -1;
        else{
            int mid = (low+high)/2;
			if (nums[mid] == target) 
				return mid; 
			if (nums[mid] > target) 
				return search(nums, low, mid-1, target); 
			return search(nums, mid+1, high, target);
        }
	} 
	
	static int getIndex(int nums[],int target) 
	{ 
        int low = 0;
        int high = 1; 
        int val = nums[0]; 
        
		while (val < target) 
		{ 
            low = high;	
            int checkIndexOutOfBounds = high+1; 
			if(checkIndexOutOfBounds < nums.length-1) 
			    high = checkIndexOutOfBounds;			 
			else
			    high = nums.length-1; 
			
			val = nums[high]; 
		} 
		return search(nums, low, high, target); 
	} 

	public static void main(String[] args) 
	{ 
        int nums[] = new int[]{1,4,20,58,82}; 
        int x=58;
        System.out.println("Searching for "+x);
		int result = getIndex(nums,x); 
		
		if (result==-1) 
			System.out.println(x+" not present"); 
		else
			System.out.println(x+" found at "+result); 
	} 
} 
