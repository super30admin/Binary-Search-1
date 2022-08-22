import java.lang.Math;
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
/* time complexity
O(logm+logn)
// m for searching the spaceand getting limits
Space Complexity
O(1)
*/
class Solution {
    public int search(ArrayReader reader, int target) {
    int i=0;
    int j=2;
        
    int x=(int)(Math.pow(2,31)-1.0);
    while(reader.get(j)!=x && reader.get(j)<=target)  {
        i=j;
        j=j*2;
    }  
    while(i<=j){
     int mid=i+(j-i)/2;
        if(reader.get(mid)==target){
            return mid;
        }
        else{
            if(reader.get(mid)>target){
                j=mid-1;
            }
            else if(reader.get(mid)<target){
                i=mid+1;
            }
        }
    }
        return -1;
    }
}