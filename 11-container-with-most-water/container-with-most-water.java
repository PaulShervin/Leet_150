class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int max=Integer.MIN_VALUE;
        while(left<right)
        {
            int width=right-left;
            int hei=Math.min(height[left],height[right]);
            int area=width*hei;
            max=Math.max(max,area);
            if(height[left]<height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}