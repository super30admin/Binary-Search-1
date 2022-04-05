#Search in a Rotated Sorted Array


# // Time Complexity :O(Log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def search( nums, target) -> int:
    if(nums==[]):
        return -1
    low=0
    high=len(nums)-1
    while(low<=high):
        mid = low+(high-low)//2
        value = nums[mid]
        if(target==value ):
            return mid
        elif(value>=nums[low]):                             #need to take care of 4 cases
            if(target<value and target>=nums[low]):         # first half is sorted and target is inside it
                high=mid-1
            else:                                              # first half is sorted but the target is not in this half
                low=mid+1
        else:
            if(target>value and target<=nums[high]):        #second half is sorted and the target is in it
                low=mid+1
            else:                                           #second half is sorted but the target is not in it
                high=mid-1
    return -1
            
#test
print(search([4,5,6,7,0,1,2],0))