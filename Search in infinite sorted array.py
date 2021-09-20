def findindex(arr, target):
    low=0
    high=1
    while (target >= arr[high]):
        low=high
        high=high*2
    #Do binary search once target is greater
    while(low<=high):
        middle=low+((high-low)//2)
        if(target== arr[middle]):
            return middle
        elif (arr[middle])>target:
            high=middle-1
        else:
            low=middle+1
    return -1
