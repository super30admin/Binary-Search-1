""""
We first make low=0 and high =low+1 and starting doing a fast search on the stream till our
high surpasses the target, and we keep assigning new values to low and high till then like low=high
and high=high*2 so that high pointer moves fast and low pointer takes position of high pointer.
Whenever high > target we are sure that the target was less than the high value so perform the binary
search from low till high since we know our element will now lie somewhere in between. We finally end we
find the target.
Complexity TimeL O(logm)+O(logk)
Space Complexity- O(n)
:return: mid value finally having the target
"""
def search(arr, target):
    low=0
    high=1
    while(arr[high]<target):
        low=high
        high*=2

    while(low<=high):
        mid=(low+high)//2
        if arr[mid]==target:
            return mid
        elif arr[mid]> target:
            high=mid-1
        else:
            low=mid+1
    return -1

array = [-1, 0, 3, 5, 9, 12]
target = 3
print(search(array,target))