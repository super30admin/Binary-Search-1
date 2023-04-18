#Time Complexity: O(log n)
#Space Complexity: O(1)

class ArrayReader:
    def get(self, index: int) -> int:
        array = [-1,0,3,5,9,12]
        return array[index]

class Solution:

    def search(self, reader: 'ArrayReader', target: int) -> int:
                low = 0
                high = 1
                while (reader.get(high) < target):
                    low = high
                    high = high * 2

                while low <= high:
                    mid = low + (high - low) // 2

                    if(reader.get(mid) == target):
                        return mid

                    elif (reader.get(mid) < target):
                        low = mid + 1
                    
                    else:
                        high = mid - 1

                return -1