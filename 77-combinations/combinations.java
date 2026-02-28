class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        bt(1,n,k,arr,result);
        return result;
    }
    public static void bt(int start,int n,int k,List<Integer>arr,List<List<Integer>> result){
        if(arr.size()==k){
            result.add(new ArrayList<>(arr));
            return;
        }

        for(int i=start;i<=n;i++){
            arr.add(i);
            bt(i+1,n,k,arr,result);
            arr.remove(arr.size()-1);
        }
         
    }
}