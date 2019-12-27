def findPos(arr, target):
    #declare initial values as 0 and 1
    low=0
    high=1
    while (target >= arr[high]):
        low=high
      # Multiply high value with offset index(here 2)
        high=high*2
    #logic case
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
arr = [3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170] 
ans = findPos(arr,10) 
print("answer is : ", ans)