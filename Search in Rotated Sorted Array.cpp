class Solution {
public:
    int search(vector<int>& a, int target) {
     int n = a.size();
     int lo = 0, hi = n-1;

     while(lo<hi){
      int mid = lo + (hi-lo)/2;

      //if mid element is target
      if(a[mid]==target)  return mid;

      //if left side is sorted
      if(a[lo]<a[mid]){
        //check both upper and lower boundary
        if(a[lo] <= target && target <= a[mid])  hi = mid;
        else  lo = mid + 1;
      }
      else{ //else, right side is sorted
        //check both upper and lower boundary
        if(a[mid+1] <= target && target <= a[hi])  lo = mid + 1;
        else  hi = mid;
      }
     }

     return a[lo] == target ? lo : -1;
    }
};