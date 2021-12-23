class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        def binarySearch(target, row):
            left, right = 0, len(row)-1
            while left <= right:
                mid = (left + right)//2
                if row[mid] == target: return mid
                elif row[mid] < target: left = mid + 1
                else: right = mid - 1
            return -1

        p1, p2, temp = 0, 1, -1
        size = len(nums)
        while p2 <= size-1:
            if nums[p1] > nums[p2]:
                temp = p2
                break
            p1 = p2
            p2 += 1
        
        if temp == -1:
            return binarySearch(target, nums)
        else:
            xx = binarySearch(target, nums[:temp])
            yy = binarySearch(target, nums[temp:])
            if xx != -1:
                return xx
            elif yy != -1:
                return temp+yy
            else:
                return -1