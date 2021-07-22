#problem 3
#TimeComplexity : O(log n)
#solution accepted
# the way to solve this probelm is to keep the fact in mind that the target is always within the high and low of a binary search
#we move the left to the previous right bound while parsing the loop,# then perform the binary search,
class Solution:
    def search(self, reader, target):
        right = 1
        while(reader.get(right)<target):
            right = right <<1
        left = right >> 1
        while (left<=right):
            mid = (left+right)//2
            if (reader.get(mid)==target):
                return mid
            elif(target>reader.get(mid)):
                left = mid+1
            elif(target<reader.get(mid)):
                right = mid-1;
        return -1