class Solution:
    def search(self, reader, target):
        if(reader.get(0)==target):
            return 0
        left=0
        right=1
        while(reader.get(right)<target):
            left=right
            right*=2
        while(left<=right):
            mid=left+((right-left)>>1)
            pivot=reader.get(mid)
            if target==pivot:
                return mid
            if target<pivot:
                right=mid-1
            else:
                left=mid+1
        return -1