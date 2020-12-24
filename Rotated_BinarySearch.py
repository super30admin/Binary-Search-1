# Time Complexity : logn + logn, O(logn) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : For the modified binary search to smallest element index- struggled a bit to get the condition check for "found".   
# Your code here along with comments explaining your approach

# 1. Find the index of smallest element - the array rotates around it.
# 2. Base condition 1: check if target is the smallest element - return index
# 3. Base condition 2: check if array is rotated - if not, perform BS on entire array (smallest index = 0)
# 4. If rotated: perform BS on 
#                a. right side of rotate index(target< nums[0]) 
#                b. else: left side of rotate index
class Rotated_BinarySearch:
    def search(self, nums, target):
        # modified BS to find smallest index
        def findIndexOfSmallestElement(left, right):
            if nums[left] < nums[right]:
                return 0
            while left <= right:
                pivot = (left + right) // 2
                if nums[pivot] > nums[pivot + 1]: # if the element at pivot is greater than the next element in the middle of the array, the sorted array starts from next index
                    return pivot + 1
                else:
                    if nums[pivot] < nums[left]:
                        right = pivot - 1
                    else:
                        left = pivot + 1
        # BS
        def binarySearch(left, right):
            while left <= right:
                pivot = left + (right - left) // 2
                if nums[pivot] == target:
                    return pivot
                else:
                    if target < nums[pivot]:
                        right = pivot - 1
                    else:
                        left = pivot + 1
            return -1

        n = len(nums)
        if n == 1:
            return 0 if nums[0] == target else -1
        indexOfSmallestElement = findIndexOfSmallestElement(0, n - 1)
        # Base condition 1
        if nums[indexOfSmallestElement] == target:
            return indexOfSmallestElement
        # Base condition 2
        if indexOfSmallestElement == 0:
            return binarySearch(0, n - 1)
        if target < nums[0]: # condition check for second BS
            return binarySearch(indexOfSmallestElement, n - 1)
        else:
            return binarySearch(0, indexOfSmallestElement)

# Driver code
obj = Rotated_BinarySearch()
nums = [4,5,6,7,0,1,2]
target = 0
print(obj.search(nums, target))