# Time Complexity : O(logn) n being size of array after fixing the indexes before BS 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, but in local cannot find if target is last element - am using finite array for test
# Any problem you faced while coding this : Doubling the right/end index until the scope of consideration includes target -> similar to memory management mechanism of contiguous data structures    
# Your code here along with comments explaining your approach

# Two step process:
# 1. find start and end indices
# 2. BS
class UnknownSize:
    def search(self, nums, target):
        # BS
        def binarySearch(left, right):
            while left <= right:
                pivot = (left + right) // 2
                if nums[pivot] == target:
                    return pivot
                else:
                    if target < nums[pivot]:
                        right = pivot - 1
                    else:
                        left = pivot + 1
            return -1
        
        # find start and end indices
        # start with first two indices
        left, right = 0, 1
        # extend end index(doubles every time) until we include target with-in the scope of search
        while nums[right] < target:
            left = right
            right *= 2     
        # binary search
        return binarySearch(left, right)

# Driver code
obj = UnknownSize()
nums = [-1,0,1,2]
target = 2
print(obj.search(nums, target))