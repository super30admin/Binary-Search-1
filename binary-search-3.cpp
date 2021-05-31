//I still can't see this problem, so I interpreted it as per written in CTCI, TC is log(n) SC is O(1)

int binarySearch(int arr[], int l, int r, int x)
{
    while(l<=r){
        int mid = l + (r - l)/2;
        if(arr[mid]== x){
            return mid;
        }
        else if(arr[mid]>x){
            r = mid-1;
        }
        else{
            l = mid+1;   
        }
    }
    return -1;
}
 

int findPos(int arr[], int key)
{
    int l = 0, h = 1;
    int val = arr[0];
 
    while (val < key)
    {
        l = h;        
        h = 2*h;      
        val = arr[h]; 
    }
 
    return binarySearch(arr, l, h, key);
}
 
