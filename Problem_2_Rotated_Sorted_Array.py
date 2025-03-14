// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l = 0
        r = n - 1

        # Step 1: Find the index of the smallest element (the index where the next element is smaller than the current element) using binary search 
        # (that would denote the position where the array is supposed to begin)
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        # Step 2: With this min index, pdate the left and the right pointers to see in which half of the array our target lies
        min_i = l
        if min_i == 0:
            l, r = 0, n - 1
        elif target >= nums[0] and target <= nums[min_i - 1]:
            l, r = 0, min_i - 1
        else:
            l, r = min_i, n - 1

        # Step 3: Perform binary search with the updated left and right pointers (During the search, if target is found at mid index, return mid index)
        # If search is completed, then target does not exist in range, so return -1
        while l <= r:
            mid = (l+r) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        
        return -1

        


        

        

