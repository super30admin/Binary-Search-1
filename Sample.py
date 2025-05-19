# Problem 1: Search in 2D Sorted Matrix using binary search

# Time Complexity : O(log(mn))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m=len(matrix)
        n=len(matrix[0])

        low=0
        high=m*n-1

        while low<=high:
            mid=low + (high-low)//2
            mid1=mid//n
            mid2=mid%n
            if matrix[mid1][mid2]==target:
                return True
            
            elif matrix[mid1][mid2] > target:
                high=mid-1
            else:
                low=mid+1
        return False
    

# Problem 2: Searching an element in a rotated sorted array using binary search algorithm.
# Firstly compute mid value, check if mid is target. If so, return the index. If not , check which side is sorted, then check if target is within the sorted side. Reject the side which doesnt have the target.
# If low pointer crosses high pointer, then the element doesnt exist in the array.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        h=len(nums)-1

        while (l<=h):
            mid=l+(h-l)//2

            if nums[mid]==target:
                return mid
            
            if (nums[l]<=nums[mid]): #Left Side Sorted
                if (nums[l]<=target and nums[mid]>target):
                    h=mid-1
                else:
                    l=mid+1
            
            else: #Right Side Sorted
                if (nums[mid] < target and nums[h] >= target):
                    l=mid+1
                else:
                    h=mid-1
        return -1
    

# Problem 3: Search in sorted array of unknown size

# Time Complexity : O(logT)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Locked (Premium required)
# Any problem you faced while coding this : No

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high *= 2

        while low <= high:
            mid = low + (high - low) // 2
            val = reader.get(mid)

            if val == target:
                return mid
            elif val > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
    

