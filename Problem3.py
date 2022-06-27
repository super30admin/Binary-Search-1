'''
Search in Infinite sorted array: 

https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Given a sorted array of unknown length and a number to search for, return the index of the number in the array. Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.

'''
'''
Time Complexity : O(Log N)
Space Complexity : O(1)
'''
def sol(reader, target):
    low = 0
    high = 1
    # Find high value by doubling it in each iteration untill array index out of bound which we get inf value
    while(reader.get(high)<target):
        low = high 
        high = high*2
    # Using the obtained High value solve this problem using binary search
    while(low<=high):
        mid = low + (high-low)//2
        if(reader.get(mid)==target):
            return mid
        elif(reader.get(mid) >target):
            high = mid-1
        else :
            low = mid + 1
    return -1