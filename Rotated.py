// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums);
        low =0;
        high = n-1;
        
        while(low<=high):
            mid = int (low+(high - low)/2);
            if nums[mid] == target:
                return mid;
            elif nums[low]<= nums[mid]:
                if target>= nums[low] and target < nums[mid]:
                    high = mid -1;
                else:
                    low = mid +1;
            else:
                if target > nums[mid] and target <= nums [high]:
                    low = mid +1 ;
                else:
                    high = mid -1
        
        return -1;
                    
        