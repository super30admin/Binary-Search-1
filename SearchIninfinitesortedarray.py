#Time Complexity: O(N)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes


def SearchInArray(arrayreader, target):
    low = 0
    high = 1

    while(arrayreader[high] < target ):
        low = high
        high = 2 * high
    return BinarySearch(arrayreader,target,low,high)

def BinarySearch(arrayreader,target,low,high):


    while low <= high:

                mid = low + (high - low )//2

                if target == arrayreader[mid]:
                    return mid
                elif target > arrayreader[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
    return -1

print(SearchInArray([-1,0,3,5,9,12],9))
