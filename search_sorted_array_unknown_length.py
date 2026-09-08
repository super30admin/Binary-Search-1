'''
    702 Search in Infinite sorted array
    https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

    Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds returns the max value of 32 bit int (2**31 -1). If the number occurs multiple times, return the index of any occurrence. If it isn't present, return -1.

    Time: O(2log(L)), Space: O(1)
    L = index of the target in the infinite array
'''
class ArrayReader:
    def __init__(self, arr):
        self._arr = arr
        # LeetCode's official out-of-bounds sentinel value (2^31 - 1)
        self.SENTINEL = 2**31 - 1

    def get(self, index: int) -> int:
        # If the index is within the actual array size, return the value.
        # Otherwise, return the sentinel value without throwing an exception.
        if 0 <= index < len(self._arr):
            return self._arr[index]
        return self.SENTINEL

def search_sorted_infinite(A, tgt):
    reader = ArrayReader(A)
    s, e = 0,1
    if tgt == reader.get(s):
        return s
    while (tgt > reader.get(e)):
        s = e
        e = 2*e

    # start binary search
    while (s <= e):
        mid = s + (e-s)//2
        mid_val = reader.get(mid)
        if mid_val == tgt:
            return mid
        if tgt < mid_val:
            e = mid - 1
        else:
            s = mid + 1

    return -1

def run_search_sorted_infinite():
    A = [0, 3, 5, 7, 9, 11, 15, 17]
    print(f"A = {A}")
    for tgt in [5, 15, 17, 19]:
        print(f"\nTarget = {tgt}")
        index = search_sorted_infinite(A, tgt)
        print(f"Found {tgt} at position = {index}") if index != -1 else print(f"Not found {tgt}")

run_search_sorted_infinite()