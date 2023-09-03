# // Time Complexity :O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# Your code here along with comments explaining your approach in three sentences only
# Here the key observation is in a rotated sorted array atleast 1 side of array is sorted through this we performed binary search and have calculated if it
# it is in the range of that half through which we are finding element sin O(logn) 


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(nums[mid]==target):
                return mid
            elif(nums[mid] >= nums[low] ):
                if(target < nums[mid] and target >= nums[low]):
                    high=mid-1
                else:
                    low=mid+1
            else:
                if(target > nums[mid] and target <= nums[high]):
                    low=mid+1
                else:
                    high=mid-1
        
        return -1
