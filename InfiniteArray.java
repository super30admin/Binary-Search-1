Time Compleity-log(h)
Space Complexity-O(1)

public int InfiniteSearch(int arr[],int key) 
	{ 
     int l = 0, h = 10; 
	    while (arr[h] < key) 
          { 
            l = h;	 
            h=h*2<arr.length?h*2:arr.length-1;
          } 	
		return binarySearch(arr, l, h, key);
	} 
  
 public int binarySearch(int arr[], int l, int r, int x)
    {
        if(r>=l)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x)
                return binarySearch(arr,l,mid-l,x);
            else if(arr[mid]<x)
                return binarySearch(arr,mid+l,r,x);
        }

            return -1;
    }
