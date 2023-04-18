def rotatedArray(array, target):

    low, high = 0, len(array) - 1

    while (low <= high):
        mid = high-low // 2

        if (array[mid] == target):
            return True

        if (array[low] <= array[mid]):
            if (array[low] <= target and array[mid] >= target):
                high = mid - 1
            else:
                low = mid + 1

        else:
            if (array[high] >= target and array[mid] <= target):
                low = mid + 1
            else:
                high = mid - 1

    return False


inputArr = [1,3,5,7,9,8,4,16,18]
target = 9
res = rotatedArray(inputArr, target) 
print(res)