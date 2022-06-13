class Solution:
    def search(self, nums: List[int], target: int) -> int:

        # find rotation index (k)
        n = len(nums)
        k = 0
        # below is O(n)
        for i in range(1, n):
            if nums[i - 1] > nums[i]:
                k = i

                # find left and right for binary search
        if k == 0:
            left = 0
            right = len(nums) - 1
        elif target < nums[0]:
            left = k
            right = len(nums) - 1
        else:
            left = 0
            right = k

        # single element nums
        if n == 1:
            return 0 if nums[0] == target else -1

        # binary search
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] == target:
                return mid
        return -1

    '''
    def find_rotate_index(left, right):
        if nums[left] < nums[right]:
            return 0

        while left <= right:
            pivot = (left + right) // 2
            if nums[pivot] > nums[pivot + 1]:
                return pivot + 1
            else:
                if nums[pivot] < nums[left]:
                    right = pivot - 1
                else:
                    left = pivot + 1

    def search(left, right):
        """
        Binary search
        """
        while left <= right:
            pivot = (left + right) // 2
            if nums[pivot] == target:
                return pivot
            else:
                if target < nums[pivot]:
                    right = pivot - 1
                else:
                    left = pivot + 1
        return -1

    n = len(nums)

    if n == 1:
        return 0 if nums[0] == target else -1

    rotate_index = find_rotate_index(0, n - 1)

    # if target is the smallest element
    if nums[rotate_index] == target:
        return rotate_index
    # if array is not rotated, search in the entire array
    if rotate_index == 0:
        return search(0, n - 1)
    if target < nums[0]:
        # search on the right side
        return search(rotate_index, n - 1)
    # search on the left side
    return search(0, rotate_index)
    '''

    '''
        1- take the middle and compare with target, if matches return.
        2- if middle is bigger than left side, it means left is sorted
        2a- if [left] < target < [middle] then do recursion with left, middle - 1 (right)
        2b- left side is sorted, but target not in here, search on right side middle + 1 (left), right
        3- if middle is less than left side, it means right is sorted
        3a- if [middle] < target < [right] then do recursion with middle + 1 (left), right
        3b- right side is sorted, but target not in here, search on left side left, middle -1 (right)
    '''

    '''
        start, end = 0, len(nums) -1
        while start <= end:
            mid = start + (end - start)//2  # or mid = (end + start)//2
            if target == nums[mid]:
                return mid
            elif nums[mid] >= nums[start]: # left is sorted
                if target < nums[mid] and target >= nums[start]:
                    end = mid - 1
                else:
                    start = mid + 1
            elif nums[mid] < nums[start]: # right is sorted
                if target <= nums[end] and target > nums[mid]:
                    start = mid + 1
                else:
                    end = mid -1 
        return -1
    '''

