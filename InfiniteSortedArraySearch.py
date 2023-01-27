"""
Rasika Sasturkar
Time Complexity: O(max(logm,logn)) or O(logm+logn)
Space Complexity: O(1)
"""


def search(inf_array, target) -> int:
    """
    As it is an infinite array, we assign our low to 0 and high to 1.
    Until we know the range in which our target lies, we increase low and high.
    Once, we find the range we can implement binary search to find the target.
    It will return -1 if target is not found in the list.
    """
    low = 0
    high = 1
    while inf_array[high] < target:
        low = high
        high = 2 * high

    while low <= high:
        mid = low + (high - low) // 2
        if inf_array[mid] == target:
            return mid
        elif inf_array[mid] > target:
            high = mid - 1
        else:
            low = mid + 1
    return -1


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    secret1 = [-1, 0, 3, 5, 9, 12]
    target1 = 9
    print(search(secret1, target1))  # output = 4
    secret2 = [-1, 0, 3, 5, 9, 12]
    target2 = 2
    print(search(secret2, target2))  # output = -1


if __name__ == "__main__":
    main()

"""
The actual LeetCode submission: I had to change a bit in code above to make it work.
    def search(self, reader: 'ArrayReader', target: int) -> int:
        low = 0
        high = 1
        while reader.get(high) < target:
            low = high
            high = 2 * high
            
        while low<=high:
            mid = low + (high - low)//2
            if reader.get(mid) == target:
                return mid
            elif reader.get(mid) > target:
                high = mid-1
            else:
                low = mid+1
        return -1
"""
