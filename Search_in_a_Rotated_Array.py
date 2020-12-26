# Created by Aashish Adhikari at 6:08 PM 12/23/2020

'''Recursive solution'''

class Solution(object):

    left = 0
    right = None

    def search(self, nums, target):

        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if self.right == None:
            self.right = len(nums) - 1

        #Edge case
        if len(nums) == 0:
            return -1
        #Edge case kind of
        if self.right-self.left <= 2:
            for i in range(self.right- self.left + 1):
                if nums[self.left + i] == target:
                    return self.left + i
            return -1

        while self.right >= self.left:  # needed to return -1 when item not found

            #correct way of getting mid
            mid = int(self.left + ((self.right - self.left) / 2))



            if nums[mid] == target:
                return mid
            if nums[self.left] == target:
                return self.left
            if nums[self.right] == target:
                return self.right

            if nums[mid] > target:

                if nums[self.left] > target:

                    if nums[self.left] < nums[mid]:

                        self.left = mid
                        return self.search(nums, target)
                    else:
                        self.right = mid
                        return self.search(nums, target)
                else:

                    self.right = mid
                    return self.search(nums,target)


            else:
                if nums[self.right] < target:

                    if nums[mid] < nums[self.right]:
                        self.right = mid
                        return self.search(nums, target)

                    else:
                        self.left = mid
                        return self.search(nums, target)
                else:

                    self.left = mid
                    return self.search(nums,target)

        return -1
