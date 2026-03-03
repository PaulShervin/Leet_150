class Solution {
    public int rob(int[] nums) {
        int no_of_ele=nums.length;
        if(no_of_ele==1)
        {
            return nums[0];
        }
        int[] dyn_prog=new int[no_of_ele];

        dyn_prog[0]=nums[0];
        dyn_prog[1]=Math.max(nums[1],nums[0]);

        for(int itr=2;itr<no_of_ele;itr++)
        {
            dyn_prog[itr]=Math.max(dyn_prog[itr-1],nums[itr]+dyn_prog[itr-2]);
        }
        return dyn_prog[no_of_ele-1];
    }
}