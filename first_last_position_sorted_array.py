# The logic bhind solving this problem is binary search modification. As taught in class, I need to do 2 binary searches to find lftmost and right most index.
# The way it works is, suppose I want to find left most target index, then I do a binary search and move right pointer to mid-1 if arr[mid-1] >= arr[mid].
# There is also an edge case here, supoose I traverse to left, and go to 0th index then I do not ned to compare I will return the index.
# On the right subarray, while performing binary search I move high to mid + 1 and keep traversing until mid element is less than next element
# Time complexity - O(log (n))
# Space Complexity - O(n)

def binarySearchLeft(arr,target):
    low = 0
    high = len(arr)-1
    while (low <= high):
        mid = int((low+high)/2)
        if (arr[mid]==target):
            if (mid == low or arr[mid]>arr[mid-1]):
                return mid
            else:
                high  = mid - 1
        elif (arr[mid] > target):
            high = mid - 1
        else:
            low = mid + 1
    return -1

            
def binarySearchRight(arr,target):
    low = 0
    high = len(arr)-1
    while (low <= high):
        mid = int((low+high)/2)
        if (arr[mid]==target):
            if (mid == high or arr[mid]<arr[mid+1]):
                return mid
            else:
                high  = mid + 1
        elif (arr[mid] > target):
            high = mid - 1
        else:
            low = mid + 1
    return -1

def searchArray(arr,target):
    if (arr is None or len(arr)==0):
        return [-1,-1]
    leftIndex = binarySearchLeft(arr,target)
    rightIndex = binarySearchRight(arr,target)
    arr1 = list()
    arr1.append(leftIndex)
    arr1.append(rightIndex)
    print(arr1)
    return arr1
    
    

arr = [5,7,7,8,8,10]
target = 8
idx = searchArray(arr,target)
print("List of Indices:",idx)