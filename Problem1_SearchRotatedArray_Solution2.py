#-------------  
# Explanation:
#-------------
# Use the property that One side of the mid is ALWAYS sorted.
#-----------------
# Time Complexity: 
#-----------------
# O(log(N)) - Binary search on M*N elements
#------------------
# Space Complexity: 
#------------------
# O(1) - Only using constant space to store index values and lengths


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32-40 ms  (45 - 97.42 %ile)
# Space            :  14.7MB (52.7 %ile)

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1

        while low <= high:
        	mid = low + (high-low)//2
        	if nums[mid] == target:
        		return mid

        	elif nums[low] <= nums[mid]:
        		if nums[low] <= target and nums[mid] > target:
        			high = mid-1
        		else:
        			low = mid+1

        	else:
        		if nums[mid] < target and nums[high] >= target:
        			low = mid+1
        		else:
        			high = mid-1

        return -1


