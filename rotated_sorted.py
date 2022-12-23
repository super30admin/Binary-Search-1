# Time Complexity :
# O(log N)

# Space Complexity :
# O(N) - we do not store any values

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) -1
        middle = int((low/2 + high/2))

        #Base case - if only 1 element, check if it's target
        if len(nums) == 1 :
            if target == nums[0]:
                return 0
            else :
                return -1

        middle_value = nums[middle]

        if target == middle_value:
            return middle

        #Checking if the array is left sorted or right sorted
        if nums[low] <= nums[middle]:
            #Does the target exist in the first half
            if target < middle_value and target >= nums[low]:
                return self.search(nums[low:middle],target)
            else :
                #Does the target exist in the second half
                search_value = self.search(nums[middle+1:high+1],target)
                if search_value == -1 :
                    return -1
                else :
                    return middle +1 + search_value
        else :
            #if the array is right sorted
            if target > middle_value and target <= nums[high]:
                #Does the target exist in the second half
                search_value = self.search(nums[middle+1:high+1],target)
                if search_value == -1 :
                    return -1
                else :
                    return middle + 1 + search_value
            else :
                #If the target lies in the left side
                return self.search(nums[low:middle],target)
