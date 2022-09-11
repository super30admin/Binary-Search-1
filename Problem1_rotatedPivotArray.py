# Time Complexity : O(log n) because twith every iteration the length of array in which we search reduces to half
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Had to refer to suggestion in order to come to this approach


# Your code here along with comments explaining your approach : - We look for a sorted part and the check if the target is greaterr or 
# lower than that and then we just perform the regular binary search based on target greater or lower


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums == None  or len(nums) == 0:
            return -1
        first = 0 
        last = len(nums) -1  
        while first <= last:
            mid = (first + last) // 2 
            if nums[mid] == target:
                return mid 
            # left part is sorted 
            if nums[first] <= nums[mid]:
                if target >= nums[first] and target < nums[mid]:
                    last = mid -1 
                else: 
                    first = mid + 1 
            # right part is sorted 
            else:
                if target > nums[mid] and target <= nums[last]:
                    first = mid +1
                else:
                    last = mid - 1
        return -1