'''
## Problem 702: Search in sorted array of unknown size.

## Author: Neha Doiphode
## Date:   06-27-2022

## Description:
    This is an interactive problem.
    You have a sorted array of unique elements and an unknown size.
    You do not have an access to the array but you can use the ArrayReader interface to access it.
    You can call ArrayReader.get(i) that:
        - returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
        - returns 2^31 - 1 if the i is out of the boundary of the array.

    You are also given an integer target.
    Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

    You must write an algorithm with O(log n) runtime complexity.

## Examples:
    Example 1:
        Input: secret = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in secret and its index is 4.

    Example 2:
        Input: secret = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in secret so return -1.

## Constraints:
    1 <= secret.length <= 104
    -104 <= secret[i], target <= 104
    secret is sorted in a strictly increasing order.

## Time complexity:
    Please refer to function doc-strings.

## Space complexity:
    O(1), No auxiliary space is used.
'''

# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """

l = []
int_max = pow(2, 31) - 1
not_present = -1

def get_input():
    arr = '';
    print(f"Enter array elements with spaces: ", end = '')
    while True:
        arr = arr + input()
        if KeyboardInterrupt:
            break

    l = [int(x) for x in arr.split()]
    print(f"Enter the target: ", end = '')
    target = int(input())
    return l, target


class ArrayReader:
    def get(self, index: int) -> int:
        if l:
            try:
                return l[index]
            except IndexError:
                return int_max
            except:
                return int_max


class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        '''
        O(log n), since we are doubling the array at each iteration.
        '''
        answer = -1

        # Initialize low and high
        low = 0
        high = low + 1

        while low <= high:
            if reader.get(low) == int_max:
                break

            mid = low + (high - low) // 2
            element_at_mid = reader.get(mid)
            if target == element_at_mid:
                return mid
            elif mid != 0 and target < element_at_mid:
                high = mid - 1
            else:
                low = mid + 1
                high = high * 2

        return not_present

    def search_1(self, reader: 'ArrayReader', target: int) -> int:
        '''
        Time complexity is same as above.
        O(log n) - To decide the range of search, high is doubled in each iteration.
        O(log n) - To perform the actual binary search.
        Total = O(log n), asymptotic.
        '''
        answer = -1

        # Initialize low and high
        low = 0
        high = low + 1

        # Search the boundaries first and then do the binary search
        while reader.get(high) < target:
            low = high
            high <<= 1 # left shift is used to double the high value.

        while low <= high:
            if reader.get(low) == int_max:
                break

            mid = low + (high - low) // 2
            element_at_mid = reader.get(mid)
            if target == element_at_mid:
                return mid
            elif mid != 0 and target < element_at_mid:
                high = mid - 1
            else:
                low = mid + 1

        return not_present


# Driver code
l, target = get_input()
reader = ArrayReader()
solution = Solution()
#import pdb;pdb.set_trace()
print(f'Element is present at index {solution.search_1(reader, target)} of the array.(If -1, element is not present.)')
