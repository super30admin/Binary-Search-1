def search(ar, size):
    low = 0
    high = size - 1
    mid = 0
    while (high - low >=2):
        mid = (a + b) // 2
        if (ar[a] - a) != (ar[mid] - mid):
            b = mid - 1
        elif (ar[b] - b) != (ar[mid] - mid):
            a = mid - 1
        return ar[mid] + 1


# Driver Code
a = [1, 2, 3, 4, 5, 7, 8]
n = len(a)

print("Missing number:", search(a, n))
