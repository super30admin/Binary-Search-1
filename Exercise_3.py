def search_sorted_infinite(A, tgt):
    '''
        702 Search in Infinite sorted array
        https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

        Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn't present, return -1.

        Time: O(2log(L)), Space: O(1)
        L = index of the infinite array at which target is present
    '''
    s = 0 # start pointer
    e = 1 # end pointer
    try:
        while A[e] < tgt: # O(log L)
            # old window length (W)
            W = e-s+1

            # new start (s') = old end + 1 = e + 1
            s = e + 1

            # new window len (W') = 2*(old window len) = 2W
            # e' - s' + 1 = 2(e - s + 1)
            # Solving this for e', we get e' = 2W + e
            e = (2*W)+e
    except IndexError as err:
        print(f"End position {e} has exceeded the length of array")
        print(f"Exception: {err}")

    index = binary_search_unknown_len(A, tgt, s, e) # O(log L)
    return index

def binary_search_unknown_len(A, tgt, s, e):
    '''
    Perform binary search if length is unknown
    '''
    if not A:
        return -1

    while s <= e:
        try:
            mid = s + (e-s)//2 # same as int((e+s)/2) but prevents overflow
            if A[mid] == tgt:
                return mid
            elif A[mid] > tgt:
                e = mid-1
            else: # A[mid] < tgt:
                s = mid+1
        except IndexError:
            e = mid-1
    return -1 # not found


def run_search_sorted_infinite():
    A = [0, 3, 5, 7, 9, 11, 15, 17]
    print(f"A = {A}")
    for tgt in [5, 15, 19]:
        print(f"\nTarget = {tgt}")
        index = search_sorted_infinite(A, tgt)
        print(f"Found {tgt} at position = {index}") if index != -1 else print(f"Not found {tgt}")

run_search_sorted_infinite()