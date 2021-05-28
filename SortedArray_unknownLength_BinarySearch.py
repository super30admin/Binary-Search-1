def binarySearch(array : list[int], target : int) -> int:
    p1, p2 = 0, 1
    l, r = getIndex(array, target, 0, p1, p2)
    while l<=r:
        mid = (l+r)//2
        if array[mid] == target:
            return mid
        elif array[mid] <= target:
            l= mid+1
        else:
            r = mid-1
    if l > r:
        return -1

def getIndex(array, target, start, p1, p2):
    try:
        while array[start+p2] is not None:
            if target >= array[start+p1] and target <= array[start+p2]:
                return start+p1, start+p2
            else:
                p1 = p2
                p2 = p2*2
    except:
        if p1==0:
            return -1, -2
        start = start+p1
        return getIndex(array, target, start, 0, 1)
    # return -1,-2
    

array = [1,3,5,6,7,11,13,14,15,18,22]
target = 13

print(binarySearch(array, target))

"""This implementation takes O(log(n)) complexity in the worst case 
to search for left and right indices in which the target element can be present and
binary search takes less than O(log(n)) time complexity in a sorted array of unknown length.
So the overall complexity will be O(log(n))"""

