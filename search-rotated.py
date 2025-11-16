# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :None


# Your code here along with comments explaining your approach in three sentences only
#check if left sorted or right sorted, and then do binary search
#if left sorted, then check in left sorted array else in right sorted
#Do binary search for finding element in both

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (high + low) #2
            if(nums[low] <= nums[mid]):
                if(target == nums[mid]):
                    return mid
                elif (target >= nums[low] and target < nums[mid]):
                    high =  mid -1
                else:
                    low = mid + 1
            else:
                if(target == nums[mid]):
                    return mid
                elif (target > nums[mid] and target <= nums[high]):
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
        