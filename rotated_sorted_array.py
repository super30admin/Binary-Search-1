class Solution:
    def search(self, nums, target,l,r) -> int:
        # method 1: recurrsive
        mid = int(l + (r - l) / 2)
        if nums[mid] == target:
            return mid
        if (l<=r):
            # right part is sorted
            if nums[mid] < nums[l]:
                if target > nums[mid] and target <= nums[r] :
                    return self.search(nums,target,mid+1,r)
                else:
                    return self.search(nums,target,l,mid-1)
            # left is sorted
            else:
                if target >= nums[l] and target < nums[mid]:
                    return self.search(nums,target,l,mid-1)
                else:
                    return self.search(nums,target,mid+1,r)
        else:
            return -1
        '''
        # method 2: iterative
        l=0
        r=len(nums)-1
        while (l<=r):
            mid = int(l + (r-l)/2)
            if nums[mid] == target:
                return mid
            # right part is sorted
            if nums[mid] < nums[l]:
                if target > nums[mid] and target <= nums[r] :
                    l= mid +1
                else:
                    r=mid -1
            # right is sorted
            else:
                if target >= nums[l] and target < nums[mid]:
                    r=mid -1
                else:
                    l=mid +1

        return -1
        '''


l=[3,4,5,1,2]
t=1
a=Solution()
print(a.search(l,t,0,len(l)-1))
