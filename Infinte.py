// Time Complexity :o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Not available on leetcode
// Any problem you faced while coding this : No
class solution(object):
    def search(self,nums,l,r,target):
        l=0
        r=len(nums)-1
        while(l<=r):
            mid=(l+r)//2
            if(target==nums[mid]):
                return target
            elif(nums[mid]>target):
                r=mid-1
            else:
                l=mid+1
    def findpos(arr,key):
        l=0
        h=1
        val=nums[0]
        while(val<key):
            l=h
            r=2*h
            val=nums[h]
            
        return search(arr,l,h,key)
