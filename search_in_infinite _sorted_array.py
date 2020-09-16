# Time Complexity: O(2*log(t)), where t is the position of target. The number of steps to find h is O(log(t)) and for binary search is O(log(t))
# Space Complexity: O(1)
# This code was passsed on LC: I passed some of the test cases manually
# Problems: Was not able to solve it myself. Took reference from geeksforgeeks website. I should have been able to solve this myself.

def binary_search(arr,l,r):
    # it will do normal binary search for given 2 pointers in the infinite array
    while l<=r:
        mid = (l+r)//2
        if arr[mid]==target:
            return mid
        if target<arr[mid]:
            r = mid-1
        else:
            l = mid+1
    return -1


def search(array,target):
    # Initially start with 2 pointers as 0 and 1
    l = 0
    h = 1
    curr = array[0]

    while curr<target:
        # Make first pointer to second pointer and second pointer to the double of it.
        l = h
        h = 2*h
        # Check our curr element everytime. if it goes above our target value just break the loop, we get the range of array to search for.
        curr = array[h]

    return binary_search(array,l,h)



arr = [1,2,3,4,5,6,7,8,9,10]
target = 7
ans = search(arr,target)
if ans ==-1:
    print("Not Found")
else:
    print("Element is present at index {}".format(ans))