
"""
We need to check whether the arr is left sorted or right sorted and then search the target in the sorted side which we can handle 
and ignore the other part if we found the value at mid return the value
"""

#Time complexity: O(logn)
#Space complexity:  O(1)

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        low = 0
        high = len(nums) -1 

        while(low <= high):
            mid = low + (high - low) //2  #reduce the integer overflow error
            if(nums[mid] == target):
                return mid
            #left sorted
            if(nums[low] <= nums[mid]):
                if (nums[mid] > target and nums[low] <=target):
                    high = mid -1
                else:
                    low = mid + 1
            else: #right sorted
                if(nums[mid] < target and nums[high] >= target):
                    low = mid +1
                else:
                     high = mid -1
            
        return -1

                


        