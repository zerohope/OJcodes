package leetcode;

public class StringtoInteger8 {
    public int myAtoi(String s) {
        char[] st=s.toCharArray();
        int idx=0,n=st.length;
        boolean negetive=true;
        while(st[idx]==' '&&idx<n)
            idx++;
        if(idx==n)
            return 0;
        if(st[idx]=='+') {
            negetive = false;
            idx++;
        }
        else if(st[idx]=='-'){
            idx++;
        }else if(!Character.isDigit(st[idx])){
            return 0;
        }
        int res=0;
        while(Character.isDigit(st[idx])){
            int temp=st[idx]-'0';
            if(res<(Integer.MAX_VALUE-temp)/10) {
                res = res * 10 + temp;
                idx++;
            }
            else
                return negetive?-res:res;
        }
        return negetive?-res:res;
    }


}
