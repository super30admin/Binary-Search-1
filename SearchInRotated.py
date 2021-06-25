class Solution:
    def search(self, nums, target) :

        def rotate_index(left, right):
            if nums[left] < nums[right]:
                return 0
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > nums[mid + 1]:
                    return mid + 1
                else:
                    if nums[mid] < nums[left]:
                        right = mid - 1
                    else:
                        left = mid + 1

        def search(left, right):

            while left <= right:

                mid = (left + right) // 2
                if nums[mid] == target:
                    return mid
                else:
                    if target < nums[mid]:
                        right = mid - 1
                    else:
                        left = mid + 1
            return -1

        length = len(nums)

        if length == 1:
            if nums[0] == target:
                return 0
            else:
                return -1

        r_index = rotate_index(0, length - 1)

        if nums[r_index] == 0:
            return search(0, length - 1)
        if r_index == 0:
            return search(0, length - 1)
        if target < nums[0]:
            return search(r_index, length - 1)
        return search(0, r_index)
# s= Solution()
# nums = [7,8,9,10,0,1,2,3,4,5,6]
# s.search(nums,9)