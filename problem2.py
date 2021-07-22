# // Problem2 
# //Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
# //the approach for this problem is finding where the array has been rotated adn then treatign it like a normal sort array
# //time complexity : O(log n)
# //Leet code solution accepted : all test cases passed
#comments and explaination done in java solution

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums)==0:
            return -1
        left = 0
        right = len(nums)-1
        while (left<right):
            mid = (left+right)//2
            if (nums[mid]>nums[right]):
                left = mid+1
            else:
                right = mid
        start = left
        left = 0
        right = len(nums)-1
        if (target>=nums[start] and target<=nums[right]):
            left =start
        else:
            right = start
        while(left<=right):
            mid = (left+right)//2
            if (nums[mid]==target):
                return mid
            elif target>nums[mid]:
                left = mid+1
            elif target<nums[mid]:
                right = mid-1
        return -1