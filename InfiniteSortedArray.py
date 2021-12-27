# // Time Complexity : O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach


class InfiniteArray:
    def __init__(self,reader,target):
        self.reader = reader
        self.target = target

    def search(self):
        low = 0 
        high = 1

        while (self.reader[high] < self.target):
            low = high 
            high = 2*high

        while(low<= high):
            mid = low + (high -low)//2
            if self.reader[mid] == self.target:
                return mid
            elif self.reader[mid] > self.target :
                high = mid -1
            else:
                low = mid +1

        return -1

reader = [-1,0,3,5,9,12]
target = 9

position = InfiniteArray(reader,target)
print(position.search())


