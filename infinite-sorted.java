//TC:O(logn)
//SC:O(1)

//code
class Solution
{
public int Search(ArrayReader reader,int target)
{
int high=1;
int low=0;

while(reader.get(high)!=INTEGER.MAX_VALUE && reader.get(high)<=target)
{
  low=high;
  high=2*high;
 }
 return binarysearch(reader,target,low,high)
 }
 private int binarysearch(ArrayReader reader, int target, int low, int high)
 {
 while(low<=high)
 {
 int mid=low+(high-low)/2;
 if(reader.get(mid)==target)
 {
return mid;
}
else if (reader.get(mid)>target)
{
high=mid-1;
}
else
{
low=mid+1;
}
return -1
}
}
