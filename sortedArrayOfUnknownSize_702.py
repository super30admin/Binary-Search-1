#TimeComplexity: O(logN)
#SpaceComplexity: O(1)
#It successfully runs on leetcode


def search(self, reader: 'ArrayReader', target: int) -> int:
    low=0
    high=1
    while reader.get(high)<target:
        low=high
        high*=2
            
    while low<=high:
        mid=low+(high-low)//2
        if reader.get(mid)==target:
            return mid
        if reader.get(mid)<target:
            low=mid+1
        else:
            high=mid-1
    return -1
        