// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start =0;
        int end =nums.size()-1;
        
        while(start<=end){
            int mid = (start)+(end-start)/2;
            
            if(nums[mid]==target) return mid;
            
            if(nums[start] <= nums[mid]){
                if(target>= nums[start] && target < nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            
            else if(nums[start]>nums[mid]){
                if(target>nums[mid] && target <=nums[end]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        
        return -1;
    }
};
