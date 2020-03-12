# Binary search - 1

// Time Complexity : O(log N)
// Space Complexity : O(1) constant time complexity?
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach - 
1. Define start index, end index.
2. Use a while loop. Calculate the middle index (ensure it doesn't go beyond the bounds).
3. If middle is the target, return the same.
4. If the array is left-sorted (pivoted after middle), check if target lies between start and middle. If yes, change the 
end to middle -1. Else, change start to middle +1.
4. Else if, array is right-sorted, check if target lies between middle and  end. If yes, shift start to middle +1. Else,shift end 
to middle -1.
6. If none of the values are found, return -1.

class Solution:
    def search(self, nums, target) -> int:

        start, end = 0, len(nums) - 1

        while start <= end:

            middle = start + (end - start) // 2   # Takes care of overflow problem
            if nums[middle] == target:
                return middle
            elif nums[middle] >= nums[start]:     # Left-sorted
                if target >= nums[start] and target <= nums[middle]: # Target  lies between start and middle
                    end = middle - 1
                else:
                    start = middle + 1
            else:                                 # Right-sorted
                if target <= nums[end] and target >= nums[middle]: # Target lies between middle and end
                    start = middle + 1
                else:
                    end = middle - 1
        return -1

s = Solution()
s.nums=[4,5,6,7,0,1,2]

print(s.search(s.nums, 1))
print(s.search(s.nums, 4))
print(s.search(s.nums, 2))
print(s.search(s.nums, 7))
print(s.search(s.nums, 1000))
