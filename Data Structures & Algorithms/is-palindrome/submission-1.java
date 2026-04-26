class Solution {
    public boolean isPalindrome(String s) {
        String str=s.toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(char c:str.toCharArray()){
            if(c>='a'&&c<='z'||c>='0' && c<='9'){
                 sb.append(c);
            }
        }
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        else{
            return false;
        }
    }
}
