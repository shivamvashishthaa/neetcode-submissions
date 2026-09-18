class Solution {

    public String encode(List<String> strs) {
         if (strs.isEmpty())
      return "";
    StringBuilder sb = new StringBuilder();
    for (String s : strs)
      sb.append(s.length() + ",");

    sb.append("#");

    for (String string : strs)
      sb.append(string);

    return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty() || str.isBlank())
      return new ArrayList<>();

    List<Integer> sizes = new ArrayList<>();
    List<String> strs = new ArrayList<>();

    int i = 0;
    while (str.charAt(i) != '#') {
      StringBuilder sb = new StringBuilder();
      while (str.charAt(i) != ',') {
        sb.append(str.charAt(i));
        i++;
      }
      sizes.add(Integer.parseInt(sb.toString()));
      i++;
    }
    i++;

    for (Integer size : sizes) {
      strs.add(str.substring(i, size + i));
      i += size;
    }

    return strs;
    }
}
