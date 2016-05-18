package sundry;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().addBinary("", ""));
	}
    public String addBinary(String a, String b) {
        if(a.length() <= 0)  return b;
        else if(b.length() <= 0)  return a;
        else if(a.length() <= 0 && b.length() <= 0)  return "0";
        
        char[] ret = null;
        if(a.length() > b.length()){
            ret = new char[a.length() + 1];
            ret = add(ret,a,b,1,'0');
        } else{
             ret = new char[b.length() + 1];
            ret = add(ret,b,a,1,'0');
        }
        String retString = new String(ret);
        if(retString.length() > 0){
            if(retString.charAt(0) == '1')  return retString;
            else  return retString.substring(1);
        } else{
            return null;
        }
    }
    
    private char[] add(char[] ret, String a, String b, int index, char addnext){
        if(b.length() - index < 0){
            return addSelf(ret,a,index,addnext);
        }
        if(a.charAt(a.length() - index) != b.charAt(b.length() - index)){
            //�����ڣ����Ϊ1
            if(addnext == '1'){
                ret[a.length() - index + 1] = '0';
                return add(ret,a,b,index + 1, '1');
            } else{
                ret[a.length() - index + 1] = '1';
                return add(ret,a,b,index + 1, '0');
            }
        } else{
            //���
            if(a.charAt(a.length() - index) == '0'){
                ret[a.length() - index + 1] = addnext;
                return add(ret,a,b,index + 1, '0');
            } else{
                ret[a.length() - index + 1] = addnext;
                return add(ret,a,b,index + 1, '1');
            }
        }
    }
    
    private char[] addSelf(char[] ret, String a, int index, char addnext){
        //a�Ѿ����꣬ͷ��Ҫ��λ
        if(a.length() - index < 0){
        	if(addnext == '1')  ret[0] = '1';
        	else  ret[0] = '0';
            return ret;
        } else{
            //δ����
            if(a.charAt(a.length() - index) != addnext){
            	//�����λ�ͱ�λ����ȣ���λΪ1����λΪ0
                ret[a.length() - index + 1] = '1';
                return addSelf(ret,a,index + 1, '0');
            } else if(addnext == '0'){
            	//�����λ�ͱ�λͬΪ0����λΪ0����λΪ0
            	ret[a.length() - index + 1] = '0';
            	return addSelf(ret,a,index + 1, '0');
            } else if(addnext == '1'){
            	//�����λ�ͱ�λͬΪ0����λΪ0����λΪ1
                ret[a.length() - index + 1] = '0';
                return addSelf(ret,a,index + 1, '1');
            } else{
                return null;
            }
        }
    }
}