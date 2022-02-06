#Time Complexity : O(log(n))
#Space Complexity : O(1)
#Runs on my machine
#Couldn't reduce the search space using the bruteforce, so had to refer to the Sai's solution

def binarySearch(nums,low,high,target):
    while low <= high:
        mid = low + (high-low)//2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            high = mid-1
        else:
            low = mid+1
    return -1

def searchSortedUnknown(nums,target):
    start = 0
    high = 1
    #check till we get the value which is less that target
    while nums[high]<target:
        start = high+1
        high = high*2
    #start = high//2 + 1
    return binarySearch(nums, start, high, target)

nums = [-1,0,3,5,9,12]
#appending extra values to check for the testcase
for i in range(5,10^4 +1):
    nums.append(10^4)
print(searchSortedUnknown(nums, 9))
print(searchSortedUnknown(nums, 0))
print(searchSortedUnknown(nums, 13))

