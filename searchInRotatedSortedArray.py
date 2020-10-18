'''
In this problem, firstly it checks whether there is a point existing in the array where the order is not maintained.
In such case, at the deviation point, it divides the given array into two sorted arrays. Now Binary search which has
worst case complexity as O(logn) is used to find the element in both the sorted arrays and return its index.

In case of a scenario, where the order is maintained(either ASC or DESC), the code outside the for loop will run,
thereby directly applying Binary search.

Time Complexity : I am at this point of time not sure exactly what is the time and space complexity. I was used a brute force 
method since I couldn't come up with an optimal solution.
Space Complexity :
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : It is not an efficient algorithm. Right now, I think I could have 
created a separate function for Binary search which could have eliminated the code redundancy. 
'''

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 1:
            if target == nums[0]:
                return 0
            else:
                return -1

        for i in range(len(nums) - 1):

            if nums[i] > nums[i + 1]:

                l1 = 0
                h1 = i
                while l1 <= h1:
                    mid = (l1 + h1) // 2
                    print(mid)
                    if nums[mid] == target:
                        return mid
                    elif target < nums[mid]:
                        h1 = mid - 1
                    else:
                        l1 = mid + 1

                l2 = i + 1
                h2 = len(nums) - 1
                while l2 <= h2:
                    mid = (l2 + h2) // 2
                    if nums[mid] == target:
                        return mid
                    elif target < nums[mid]:
                        h2 = mid - 1
                    else:
                        l2 = mid + 1
                break

        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                h = mid - 1
            else:
                l = mid + 1
        return -1
