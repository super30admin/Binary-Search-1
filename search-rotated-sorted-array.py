"""
Runtime Complexity:
O(log n) -  Performing a binary search takes O(log n) time. Because we find a middle element and then iteratively divide the given array into two halves, left and right.
We check whether the target element is equal to the mid and return it if true. We check if mid is less than high- this means that the right halve is sorted and we also check whether the
target lies in that range, if it does then we increase the low to mid+1 else high=mid-1, which means we go to the left halve. If the target lies in the sorted left half of the array, then
we update high= mid-1 else low = mid+1.  This iteration keeps on going and the array is cut into two equal halves everytime by changing the pointers. Finally when the
target is same as mid we return else -1.

Space Complexity:
O(1)- the solution did not use extra space to compute.

Yes, the code worked on leetcode.
"""


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums)==0:
            return -1
        low = 0
        high = len(nums)-1
        
        
        while low<=high:
            mid = low+ (high-low)//2     #to prevent interger overflow
            
            if nums[mid] ==target:
                return mid
            if nums[mid]< nums[high]:
                if nums[mid]< target<= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
                
            else:
                if nums[low]<= target<nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
        return -1
        
