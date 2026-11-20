// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Dont have LeetCode Premium so could not check
// Any problem you faced while coding this : No.

//Approach : As the array is sorted larger elements are on higher indexes. search for elemnt greater than target by taking rigt boundary and doubling it till nums[right] beomes greater than or equal target or goes out of bounds. if out of bounds return -1. else perform binary search from 0 till index. if target found return the correspoding index. else return -1.
class Problem3 {
    public int Solution(int[] input, int target) {
        if(input[0] == target){
            return 0;
        }
        l = 1;
        r = 1;
        while(true){
            try {
                if(input[r] >= target){
                    break;
                }
                r = r * 2;

    } catch (ArrayIndexOutOfBoundsException e) {
        return -1;
    }
        }
        
        while(l <= r){
            int mid = l +(r-l)/2;
            if(target == input[mid]){
                return mid;
            }
            else if(target < input[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
        
    }
}
