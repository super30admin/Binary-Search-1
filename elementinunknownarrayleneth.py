#since we do not the lenght of the element, we cannot find the middle element
#so we take two pointers, slow and fast. WE keep traversing the elements until the nums[fast] 
#becomes greater the element 

#then we carry binary search between the elements from slow and fast pointer


def modifiedsearch(element,nums):
    slow=0
    fast=2
    while(nums[fast]<element):
        slow=fast
        fast=fast*2
    print(binarysearch(slow,fast,nums,element))


def binarysearch(low,high,nums,element):
    while(low<=high):
        mid=(low+high)//2
        if nums[mid]==element:
            #print(mid)
            return mid
        elif nums[mid]>element:
            high=mid-1
        else :
            low=mid+1
    return -1

modifiedsearch(9,[2,4,5,7,11,15,17,18,19,20,24])

