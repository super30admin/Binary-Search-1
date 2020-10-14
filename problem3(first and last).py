class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # using binary search algorithum
        index=[]
        count=0
        l=0
        r=len(nums)
        if r==0:
            return [-1,-1]
        while (l<=r):
            mid=int((r+l)/2)
            if nums[mid] and nums[mid]==target:
                if count!=2:
                    index.append(mid)
                    count +=1
            if target>=nums[mid]:
                l = mid+1
            else:
                r=mid-1
        print(index)
        if index==[]:
            return [-1,-1]
        else:
            return index
        
