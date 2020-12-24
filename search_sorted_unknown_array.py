# Approach: Since we dont have the size of array, choose first two indices as left, right and check if it could be a potential boundary
# If not shift left and right indices until we find a valid boundary
# Time Complexity : O(log T)
# Space Complexity: O(1)
# Successfully ran on leetcode


def search(self, reader, target):
    """
    :type reader: ArrayReader
    :type target: int
    :rtype: int
    """

    leftIdx = 0
    rightIdx = 1

    while reader.get(rightIdx) < target:
        
        # if value at right itself is smaller than target, target can not be within these left-right limits, since the array is sorted
        # here, shift the 2 limits, left -- right and right by the next position
        
        leftIdx = rightIdx
        rightIdx = rightIdx * 2

    # by this stage when while loop becomes in valid, the left and right indixes are updated and the target lies within this boundary
    # Now apply binary search


    while leftIdx <= rightIdx:

        middleIdx = (leftIdx + rightIdx) // 2
        middle = reader.get(middleIdx)

        if target == middle:
            return middleIdx

        elif target < middle:
            rightIdx = middleIdx - 1

        else:
            leftIdx = middleIdx + 1

    return -1

