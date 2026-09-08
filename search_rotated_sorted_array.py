'''
33 Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

Example 3:
    Input: nums = [1], target = 0
    Output: -1

Solution:
    1. Method 1 (sub-optimal): Find first index (fi) of the sorted array using binary search. Eg. If A = [4,5,6,7,0,1,2], then A[4] = 0 is the fi since
    it is the first element in the sorted array is [0,1,2,4,5,6,7]
    Then perform binary searche for the tgt element either: a) in the left half [0,..,fi-1] which is sorted or, b) in the right half [fi,...end] which is also sorted.
    Time: O(2logN), Space: O(1)

    2. Method 2 (optimal): Observe the following rotations of the sorted array
        [0,1,2,4,5,6,7]:
        R1 = [7,0,1,2,4,5,6] # mid = 2, [7,0,1,2] unsorted, [2,4,5,6] = sorted
        R2 = [6,7,0,1,2,4,5] # mid = 1, left = unsorted, right = sorted
        R3 = [5,6,7,0,1,2,4] # mid = 0, left = sorted, right = sorted
        R4 = [4,5,6,7,0,1,2] # mid = 7, left = sorted, right = sorted
        R5 = [2,4,5,6,7,0,1] # mid = 6, left = sorted, right = unsorted
        R6 = [1,2,4,5,6,7,0] # mid = 5, left = sorted, right = unsorted
        R7 = [0,1,2,4,5,6,7] # mid = 4, left = sorted, right = sorted
        Hence, in rotated sorted arrays, at least one half is sorted.
        Consider R3 and let A=R3, tgt=7.
        s=0, e=6, mid=3
        A[mid]=0
        check 1: tgt is at mid?
                 if A[mid] == tgt: # 0 == 7?
                    found tgt
        check 2: right sorted?
                 A[mid] < tgt <= A[e] # 0 < 7 <= 4?
                 yes: s = mid + 1 # go right into right sorted array
                 no:  e = mid - 1 # go left into left unsorted array
        check 3: left sorted?
                 A[s] <= tgt < A[mid] # 5 <= 7 < 0
                 yes: e = mid - 1 # go left into left sorted array
                 no:  s = mid + 1 # go right into right unsorted array

        Time: O(log N), Space: O(1)
        https://youtu.be/8hyOCScF1q0?t=3107
    '''
class Solution:
    def search(self, A, tgt) -> int:
        N = len(A)
        s, e = 0, N-1
        while s <= e:
            mid = s + (e - s)//2

            if A[mid] == tgt:
                return mid

            # left half sorted?
            if A[s] <= A[mid]:
                # is target also in left half?
                if A[s] <= tgt and tgt < A[mid]:
                    # left half is guaranteed to be sorted
                    e = mid - 1 # go towards left sorted array
                else:
                    s = mid + 1 # go towards right unsorted array
            else: # right half sorted?
                # is target also in right half?
                if A[mid] < tgt and tgt <= A[e]:
                    # right half is guaranteed to be sorted
                    s = mid + 1 # go towards right sorted array
                else:
                    e = mid - 1 # go towards left unsorted array
        return -1

A = [17, 28, 39, 0, 3, 5, 7, 9, 11, 15]
print(f"A = {A}")
soln = Solution()
for tgt in [0, 7, 15, 20, 39]:
        index = soln.search(A, tgt)
        print(f"Found {tgt} at position = {index}") if index != -1 else print(f"Not found {tgt}")
