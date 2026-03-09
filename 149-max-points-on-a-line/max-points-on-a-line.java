class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<=2)
        {
            return points.length;
        }
        int max=0;
        for(int i=0;i<points.length;i++)
        {
            Map<String,Integer> map=new HashMap<>();
            int duplicate=1;
            int curr_max=0;
            for(int j=i+1;j<points.length;j++)
            {
                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                if(dx==0 && dy==0)
                {
                    duplicate++;
                    continue;
                }
                int gc=gcd(dx,dy);
                dx/=gc;
                dy/=gc;
                if(dx<0)
                {
                    dx=-dx;
                    dy=-dy;
                }
                if(dx==0)
                {
                    dy=1;
                }
                if(dy==0)
                {
                    dx=1;
                }
                String slopeKey=dx+" / "+dy;
                map.put(slopeKey,map.getOrDefault(slopeKey,0)+1);
                curr_max=Math.max(curr_max,map.get(slopeKey));
            }
            max=Math.max(max,curr_max+duplicate);
        }
        return max;
    }
    public int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
}