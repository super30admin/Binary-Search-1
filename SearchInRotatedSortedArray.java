// Time Complexity : O(logN) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int [] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        
        int rotatationIndex = findRotationIndex(0, n - 1);
        if (nums[rotatationIndex] == target)
            return rotatationIndex;
        if(rotatationIndex == 0)
            return searchElement(0, n -1);
        if (target < nums[0])
            return searchElement(rotatationIndex, n - 1);
        return searchElement(0, rotatationIndex);   
    }
    
    public int findRotationIndex(int left, int right) {
        if(this.nums[left] < this.nums[right]) 
            return 0;
        
        while(left <= right) {
            int pivot = (left  + right) / 2;
            if(this.nums[pivot] > this.nums[pivot+1]) {
                return pivot + 1;
            } else {
                if (this.nums[pivot] < this.nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }
    
    public int searchElement(int left, int right) {
        while(left <= right) {
            int mid  = (left + right) / 2;
            if(this.nums[mid] > target) {
                right = mid-1;
            } else if(this.nums[mid] < target) {
                left  = mid +1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}