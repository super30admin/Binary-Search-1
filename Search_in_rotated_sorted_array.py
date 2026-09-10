// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#Since this is a rotated sorted array I have used binary search to 
# check which side is sorted and comapred whether target lies in the sorted side


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        return -1

#Time - O(N) Linear Search Traverse through the list

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                return mid
            if nums[low] <= nums[mid]: #Left half is sorted
                if nums[low] <= target and nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:  #Right half is sorted
                if nums[mid] < target and nums[high] >= target:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1
            
    
#Time - O(logN) Binary Search
