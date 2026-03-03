class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
        {
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->   a[0]-b[0]);

        List<int[]> answer=new ArrayList<>();
        int[] present_val=intervals[0];
        answer.add(present_val);
        for(int itr=0;itr<intervals.length;itr++)
        {
            int[] next_val=intervals[itr];


            if(next_val[0]<=present_val[1])
            {
                present_val[1]=Math.max(present_val[1],next_val[1]);
            }
            else{
                present_val=next_val;
                answer.add(present_val);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}