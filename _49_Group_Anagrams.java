import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_Group_Anagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char charArr[] = s.toCharArray();
      Arrays.sort(charArr);
      String sortedStr = new String(charArr);

      map.putIfAbsent(sortedStr, new ArrayList<>());

      map.get(sortedStr).add(s);
    }

    return new ArrayList<>(map.values());
  }
}
