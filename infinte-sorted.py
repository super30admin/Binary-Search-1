# Time Complexity is O(log n)

# Binary search
def searchBinary(a, left, right, key):
    if right >= left:
        middle = left + (right - left) // 2

        if a[middle] == key:                        # If middle pointer value is equal to key, return the value,
            return middle
        
        if a[middle] > key:
            return searchBinary(a, left, middle - 1, key)
        
        return searchBinary(a, middle + 1,  right, key)
    return -1                                       # If key is not found, return -1.
    

def searchInfinite(a, key):
    low, high, nums = 0, 1, a[0]                    # Initalize to start with 0, 1 indexes.
    while nums < key:                               # Check to verify if incremented index is less than the key to be found.
        low = high                                  # Updating low value to be the current high. In first case, 1.
        high = 2 * high                             # Double high value, In first case, 2. 
        nums = a[high]                              # Updating search array pointer to be from the high pointer for next loop.
    return searchBinary(a, low, high, key)