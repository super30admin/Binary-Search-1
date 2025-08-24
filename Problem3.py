# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader(object):
#    def get(self, index):
#        """
#        :type index: int
#        :rtype int
#        """

#what do we have 
# we have a get function toknow the secret value at the index, and if it is out of bound then it rturns 2^31-1
# so we should know the index to check if the seceret value is target or not, 
# optimal way to find the index is using binary search
# but for a binary search we need low, high, here is the tircky part since we don't knwon the size , how to determine the high
# one way is to take 10*4 as they have given constraints that secret.lentgh <= 10*4 but there is an optimal way 
# start with low at start of the arr, high also with start and iterate through the reader
# keep moving the low to the current high pointer and high twice of its current place 
# and once the arr[high] > target we found the range where out target could lie, and perform the bnary search fro the low, high at this place
# what could go wrong with this approach ?: so if the high when increased twice reaches the end of the bound, we don't get any error we get infinitie value
# and when doing binary search and the array which is greter then the target, is omitted so even in the edge cases the appaorch works. 


# // Time Complexity : O(logm + logn)
# // Space Complexity : no extra space used only low, high, mid variables O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Problem3(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """
        low = 0
        high = 1

        while(reader.get(high) < target): #timecomplexity  O(logm) where m is the index where the arr[index] > target
            low = high
            high = 2*high 

        return self.binarysearch(low,high,reader,target) # O(logn)
        

    def binarysearch(self, low,high,reader,target):
        while (low<=high):
            mid = low + ( high-low)/2

            if reader.get(mid) == target:
                return mid
            
            if reader.get(mid) >target: 
                high = mid -1
            else:
                low = mid+1
        
        return -1 # if the target is not found return -1
    

    # why increase the high with twice? increasign twice will balance the m and n steps, liek for example if i increase the high with 10 times or 100 times, the range to look has increased drastically, so the O(logm) is very high 
    # where as the O(logn) will be negliible, but in this way it is balanced. 

