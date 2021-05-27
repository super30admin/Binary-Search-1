# time compleity - O(log(N))
# space - O(1)
# checked for 4 conditions mentioned below.
# took time to understand and get to the proper concrete conditions, tried with various examples to reach to conclution.
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        Low, High = 0, len(nums) # finding low and high index
        while Low < High: # checking condition if all indexes are checked
            Mid = (Low+High) // 2 # calculating mid index
            if nums[0] > nums[Mid] and nums[0] <= target:
                '''
                this is for target exists in 
                left half after of mid value but is bigger than mid value)
                '''
                High = Mid
            elif nums[0] < nums[Mid] and nums[0] > target:
                '''
                this is for if the target is on the right half of mid value
                but is smaller than mid value.
                '''
                Low = Mid+1
            elif nums[Mid] < target:
                # check right subarray if the target is bigger than mid
                Low = Mid+1
            elif nums[Mid] > target:
                # check left subarray if the target is smaller than mid
                High = Mid
            else:
                # if the target is mid
                return Mid
        # target not found return -1
        return -1