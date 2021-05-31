class solution
{
public public_call(ArrayReader reader, int target)
{
int low=0;
int high=1;
while(target> reader.get(high))
{
low=high;
high=2*high;
}
return bs(reader,target,low,high)
}
private bs(reader,target,low,high)
{
while(high>=low)
{
mid=low+(high-low)/2;
if (reader.get(mid)==target)	return mid;
else if(reader.get(mid>target)	high=mid-1;
else	low=mid+1;
}
return -1;
}

}