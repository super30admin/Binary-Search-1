class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        while low <=high:
            mid = low +(high - low)//2
            if (target == nums[mid]):
                return mid
            elif (nums [mid] >= nums[low]): #left sorted array
                if target>= nums[low] and target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            else: #Right sorted array
                if target<= nums[high] and target > nums[mid]:
                    low = mid +1 
                else:
                    high = mid -1
        return -1
                    
                
        
'''
Passed all test cases on Leetcode
Time Complexity : O(logn)
Space Complexity : O(1)

'''
