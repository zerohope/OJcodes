public class Atoi8 {
    public static void main(String[] args ){
        System.out.println(myAt("2147483648"));


    }
     static int myAtoi(String s) {
        while(s.charAt(0)==' ')
            s=s.substring(1);
        int rs=0;
        int flag=0;
        if(s.charAt(0)=='-'){
            rs=-1;
            flag=1;
        }
        if(s.charAt(0)=='+'){
            rs=1;
            flag=1;
        }
        if(flag==1)
            s=s.substring(1);
        for(int i=0;i<s.length();i++){
            char tc=s.charAt(i);
            if(tc>='0'&&tc<='9'){
                if((rs==-1||rs==1)&&i==0) {
                    rs = rs * (tc - '0');
                    continue;
                }
                if((rs==-1||rs==1||rs==0)&&tc=='0'){
                    rs=0;
                    continue;
                }
                if(rs>=0) {
                    if(rs>=Integer.MAX_VALUE/10)
                        return Integer.MAX_VALUE;
                    rs = rs * 10 + tc - '0';
                }else{
                    if(rs<=-Integer.MAX_VALUE/10)
                        return -Integer.MAX_VALUE;
                    rs = rs * 10 -(tc - '0');
                }
                }else {
                if(i==0)
                    return 0;
                break;
            }
        }
        return rs;
    }
    static int myAt(String s) {
        if(s.equals(""))
            return 0;
        while(s.charAt(0)==' '){
            s=s.substring(1);
            if(s.equals(""))
                return 0;
        }
        int rs=0;
        int flag=-1;
        if(s.charAt(0)=='-'){
            flag=1;
        }
        if(s.charAt(0)=='+'){
            flag=0;
        }
        if(flag>-1)
            s=s.substring(1);
        for(int i=0;i<s.length();i++){
            char tc=s.charAt(i);
            if(tc>='0'&&tc<='9'){
                if(rs>Integer.MAX_VALUE/10) {
                    rs = Integer.MAX_VALUE;
                    if(flag==1)
                        return -rs-1;
                    break;
                }
                if(rs*10>Integer.MAX_VALUE-(tc - '0')){
                    rs = Integer.MAX_VALUE;
                    if(flag==1)
                        return -rs-1;
                    break;
                }
                rs = rs * 10 + tc - '0';
            }else {
                if(i==0)
                    return 0;
                break;
            }
        }
        if(flag==1)
            rs=-rs;
        return rs;
    }
}
