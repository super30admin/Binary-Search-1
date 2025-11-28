# Given a sorted array of unknown length and a number to search for,
# return the index of the number in the array. Accessing an element out of bounds throws exception.
# If the number occurs multiple times, return the index of any occurrence. If it isn’t present, return -1.


#Did not run this solution but tried a dry run
#Assuming helper is the function which tells whether we are out of bounds or not
def helper(arr, index):
    try:
        return arr[index]
    except:
        return float('inf')


def searchIndex(arr,target):
    left=0
    right=1
    #Finding the search space based on the value of helper function
    # We are updating the right boundary until we find a value greater than target
    # Once we get a greater value or out of bounds we will stop
    while helper(arr,right)<target:
        left=right
        right=right*2

    while left<=right:
        mid = left + (right-left)//2
        val=helper(arr,mid)
        if val==target:
            return mid
        elif val>target:
            right=mid-1 
        else:
            left=mid+1
    return -1