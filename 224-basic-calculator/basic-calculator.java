class Solution {
    int i=0;
    public int calculate(String s) {
        return calc(s);
    }
    public int calc(String s){
        int num=0;
        int sign=1;
        int res=0;
        while(i<s.length()){
            char ch=s.charAt(i++);
            if(ch>='0' && ch<='9'){
                num=num*10+ch-'0';
            }
            else if(ch=='('){
                num=calc(s);
            }
            else if(ch==')'){
                res+=sign*num;
                return res;
            }
            else if((ch=='+')||(ch=='-')){
                res+=sign*num;
                num=0;
                sign=(ch=='-')?-1:1;
            }

        }
        res+=sign*num;
        return res;
    }
}