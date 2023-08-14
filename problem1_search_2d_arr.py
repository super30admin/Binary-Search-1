class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        result=[]
        i=0
        res=False
        def binarySearch (arr, l, r, x):
            # print(arr,l,r)
            if r >= l: 
                mid = l + (r - l) // 2
                # print(mid)
                if arr[mid] == x: 
                    return True 
                elif arr[mid] > x: 
                    return binarySearch(arr, l, mid-1, x) 
                else: 
                    return binarySearch(arr, mid + 1, r, x) 
            else: 
                return -1
        if len(matrix)==0:
            return False
        else:
            for array in matrix:
                if len(array)!=0:
                    each_output=binarySearch(array,0,len(array)-1,target)
                    # print(each_output)
                    # break;
                    result.append(each_output)
                else:
                    result.append(False)
            # print(result)
            for x in result:
                if x==True:
                    return True
            return False
                