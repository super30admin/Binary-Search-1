#time complexity- o(log(n)) and space complexity - o(1)
class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        l=0
        h=1

        while reader.get(h)<=target:
            l=h
            h=2*h
        print(l)
        print(h)

        while l<=h:
            m=(l+h)//2

            if target==reader.get(m):
                return m
            elif target<reader.get(m):
                h=m-1
            else:
                l=m+1
        return -1