// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size() == 1) {
            if(nums[0] == target) return 0; 
            return -1; 
        }   

        int pivot = findPivot(nums);

        cout << "The pivot is: " << pivot << endl; 

        if(target == nums[pivot]) return pivot; 

        if(pivot == 0) return targetSearch(nums, 0, nums.size()-1, target);

        if(target < nums[0]) return targetSearch(nums, pivot+1, nums.size()-1, target);
        else return targetSearch(nums, 0, pivot-1, target);

        return -1; 
    }

    int targetSearch(vector<int>& nums, int start, int end, int target) {
        while(start <= end) {
            int mid = (start+end)/2; 
            if(nums[mid] == target) return mid; 
            if(nums[mid] < target) start = mid+1;
            else end = mid-1; 
        }
        return -1; 
    }

    int findPivot(vector<int>& nums) {
        int start = 0;
        int end = nums.size()-1;  
        
        if(nums[start] <= nums[end]) return 0; 

        while(start <= end) {
            int pivot = (start+end)/2;
            if((pivot-1 >= 0) && (pivot < nums.size()) && nums[pivot] < nums[pivot-1]) return pivot; 
            if(nums[pivot] >= nums[0]) start = pivot+1; 
            else end = pivot-1; 
        }

        return 0; 
    }
};