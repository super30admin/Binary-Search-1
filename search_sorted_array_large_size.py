# space complexity O(1)
# time comlexity O(logn)


def find_element( arr, target ):
    high = 1
    while high < len(arr):
        if arr[high] <= target:
            high = high*2
        else:
            break

    low = high//2
    high = min(low*2, len(arr)-1 )
    
    while( low <= high ):
        mid = (low + high) //2
        if arr[mid] == target:
            return True
        elif arr[mid] < target:
            low = mid + 1
        elif arr[mid] > target:
            high = mid - 1


    return False

a = [1.4,5,6,7,9,10,11,14,16,19,20,25,29]
print(find_element(a, 10))
print(find_element(a, 12))
print(find_element(a, 30))