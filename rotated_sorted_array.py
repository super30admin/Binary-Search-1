#time complexity: o(logn)
#space complexity: O(1)
#passed all cases on LeetCode: yes
#difficulty faced: deciding mid and then assigning row and column
# comments: in the code
#https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution:
    def search(self, nums: 'List[int]', target: int) -> int:
        
        low = 0
        high = len(nums) -1 
        
        while (low <= high):
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            #left part is sorted:
            if nums[low] <= nums[mid]:
                #the 1st equalto in next line is important because we havent checked that condition anywhere and we need to keep the window between these 2 points
                if target >= nums[low] and target < nums[mid]:
                    #if the target lies between these 2 numbers then we have to move the window to left because array on left is sorted and if number exists we can find it here
                    high = mid -1
                else:
                    #else the target is either less than lowest on left side or higher than highest so we need to move the window right
                    low = mid+1
                    
            #right part is sorted
            else:
                #this is opposite of above code so compare b/w mid and high
                if target> nums[mid] and target <= nums[high]:
                    low = mid+1
                else:
                    high = mid-1
        return -1