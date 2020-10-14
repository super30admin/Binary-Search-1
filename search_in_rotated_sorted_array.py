# Time complexity:- O(log(n))
# Space Complexity:- O(1) Not creating another data structure working on the same nums array
# Did this code successfully run on Leetcode :Yes
# Idea:- One part of the array will always be sorted either it can low-mid or mid-hi,
# search for the target element in the sorted part first if not found search in the 
# other part.

class Solution:
    def search(self, nums, target):
        low=0
        hi=len(nums)-1
        while(low<=hi):
            mid=(low+hi)>>1
            if nums[mid]==target:
                return mid
            # low-mid is sorted
            if nums[low]<=nums[mid]:
                # search for target in low-mid
                if nums[low]<=target<nums[mid]:
                    hi=mid-1
                else:
                    low=mid+1
            else:
                # mid-hi is sorted, searching for target in mid-hi
                if nums[mid]<target<=nums[hi]:
                    low=mid+1
                else:
                    hi=mid-1
        return -1