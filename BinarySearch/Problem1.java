/*package BinarySearch;

/*Approach 1
 * - found the mid element checked if equal to target
 * - if array is rotated and left side of mid is all increasing elements then we search in left 
 * - eg if(nums[mid]>nums[start])
 * - then we check if target lies in start to mid part : if yes - end = mid-1
 * - start=mid+1
 * - Similarly for other part which might or might not have all increasing elements
 * 
 * Complexity : O(n)
 * As we do binary search every time we divide the array into halves
 * */
/*
public class Problem1 {
	
	
	public static  int findelement(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		
		if(nums==null)
			return -1;
		if(nums.length==0)
			return 0;
		
		while(start<=end) {
			int mid= (start+end)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]>=nums[start]) {
				if(target>=nums[start] && target<=nums[mid])
					end=mid-1;
				else
					start=mid+1;
			}else {
				if(target<=nums[end] && target>=nums[mid])
					start=mid+1;
				else
					end=mid-1;
			}
				
				
			
		}
		
		return -1;
		
	}
	
	public static void main(String args[]) {
		int[] nums= new int[]{4,5,6,7,8,0,1,2,3};
		int target=7;
		int res= findelement(nums,target);
		System.out.println("result:"+res);
	}
}
*/