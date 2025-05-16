"""
Time Complexity -> O(log r) where r is the upper bound
Space Complexity -> O(1)
"""
class ArrayReader:
    def get(self, index, arr) -> int:
        return arr[index] if index < len(arr) else float('inf')


class SearchInfiniteSortedArray:
    def __init__(self):
        self.reader = ArrayReader()

    def binary_search(self, arr, target):
        r = 1
        while self.reader.get(r, arr) < target:
            r *= 2
        l = r // 2
        while l <= r:
            mid = l + (r - l) // 2
            val = self.reader.get(mid, arr)
            if val == target:
                return mid
            elif target < val:
                r = mid - 1
            else:
                l = mid + 1
        return -1


if __name__ == '__main__':
    obj = SearchInfiniteSortedArray()
    array = [-1, 0, 3, 5, 9, 12]
    tar = 9
    print(obj.binary_search(array, tar))
    tar = 10
    print(obj.binary_search(array, tar))
