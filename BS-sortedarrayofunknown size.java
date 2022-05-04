class Solution {
    public int searching(int arr[],int val)
    {
        int low=0,high=1,mid;
        while(arr[high]<val){
            low=high;
            high<<=1;
        }
        while(low<=high){
            mid=(low+high)/2;
            if(a[mid]==val){
                return mid;
            }
            if(a[mid]>val){
                high=mid-1;
            }
            else{
                 low=mid+1;
            }
        }
        return -1;
    } 
}