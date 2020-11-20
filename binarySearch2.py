'''
Time Complexity : O(2logN)
Space Complexity : O (1) ;since storing only values in constants
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this :


# Your code here along with comments explaining your approach
Binary search approach:
- two binary search functions approach
- conditions:
-- first occurence > its left element or no more elements towards its left
-- last occurence < right most elemet or no more elements on the right


'''

class Solution:
    def firstSearch(self, nums, target) -> int:
        if len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low +(high - low)//2
            if nums[mid] == target:
                if low == mid or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid -1

            elif nums[mid] > target:
                high = mid -1
                
            else:
                low = mid + 1
            
        return -1
        

    def lastSearch(self,nums,target):
        if len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low +(high - low)//2
            if nums[mid] == target:
                if high == mid or nums[mid] <= nums[high]:
                    return mid
                else:
                    low = mid + 1

            elif nums[mid] > target:
                high = mid -1
                
            else:
                low = mid + 1
            
        return -1

if __name__ == "__main__":

    array = [5,7,8,9,9,10]
    s = Solution()

    if not array:
        print([-1,-1])


    print([s.firstSearch(array,2),s.lastSearch(array,2)])