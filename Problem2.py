'''
Time Complexity : O(Log N)
Space Complexity : O(1)
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        # checking if left part of subarray is sorted if yes search if element lies in that 
        # if not check do the same thing for right part
        # if left part is not sorted do same as above for right part
        while(low<= high):
            mid = (high+low)//2
            if(nums[mid] == target):
                return mid
            elif(nums[low]<=nums[mid]):
                if(target>= nums[low] and target < nums[mid]):
                    high = mid-1
                else :
                    low = mid + 1
            else :
                if(target>nums[mid] and target <=nums[high]):
                    low = mid + 1
                else :
                    high = mid -1
        return -1
                
