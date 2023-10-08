class Solution {
public:
    int search(vector<int>& a, int target) {
   if(a.size()==0 )return -1;
   int low = 0, high = a.size()-1;
   while(low<=high){
       int mid = low + (high-low)/2;
       if(a[mid]== target)return mid;
       else if(a[low]<= a[mid]){// if left is sorted
           if(a[low]<=target && a[mid]>target){
               high = mid-1;
           }
           else low = mid+1;
       }
       else{// if right is sorted
        if(a[mid] < target && a[high]>= target){
            low = mid+1;
        }
        else high = mid-1;
       }
   }
   return -1;
}
};



 // int n = a.size();
    // int low=0;
    // int high=n-1;
    // while(low<high){
    //     int mid= low+(high-low)/2;
    //     if(a[0]>target ^ a[0]>a[mid] ^ target > a[mid])low=mid+1;
    //     else high = mid;

    // }
    // return ((low==high && a[low]==target) ? low:-1);
