/*

Time Complexity : Binary search complexity O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:

I chose to solve this problem using binary search cause the given array is sorted array,
though it is rotated but if we are able to compare arr elements from the mid pointer we can modify
our left and right pointer for the array
1. Choosing left as the 0 and right should be length of the array minus 1 (0-indexed array)
2. For the best scenario the array is sorted in the ascending order only but now for this problem it is rotated,
so there will be cases for some points the array is strictly increasing and can be decreasing
3. Based on the value of the mid element I am shifting my left and right pointer after comparing it to target element,
the logic is same as we change index in binary search
4. If element which we are searching for is not there in the array, I am returning -1 as the index

 */
public class SearchInRotateSortedArray {
    public static int searchInRotatedSorted(int[] nums, int target){

        int left = 0;
        int right = nums.length-1;

        while(left<= right){
            int mid = left+ (right-left)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>= nums[left]){
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right]>= target && target>nums[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int [] arr = {4,5,6,7,0,1,2};

        System.out.println("Number is present at index: "+ searchInRotatedSorted(arr, 0));
        System.out.println("Number is present at index: "+ searchInRotatedSorted(arr, 7));
    }
}
