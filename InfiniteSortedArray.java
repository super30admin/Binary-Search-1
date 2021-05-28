class Solution
{
	int mid;
 	public int search(ArrayReader reader , int target )
{
	int l=0;
	int h=1;
	while(reader.get(h)<target)
	{
	l=h;
	h=2*h;
}
	while(l<=h)
{
	mid=l+(h-l)/2;
	if(reader.get(mid)==target)
	{
return reader.get(mid);
			}else if(reader.get(mid)<target)
			{
				l=mid+1;
}else
{
	h=mid-1;
}
}
return -1;
}
}
