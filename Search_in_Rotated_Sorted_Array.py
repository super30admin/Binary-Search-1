# binary search in rotating array
# TIME COMPLEXITY: O(logN)
# SPACE COMPLEXITY: O(1)
# Yes, it passed all test cases in the leetcode
# Any problems faced? I was able to code after I learned how to solve it.
# Unfortunately, couldn't figure out how to solve first time.

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i = 0
        j = len(nums)-1
        
        # kind of tricky, and it is easy after you understand 
        
        while i <= j:
            k = (i+j)//2
            if target == nums[k]:
                return k
            elif nums[i] <= nums[k]:
                # array is left sorted
                # then figure out if target lies b/w i and k
                if nums[i] <= target and target < nums[k]:
                    j = k -1
                else:
                    i = k+1
            else:
                # array is right sorted
                if nums[j] >= target and target > nums[k]:
                    i =k+1
                else:
                    j = k-1
        return -1
