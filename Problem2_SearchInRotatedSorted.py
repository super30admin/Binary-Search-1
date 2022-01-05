class Solution:
    def search(self, nums, target):
        if not nums:
            return -1
        
        l, h = 0, len(nums) - 1
        while(l<=h):
            mid = (l+h)//2
            if target == nums[mid]:
                return mid
            
            if nums[l]<=nums[mid]:
                if nums[l]<=target<=nums[mid]:
                    h = mid-1
                else:
                    l = mid+1
            else:
                if nums[mid]<=target<=nums[h]:
                    l = mid+1
                else:
                    h = mid-1


if __name__ == "__main__":
    a = [4,5,6,7,0,1,2]
    obj = Solution()
    print(obj.search(a, 0))

