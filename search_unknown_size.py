#time complexity: O(logn)
#space complexity: O(1)

def get_value(array, target):
    low=0
    high=1

    while array[high]<target:
        low=high
        high=2*high
        '''
        this if condition was only added for index out of bound.
        since ArrayReader API interface is not available here and 
        this is a leetcode premium question
        '''
        if(high>array.index(max(array))):
            high=array.index(max(array))


    while(low<=high):
        mid=(low+high)//2
        if array[mid]==target:
            return mid
        elif target<array[mid]:
            high=mid-1
        else:
            low=mid+1

    return -1

array=[-1,0,3,5,9,12]
index=get_value(array, 12)
print(index)