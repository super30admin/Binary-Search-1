''' https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Given a sorted array of unknown length and a number to search for, 
return the index of the number in the array. 
Accessing an element out of bounds throws exception. 
If the number occurs multiple times, return the index of any occurrence. 
If it isn’t present, return -1.
'''

from re import I


class Solution:
    def search(self, nums: 'list[int]', target: int) -> int:
        if nums == None: 
            return -1
        
        i = 0
        low = 0
        high = 2**i - 1
        
        while low <= high:    
            try:
                if target > nums[high]:
                    i += 1
                    low = high
                    high = 2**i-1
                else:
                    mid = int(low + (high-low)/2)
                    if nums[mid] == target:
                        return mid
                    elif target < nums[mid]:
                        high = mid-1
                    else:
                        low = mid+1                        
            except IndexError:
                high = int(low + (high-low)/2) # new high is midpoint old_low..old_high
                if high == low:
                    return -1
        
        return -1
        
        # try:
        #     while target > nums[high]:
        #         i += 1
        #         high = 2**i - 1
        # except IndexError:

        #     pass
s = Solution()
arr = [1, 2, 3, 4, 5, 7]
print(s.search(arr, 6))



