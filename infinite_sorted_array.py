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
        // Your code here along with comments explaining the approach
            We don't need to check for nums[start] > target because the start
            is adjusted each time. The element to be searched for is for sure
            greater than start because if it was lesser or equal the while loop
            would have exited
            - Find the range using start and end pointer
            - Binary search in the range
        """
        start = 0
        end = 2
        # break when end is greater or equal to target
        # else search for the range
        # if we have nums[end] <= target we don't have any
        # problem its just the number of elements search for is more
        while nums[end] < target:
            # until we reach end number is lesser we keep increasing the range
            start = end
            end *= 2
        return self._binary_search(nums, start, end, target)

    def _binary_search(self, nums: list, low: int, high: int, target: int) -> int:
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


if __name__ == '__main__':
    h = Solution()
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 4))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], 2))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12], 7))
    print(h.infinite_sorted_array([0, 1, 2, 4, 5, 6, 7], -100))
