/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// We take two HashMaps and start traversing the strings character and strings and map the each character of one string with other string and do the same with in other map too, but the key and value interchange. Continue doing this util one of the give a different value than the it is present in its map. Then we return false, if there is no such case we return true.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Same concept as Method 1 but rather than taking two hashmaps we can use one hashmap and HashSet. So we add them if they are not present in both map and set, if present we check if the map value is same as the character/String of other string, if not return false. If map doesn't contain the value but the set does then return false. Return true at the end.

import java.util.HashMap;
import java.util.HashSet;

/**** Method 1 ****/
// public class _290_Word_Pattern {

//   public static void main(String[] args) {}

//   public boolean wordPattern(String pattern, String s) {
//     String arr[] = s.split(" ");
//     if (pattern.length() != arr.length) {
//       return false;
//     }
//     HashMap<Character, String> sMap = new HashMap<>();

//     HashMap<String, Character> tMap = new HashMap<>();

//     for (int i = 0; i < pattern.length(); i++) {
//       char sChar = pattern.charAt(i);
//       String tChar = arr[i];
//       if (!sMap.containsKey(sChar) && !tMap.containsKey(tChar)) {
//         sMap.put(sChar, tChar);
//         tMap.put(tChar, sChar);
//       } else {
//         if (sMap.containsKey(sChar)) {
//           if (!sMap.get(sChar).equals(tChar)) return false;
//         } else if (tMap.containsKey(tChar)) {
//           if (!tMap.get(tChar).equals(sChar)) return false;
//         }
//       }
//     }

//     return true;
//   }
// }

/**** Method 2 ****/
public class _290_Word_Pattern {

  public boolean wordPattern(String pattern, String s) {
    String arr[] = s.split(" ");
    if (pattern.length() != arr.length) {
      return false;
    }
    HashMap<Character, String> sMap = new HashMap<>();

    HashSet<String> tSet = new HashSet<>();

    for (int i = 0; i < pattern.length(); i++) {
      char sChar = pattern.charAt(i);
      String tChar = arr[i];
      if (!sMap.containsKey(sChar) && !tSet.contains(tChar)) {
        sMap.put(sChar, tChar);
        tSet.add(tChar);
      } else {
        if (sMap.containsKey(sChar)) {
          if (!sMap.get(sChar).equals(tChar)) return false;
        } else {
          if (tSet.contains(tChar)) return false;
        }
      }
    }

    return true;
  }
}
