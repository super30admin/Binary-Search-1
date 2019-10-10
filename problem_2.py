# Time Complexity : O(log N)
# Space Complexity : O(1)
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# Since its an infinite sorted array I try to find the upper bound 
# for the binary search. And then call binary search on just those index

def binary_search(arr, left, right, x):
    if right >= left:
        mid = left + (right - left) // 2

        if arr[mid] == x:
            return mid

        if arr[mid] > x:
            return binary_search(arr, left, mid - 1, x)
        else:
            return binary_search(arr, mid + 1, right, x)

    return -1


def findPos(a, value):
    l, h, val = 0, 1, arr[0]

    while val < value:
        l = h
        h = 2 * h
        val = arr[h]

    return binary_search(a, l, h, value)


if __name__== "__main__":
    arr = [3, 9, 17, 29, 40, 59, 71, 98, 121, 133, 145]
    ans = findPos(arr, 98)
    if ans == -1:
        print("Element not found")
    else:
        print("Element found at index", ans)

    arr = [3, 9, 17, 29, 40, 59, 71, 98, 121, 133, 145]
    ans = findPos(arr, 100)
    if ans == -1:
        print("Element not found")
    else:
        print("Element found at index", ans)
