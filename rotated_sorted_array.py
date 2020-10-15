#LC= 33


# You are given an integer array nums sorted in ascending order, and an integer target.

# Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

# If target is found in the array return its index, otherwise, return -1.


# Steps
# 1. Get the index of the smallest value in array - modified binary search
# 2. Treat this is as a normal binary search where start index is the index of the smallest item in array
# and the right is calculated on the basis of the left i.e smallest array



def solution(nums,target):
    if len(nums)==0 or nums==None:
        return -1

    l, r=0,len(nums)-1
    while l<r:
        mid=l+(r-l)//2
        if nums[mid]>nums[r]:
            # [0,1,2,4,5,6,7] -- original array 
            # [4,5,6,7,0,1,2] -- shifted array
            # mid=3 val at mid =7
            # we check if value of mid is greater value at rightmost index
            # in a sorted array the value at mid will always be less than (or equal to)value at righmost.
            # if this is not the case we can just narrow the search to the right have of the array
            l=mid+1
        else:
            r=mid
    # After breaking the while loop l will point to lowest value in array

    start=l
    l=0
    r=len(nums)-1


    if target>=nums[start] and target<=nums[r]:
        # first condition we check if target is greater than or equal to start of the array 
        # second condition we check if the target is less than the rightmost number in nums
        # if both are true  we can find the target in start to right or right half of array
        # if even one of them false the target is in first half of the array.
        l=start
    else:
        r=start
    

    # [4,5,6,7,0,1,2]  
    # l=4 ,nums[l]=0

    while l<=r:
        mid=l+(r-l)//2
        if nums[mid]==target:
            return mid
        elif nums[mid]<target:
            l=mid+1
        else:
            r=mid-1

    return -1


if __name__ == "__main__":

    input1=[4,5,6,7,0,1,2]

    input2=[4,5,6,7,0,1,2]


    val=solution(input2,0)

    print(val)
