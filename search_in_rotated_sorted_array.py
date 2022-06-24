# time compleixty: O(log n)-binary search
# space complexity: O(1)-constant space
# follow binary search basics: low = 0, high= last index
# Approach: check if u hit the target directly through mid, return mid if hit
# if not, there are two cases
# case-1: mid is in first part
# case-2 mid is in second part
#if we are in case-1,if target is greater than element at low and lesser than element at mid,
#this means our target is also in first part, hence high will be mid-1
# else low will be mid+1
# case-2 is reverse of case-1

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid  = low + ((high - low)//2) #avoids integer overflow
            print(mid)
            if nums[mid]==target:
                return mid
            else:
                #case-1, mid in first part
                if nums[low]<=nums[mid]:
                    if target>=nums[low] and target<nums[mid]:
                        high = mid-1
                    else:
                        low = mid+1
                #case-2, mid in second part
                else:
                    if target<=nums[high] and target>nums[mid]:
                        low = mid+1
                    else:
                        high = mid-1
        return -1
            
        