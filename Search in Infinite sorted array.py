def Binary_Search(L, low, high, target):
    if low <= high:
        mid = low + (high - low) // 2
        if list[mid] == target:
            return mid

        if list[mid] > target:
            return Binary_Search(L, low, mid - 1, target)

        return Binary_Search(L, mid + 1, high, target)
    return -1


def position(list, target):
    low, high, val = 0, 1, list[0]

    while val < target:
        low = high
        high = 2 * high
        val = list[high]

    return Binary_Search(list, low, high, target)


list = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]

print(position(list, 9))
