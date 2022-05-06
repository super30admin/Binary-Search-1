#TimeComplexity: O(logN)
#SpaceComplexity: O(1) 
#It successfully runs on leetcode

def search(nums, target):
        if not nums: return -1
        l=0
        h=len(nums)-1
        while l<=h:
            m=l+(h-l)//2
            if nums[m]==target:
                return m

            if nums[l]<=nums[m]:
                if nums[l]<=target<nums[m]:
                    h=m-1
                else:
                    l=l+1
            else:
                if nums[h]>=target>nums[m]:
                    l=m+1
                else:
                    h=m-1
        return -1
          




print(search([4,5,6,7,0,1,2],0))