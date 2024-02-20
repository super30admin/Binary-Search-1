class Solution:
    """
    Time Complexity: O(log(n)) where n is the number of elements in the array
    Space Complexity: O(1) 
    
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    
    Your code here along with comments explaining your approach
    A. Brute Force: Perfrom the linear search and find the target. Once the target is found return its index
    
    Time Complexity: O(n) where n is the number of elements in the rotated sorted array
    Space Complexity: O(1)

    B. As the array is sorted, we can use the Binary Search to find the target element.
    - Set low = 0 and high = len(nums) - 1
    - Find if the nums is left sorted or right sorted. In the rotated sorted array, at least one of the side is sorted, it may happen that both the left and right side are sorted. (Left and Right sided are respective to middle element)
    - If the array is left sorted (nums[low] <= target), check if it target lies in the left portion
    - Else check if it lies in right portion.
    - Change the low and high pointer accordingly and calulate mid everytime.
    - If nums[mid] == target, return its index i.e mid
    """
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] ==  target:
                return mid
            #check if nums is left sorted
            elif nums[low] <= nums[mid]:
                if nums[low] <= target and nums[high] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                #nums is Right Sorted
                if nums[low] < target and nums[high] >= target:
                    low = mid+1
                else:
                    high = mid - 1
        return -1
        