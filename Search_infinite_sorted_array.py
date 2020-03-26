# working properly
# runtime-- O(logn)  memory--

#binary search 
def binary_search (arr, l, r, x): 
    if r >= l: 
        mid = int(l + (r - l)/2)
        if arr[mid] == x: 
            return mid 
        elif arr[mid] > x: 
            return binary_search(arr, l, mid-1, x) 
        elif arr[mid]<x:
            return binary_search(arr, mid + 1, r, x) 
    return -1

'''
main idea

To start two pointers first and second from first and second index of list

Checking if target value is present between 2^n indexes. Which means checking for array values at 0 th, 2 nd, 4 th, 8 th so on 
positions.

If value at any position is greater than target [lets say 2^4 = 16 th position].
Retain the index value and do binary search between 2^(4-1) and 2^(4) to return index.

I have saved the last value in a variable and returned both from helper function

'''
def helper(nums,target,first,second):
    a = [None]*2
    a[0] = second
    try:
        while(nums[second]<=target):
            first = second
            second = second*2
            a[0] = a[1]
            a[1] = second
        print("check between",a[0],"and ",a[1],"indexes")
        return a
    except:
        print("check between index",a[0]," and last index")
        return a[0]

#calls helper functin and performs binary search

def infinite(nums,target):
    a = helper(nums,target, 0, 1)
    try:
        print(binary_search(nums,target,a[0],a[1]))
    except TypeError:
        high = nums.index(nums[-1])
        print(binary_search(nums,target,a,high))
    pass

#creating a big array
nums = []
for i in range(1000):
    if i%13==0:
        nums.append(i)
print(nums)        
import random
a = 0
while(a<5):
    i = random.choice(nums)
    print("results for",i)
    infinite(nums,i)
    print()
    a+=1
    
    
'''
[0, 13, 26, 39, 52, 65, 78, 91, 104, 117, 130, 143, 156, 169, 182, 195, 208, 221, 234, 247, 260, 273, 286, 299, 312, 325, 338,
351, 364, 377, 390, 403, 416, 429, 442, 455, 468, 481, 494, 507, 520, 533, 546, 559, 572, 585, 598, 611, 624, 637, 650, 663, 
676, 689, 702, 715, 728, 741, 754, 767, 780, 793, 806, 819, 832, 845, 858, 871, 884, 897, 910, 923, 936, 949, 962, 975, 988]

results for 143
check between 8 and  16 indexes
11

results for 897
check between index 64  and last index
69

results for 611
check between 32 and  64 indexes
47

results for 156
check between 8 and  16 indexes
12

results for 650
check between 32 and  64 indexes
50
'''
