class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        last = nums[right]
        first = nums[left]
        rotated = 0
        while(left<=right):
            mid = (left+right)//2
            print(mid,left,right)
            # if nums[mid-1]<nums[mid]>nums[mid+1]:
            #     rotated = mid
            #     break
            if nums[mid]>last:
                rotated = mid
                left = mid+1
            else:
                right = mid-1
        print(rotated)
        if first<=target<=nums[rotated]:
            left = 0
            right = rotated
        else:
            left= rotated+1
            right = len(nums)-1
        while(left<=right):
            mid = (left+right)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] <target:
                left = mid+1
            else:
                right = mid-1
        return -1
#Time Complexity: O(log(n))