# Problem 33 - https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        Approach:
            We are given an array, which is sorted and rotated once, so there is a pivot
            on which the array is rotated. 
            For ex : [4,5,6,7,0,1,2,3]
            Here It is shifted four times and the pivot is at 7.

            We are aware that array is sorted except at the pivot, I mean left and right
            parts of the array are always sorted -> [4,5,6.7] and [0,1,2,3]
            
            So we can use binary search, with little modification. We can find mid normally,
            we check if element at mid is equal to target, then return the mid index.

            if element at low is less than mid, that means it is sorted, for example
            [4 & 7] so all the elements are sorted in this subarray, we can then check if 
            target lies in between them, if yes we move our high to mid - 1
            otherwise we eliminate this subarray and move our low to mid + 1

            if above base condition is false, then we might find our target in the other half
            of the array. We can check if target lies between elements at mid and high, and move
            our low to mid + 1, else high to mid - 1

            if we cannot find our target, then we will return -1.   


        Time Complexity:
            O(log(N))
        Space Complexity:
            O(1) 
        """
        low = 0
        high = len(nums) - 1
        mid = 0
        while(low <= high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            elif nums[low] <= nums[mid]:
                if nums[low] <= target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                if nums[mid] < target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1