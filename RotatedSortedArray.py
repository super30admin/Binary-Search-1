'''
Time complexity - O(log(N))
Space complexity  - O(1) in place search without extra space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes, the brute force was striaght forward , however, the binary search technique was tricky and getting the hang of inflection point took some time

Your code here along with comments explaining your approach
'''


class Solution:
    def search(self, nums: List[int], target: int) -> int:

        # linear approach - O(N) time complexity, find the peak of the array mountain-where the elements are decreasing
        '''
        idx = 0
        for i in range(1, len(nums)):
            if nums[i]  < nums[i-1]:
                idx = i
                break
        print(idx)
        if target >= nums[idx] and target in nums[idx:]:
            return nums.index(target)
        elif(target < nums[idx] and target in nums[:idx]):
             return nums.index(target)

        return -1
        '''


        # Approach 2 - Optimized solution
        if len(nums) == 0: return -1

        # binarysearch logn complexity

        # Binary search method
        lo = 0
        hi = len(nums) - 1
        while (lo <= hi):

            mid = lo + (hi - lo) // 2
            if nums[mid] == target:
                return mid
            # find the subarray which is monotonically increasing in nature,
            # this can be found by checking if the element at mid is greater the element at lo=> the inflection point is somewhere at the right, => the elements at the left are monotonially increassing, we can take this advantage to check if the target is present to the LHS of mid
            if nums[mid] >= nums[lo]:

                if nums[lo] <= target < nums[mid]:
                    # lies to left, so reduce the search space of high
                    hi = mid - 1
                else:
                    lo = mid + 1
            else:
                if nums[mid] < target <= nums[hi]:
                    # target is to the right inc lo
                    lo = mid + 1
                else:
                    hi = mid - 1

        return -1





