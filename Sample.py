// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
#SEARCH IN A ROTATED SORTED ARRAY
'''
1. I'll proceed with finding the index where the array is rotated
2. once i find that, I will apply bionery search on the first half or second half of rotated array depending on if target is greater than the nums[0] or not
'''
def findRotation(nums):
    
    start=0
    end=len(nums)-1
    
    if nums[start]<nums[end]:
        return 0

    while start<=end:
        mid= (end+start)//2
      
        if nums[mid]>nums[mid+1]:
            return mid+1
        else:
            if nums[mid]<nums[start]:
                end=mid-1
            else:
                start=mid+1

def search(nums, start, end, target):
    

    while(start<=end):
        mid=(end+start)//2
        if nums[mid]==target:
            return mid
        else:
            if nums[mid]>target:
                end=mid-1
            else:
                start=mid+1
    return -1



nums=[1,2,3,5,6,7,8,9]
rotation=findRotation(nums)
target=9
# print(rotation)
end=len(nums)-1
if target==nums[rotation]:
    print(rotation)
elif target>nums[rotation] and target<=nums[end]:
    print(search(nums, rotation,end,target))
elif target<nums[0]:
     print(search(nums, rotation,end,target))
else:
    print(search(nums, 0,rotation,target))

