"""
#Approach:
We are using binary search to find the target in a rotated sorted array.  
We first check which half of the array is sorted. 
If the left half is sorted, we check whether the target is within that range or not.
If the right half is sorted, it searches within that range. 

# Complexity
- Time complexity:
O(logn)

- Space complexity:
O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

class Solution: 
    def search(self, nums, target: int) -> int:
        start = 0
        end = len(nums) -1
        
        while(start<=end):
            mid = start + (end - start)//2
            if nums[mid] == target : #if mid equals target returning index of mid element
                return mid
            elif nums[start] <= nums[mid]: #checking left sorted ot not
                if (nums[start] <= target < nums[mid]): #if target in the left side, changing the end value
                    end = mid - 1
                else:
                    start = mid + 1 # else changing the start value
            else: #if right is sorted
                if (nums[mid] < target <= nums[end]):    
                    start = mid + 1 #if target in the right side, changing the start value
                else: # else changing the end value
                    end = mid - 1
                    
        return -1


nums = [4,5,6,7,0,1,2]
target = 0
nums1 = [4,5,6,7,0,1,2]
target1 = 3
sol = Solution()
print(sol.search(nums,target))
print(sol.search(nums1,target1))