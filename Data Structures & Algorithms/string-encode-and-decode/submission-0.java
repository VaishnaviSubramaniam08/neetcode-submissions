class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
      List<String> result=new ArrayList<>();
      int i=0;
       while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

        
            j++;

            // Extract the string using length
            String word = str.substring(j, j + length);
            result.add(word);

            // Move pointer to next encoded part
            i = j + length;
        }

        return result;
    }
}
