"""
    Given a sorted array of unknown length and a number to search for,
    return the index of the number in the array.
    Accessing an element out of bounds throws exception.
    If the number occurs multiple times, return the index of any occurrence.
    If it isn’t present, return -1.
"""


class Solution:

    def infinite_sorted_array(self, nums: list, target: int) -> int:
        """
        // Time Complexity :
                            O(logn) 'n' is the target value
        // Space Complexity :
                            O(1)
        // Did this code successfully run on Leetcode :
                            N/A
        // Any problem you faced while coding this :
                            Took time to do the nested exception trick
        // Your code here along with comments explaining your approach
            Since we do not know the end of the array, we start from the second index and
            multiply the end index by 2 to reach at a point when the current value is less than
            the target. Then we do a binary search from the start and end index.
            If we get an exception at any point we traverse the list in a linear fashion from the previous 'start'.
            If we encounter an exception for the second time the value does not exist.
        """
        try:
            start = 0
            end = 2
            while nums[end] < target:
                start = end
                end *= 2
            return self.binarySearch(nums, start, end, target)
        except IndexError:
            try:
                while True:
                    if nums[start] == target:
                        return start
                    start += 1
            except IndexError:
                return -1

    def binarySearch(self, nums: list, start: int, end: int, target: int) -> int:
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                end = mid - 1
            elif target > nums[mid]:
                start = mid + 1
        return -1


if __name__ == '__main__':
    h = Solution()
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 4))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 2))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 7))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 100))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 6))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 1))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], -11))
