class Solution:
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    '''
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)

        l,r = 0, n-1

        while (l<r):
            mid = (l+r)//2
            if nums[mid] > nums[r]: # this means that target must exist on right
                l = mid + 1
            else: # otherwise, set right to mid
                r = mid
        pivot = l

        # now you can complete a regular binary search
        l, r=0, n-1
        while (l<=r):
            mid = (l+r)//2
            mid2 = (mid+pivot) % n
            if nums[mid2] == target:
                return mid2
            elif nums[mid2] < target: # if less, we need to move right
                l = mid + 1
            else:
                r = mid - 1
        return -1