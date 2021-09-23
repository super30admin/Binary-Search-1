class Solution:
    def search(self, nums, target: int) -> int:
        l=0
        h = len(nums)-1

        while(l<=h):
            mid = l + (h-l)//2
            if nums[mid] == target:
                return mid

            elif nums[l]<= nums[mid]:
                if target >= nums[l] and target < nums[mid]:
                    h = mid -1
                else:
                    l = mid +1
            else:
                if target <= nums[h] and target > nums[mid]:
                    l = mid +1
                else:
                    h = mid -1
        return -1

        

        