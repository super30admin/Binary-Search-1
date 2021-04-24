// Time Complexity :O(log n) where n in the number elements in the nums
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0;
        int high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            cout<<mid<<endl;
            if(nums[mid] == target) return mid;
            else if(nums[low] <= nums[mid]){   //left is sorted
                if(nums[low] <= target && nums[mid] > target)  //target is present left side
                    high = mid-1;
                else        //target is present right side i.e unsorted part
                    low = mid+1;
            }
            else{
                if(nums[mid] < target && nums[high] >= target) // right is sorted and target is present 
                    low = mid+1;
                else   //right is sorted but the target is present on the left unsorted side of the vector
                    high = mid-1;  
            }
        }
        return -1;
    }
};