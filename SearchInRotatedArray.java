// Time Complexity : O(long n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int search(int[] arr, int target) {
        int s=0;
        int end = arr.length-1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid]<=arr[end]){             //checking if the array is right sorted
                if(arr[mid]< target && target <= arr[end]){ //If sorted checking whether it is present in right
                    s = mid+1;
                }
                else        
                    end=mid-1;
            }
            else                                //checking if the array is left sorted
            {
                 if(arr[s]<=target && target<arr[mid]){ //If sorted checking whether it is present in left
                    end = mid-1;
                }
                else
                    s = mid+1;
            }
            
        }
      return -1;  
    }
}