# find element exists in the unlimted array
# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : do not have the subscription but running locally 
# // Any problem you faced while coding this : Missed the class but watched the video to understand solution
# // Your code here along with comments explaining your approach

# implementation of binary search as expalined
def binarySearch(arr, l, r, x):
	if r >= l:
		mid = l + (r - l) // 2
		if arr[mid] == x:
			return mid
		elif arr[mid] > x:
			return binarySearch(arr, l, mid-1, x)
		else:
			return binarySearch(arr, mid + 1, r, x)

	else:
		return -1

# using binary search here to apply to the array bounds found after taking two pointers
# they will low will be high and high will be multiplied to 2 to make window larger
# also taking the value of high to compare and apply binary search basically updateing value
def UnlimitedSerach(a, key):
    l, h, val = 0, 1, arr[0]
    # will break once value is greater than key
    # will go to binarty search to get the index
    while val < key:
        l = h
        h = 2*h
        val = arr[h]
    return binarySearch(a, l ,h, key)


# testing by taking a simple array
arr = [2, 3, 4, 10, 40]
x = 40

result = UnlimitedSerach(arr, x)

if result != -1:
	print(result)
else:
	print(-1)
