class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        bt(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    public void bt(int[] candidates,int target, int start,List<Integer> current,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            current.add(candidates[i]);
            bt(candidates,target-candidates[i],i,current,result);
            current.remove(current.size()-1);
        }
    }
}