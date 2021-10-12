"""
Time Complexity: O(log n)
Space Complexity: o(1)
"""


def findMissingElement(arr):
    low = 0
    high = len(arr)-1
    if arr == []:
        print(-1)
    while(low <= high):
        mid = (low + high) // 2
        if arr[mid] == mid+1:
            low = mid+1
        elif arr[mid] != mid+1:
            high = mid - 1

    print(low+1)


findMissingElement([])
