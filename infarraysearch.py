def interval_det(arr, lower_bound, upper_bound, target):
	if target<arr[upper_bound] and target>arr[lower_bound]:
		return binary_search(arr, lower_bound, upper_bound, target)
	else:
		return interval_det(arr, lower_bound+200, upper_bound+200, target)

def binary_search(arr, low, high, target):
	while low<=high:
		mid = (low+high)//2
		if arr[mid]==target:
			return mid
		elif arr[mid]>target:
			high = mid-1
		elif arr[mid]<target:
			low = mid+1
	return -1


array = [......]#infinite array
target = x
print(interval_det(array, 0, 200, target))

#timecomplexity = O(n) for interval and O(logn) for target search
#spacecomplexity = O(1)