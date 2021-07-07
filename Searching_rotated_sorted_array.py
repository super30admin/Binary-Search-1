# running succesfully on leet code
# missed two edge cases and took time to arrive to the solution

# memory complexity: I think it is O(1), could you confirm?
# runtime complexity: O(logn) ----eliminates half elements in each recusion step performed

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # a recursive function which knows limits in which it should operate
        def helper(nums, target, l, h):
            #while valid indexes perform recursion
            if l <= h:
                # calculating mid point
                m = l + (h-l) // 2
                if nums[m] == target:
                    return m
                # left side is sorted
                if nums[m] > nums[l]:  
                    if target == nums[l]:
                        # return index as it is equal to target
                        return l
                    if target < nums[m] and target > nums[l]: 
                        # search left side
                        return helper(nums, target, l, m - 1)
                    else:
                        # search right side
                        return helper(nums, target, m+1, h) 
                else:
                    if target == nums[h]:
                        #return index
                        return h
                    if target < nums[h] and target > nums[m]:
                         # search right side
                        return helper(nums, target, m+1, h)
                    else:
                        # search left side
                        return helper(nums, target, l, m - 1) 
            #when invalid indexes implicates that number is not present. return -1
            else:
                return -1
        return helper(nums, target, 0, len(nums) - 1)
