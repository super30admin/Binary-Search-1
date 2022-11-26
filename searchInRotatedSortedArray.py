# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : I had a little bit of issue with line 23 as I did not consider <= as sorted


# // Your code here along with comments explaining your approach in three sentences only
 

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0 
        high = len(nums)-1
        ## we start our binary search
        while low <= high :
            mid = low + (high - low)//2

            if (nums[mid] ==  target):
                return mid
            
            ## check if left side is sorted 
            if (nums[low]<=nums[mid]):
                ## check if elemenet is also on left side
                if ([low] <= target < nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            
            ## if left is not sorted , then right must be sorted
            else:
                ## check if element is on right side as well
                if (nums[mid] < target <= nums[high]):
                    low = mid+1
                else:
                    high = mid-1
        return -1
