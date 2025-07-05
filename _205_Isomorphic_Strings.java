/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// We take two HashMaps and start traversing the strings character by character and map the each character of one string with other and do the same with in other map too, but the key and value interchange. Continue doing this util one of the give a different value than the it is present in its map. Then we return false, if there is no such case we return true.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Same concept as Method 1 but rather than taking two hashmaps we can use one hashmap and HashSet. So we add them if they are not present in both map and set, if present we check if the map value is same as the character of other string, if not return false. If map doesn't contain the value but the set does then return false. Return true at the end.

import java.util.HashMap;
import java.util.HashSet;

/**** Method 1 ****/
// public class _205_Isomorphic_Strings {

//   public boolean isIsomorphic(String s, String t) {
//     if (s.length() != t.length()) {
//       return false;
//     }

//     HashMap<Character, Character> sMap = new HashMap<>();

//     HashMap<Character, Character> tMap = new HashMap<>();

//     for (int i = 0; i < s.length(); i++) {
//       if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
//         sMap.put(s.charAt(i), t.charAt(i));
//         tMap.put(t.charAt(i), s.charAt(i));
//       } else {
//         if (sMap.containsKey(s.charAt(i))) {
//           if (sMap.get(s.charAt(i)) != t.charAt(i)) return false;
//         } else if (tMap.containsKey(t.charAt(i))) {
//           if (tMap.get(t.charAt(i)) != s.charAt(i)) return false;
//         }
//       }
//     }

//     return true;
//   }
// }

/**** Method 2 ****/
public class _205_Isomorphic_Strings {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Character> sMap = new HashMap<>();

    HashSet<Character> tSet = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (!sMap.containsKey(sChar) && !tSet.contains(tChar)) {
        sMap.put(sChar, tChar);
        tSet.add(tChar);
      } else {
        if (sMap.containsKey(sChar)) {
          if (sMap.get(sChar) != tChar) return false;
        } else {
          if (tSet.contains(tChar)) return false;
        }
      }
    }

    return true;
  }
}
