"""
Leetcode (premium) - https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/submissions/ [submitted]
TC- O(logN) - since binary search is used, SC- O(1)
Challenge - writing conditions inside while loop

This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

    returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
    returns 231 - 1 if the i is out of the boundary of the array.

You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.

Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.



Constraints:

    1 <= secret.length <= 104
    -104 <= secret[i], target <= 104
    secret is sorted in a strictly increasing order.


"""

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation

'''
Idea - binary search. The window for binary search will start as of l,h=0,1 and move l=h+1 and h = 2h. 
Index out of bond situation will be handled because the value of out of bond will be very high for the target to be in
that active window.
Then apply binary search once you have the low and high of the bit with value in it
'''


class Solution:
    def search(self, reader, target):
        if reader.get(0) == target:
            return 0
        low, high = 0, 1
        while reader.get(high) != 2 ** 31 - 1 and target > reader.get(high):
            low = high + 1
            high = high * 2
        while low <= high:
            mid = low + (high - low) // 2
            # target found
            if reader.get(mid) == target:
                return mid
            # target greater than window
            elif target > reader.get(mid):
                low = mid + 1
            # target in window - run binary search, high and low will cross each other if target < low (edge case)
            else:
                high = mid - 1
        return -1


# driver code
class Reader:
    def __init__(self, arr):
        self.arr = arr

    def get(self, key):
        if key >= len(arr):
            return 2 ** 31 - 1
        else:
            return self.arr[key]


arr = [-1, 0, 3, 5, 9, 12]
target = 9
reader = Reader(arr)
search = Solution().search(reader, target)
print('target on index ', search)
