#Core idea: One half of the array will always be sorted. Search for the element in the sorted part of the arrays and 
#reduce/adjust search space
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums)-1
        while (low<=high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            if (nums[low]<=nums[mid]):         #Left half is sorted
                if (nums[low]<=target and nums[mid]>target):    #Element found in the left half
                    high = mid-1
                else:
                    low = mid+1
            elif (nums[mid]<=nums[high]):     #Right half is sorted
                if (nums[mid]<target and nums[high]>=target):   #Element found in the right half
                    low = mid+1
                else:
                    high = mid-1
        return -1

#Time Complexity: O(Log N)
#Compiled in Leetcode