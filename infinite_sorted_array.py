# time comlexity= O(log(n))
# space complexity = O(1)
def search(arr,key):
    l=0
    r=1
    # find search space
    while key > arr[r]:
        l=r+1
        r*=2

    # apply binary search
    while(l<=r):
        mid=l+((r-l)//2)
        if key == mid:
            return mid
        # left array check
        if arr[mid]>key:
            r=mid-1
        else:
            l=mid+1

    return -1

a=list(range(100000))

print(search(a,100))
