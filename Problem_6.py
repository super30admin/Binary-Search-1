def binary_search(A,low, high, target,):

    if high > low:

        mid = (low + (right-1)) // 2

        if( A[mid]== target):
            return mid

        if A[mid] > target :
             return binary_search(A, low, mid-1, target)
        else:
            return binary_search(A, mid+1,high, target)

    return -1

def find_high(A, target):

    left=0
    right=1
    key=A[0]

    while key < target:

        left = right
        right = 2* right
        key = A[right]
    return binary_search(A, left, right, key)

'''
Time complexity= O(log n)
Space Complexity= O(1)
'''

"""

As the array length is infinite, the lower index = 0, we need to find the higher index in order to define the binary seach boundary.
Initially low = 0 and high is choosen as 1, until the target becomes greater than the element at the higher index is multiplied by 2.
Once the highter index is found, normal binary seach is carried. If element exists, index is returned or -1 is returned.

"""
