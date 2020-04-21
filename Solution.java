package GFG_Search_in_infinite_array;

//length of array is unknown array sorted
//Time Complexity  : O(nlogn)  
//Space Complexity : O(1)

public class Solution {

	public int search(int[] nums, int target) {
		if(nums == null || nums.length ==0) {
			return -1;
		}

		if(nums.length < 2) {
			if(nums[0] == target) {
				return 0;
			}else {
				return -1;
			}
		}

		int left = 0;
		int right = 1;

		while(target > nums[right] ) {
			left = right;
			right = 2*right;
		}

		int ans = binarySearch(nums, target,left,right);

		return ans;
	}


	public int binarySearch(int[] nums, int target,int left,int right) {
		if(nums == null || nums.length ==0) {
			return -1;
		}
		while(left <=right) {
			int mid = left + (right - left)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] > target) {
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return -1;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		int[] nums = {4,5,6,7,0,1,2};
		//		int target  = 3;
		int[] nums = {1,2,3,9,10,11,60,66,100};
		int target  = 10;

		Solution  s =  new Solution();
		System.out.println(s.search(nums, target));

	}

}

//
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1