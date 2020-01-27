class Solution:
    def search(self, nums: list, target: int) -> int:
        """
            https://leetcode.com/problems/search-in-rotated-sorted-array/
            // Time Complexity: O(logn)
                We are cutting the problem size in to half each time recursively.
            // Space Complexity: O(1)
                We don't allocate extra space even when the input size grows.
            // Three line explanation of solution in plain english:
                - Start and end pointer
                - Start <= mid, left half sorted else right half is sorted
                - Adjust start and end pointer
        """
        if not nums:
            return -1
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            # the left half is 100% sorted if this condition is matches
            if nums[start] <= nums[mid]:
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            else:
                # we are 100% sure that the other half is sorted if we reach here
                # nums[mid] < nums[high]
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1

    def search_recursive(self, nums: list, target: int) -> int:
        """
            https://leetcode.com/problems/search-in-rotated-sorted-array/
            // Time Complexity: O(logn)
                We are cutting the problem size in to half each time recursively.
            // Space Complexity: O(1)
                We don't allocate extra space even when the input size grows.
        """
        """
            First we do a binary seach to find the pivot
            Loop breaks when start and end both are equal
            index at which both start and end are equal
            is the no of steps the array is rotated by
        """
        while start < end:
            mid = (start + end) // 2
            if nums[end] < nums[mid]:
                start = mid + 1
            else:
                end = mid
        """
            // Your code here along with comments explaining your approach
            The pivot we are at is the actual first element in the sorted array.
            We are sure about one thing at this point, if the element we want to search
            for is >= to the pivot element and <= to the last element in the list then
            for sure the element may be in this range. Since we know the elements around
            the pivot are already sorted we do a normal binary search in he sub arrays after
            comparing the target value with mid and end.
            For Eg:
            Index    0  1  2  3  4  5  6
                    [4, 5, 6, 7, 0, 1, 2]  Target: 5
                The pivot is at index 4. At this index the element we are looking for is
                greater than the pivot but less than the last element so the element can
                never be in this range.
                     0  1  2  3  4  5  6
                    [0, 1, 2, 3, 4, 5, 6] Target: 1
                The pivot is at index 0. The target is greater and the last element is less
                than so the element may be in this range.
            The logic works for both the cases.
        """
        if nums[start] <= target <= nums[len(nums) - 1]:
            return self._binary_search(nums, start, len(nums) - 1, target)
        return self._binary_search(nums, 0, start - 1, target)

    def _binary_search(self, nums: list, start: int, end: int, target: int) -> int:
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                end = mid - 1
            else:
                start = mid + 1
        return -1


if __name__ == '__main__':
    h = Solution()
    print(h.search([4, 5, 6, 7, 0, 1, 2], 4))
    print(h.search([4, 5, 6, 7, 0, 1, 2], 2))
    print(h.search([4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3], 3))
    print(h.search([3, 1], 1))
