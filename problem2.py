#time comp - O(logn) every time only searching in half of the part od the arr
#space comp- O(1) no extra space used
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l=0
        h=len(nums)-1
        while l<=h:
            mid=(l+h)//2
            #if target found
            if nums[mid]==target:
                return mid
            
            #if left arr sorted
            if nums[mid]>=nums[l]:
                #if target is in the left arr
                if nums[l]<=target<=nums[mid]:
                    h=mid-1
                else:
                    l=mid+1
            #if right arr sorted
            else:
                #if target is in the range
                if nums[mid]<=target<=nums[h]:
                    l=mid+1
                else:
                    h=mid-1
        return -1
    
    
