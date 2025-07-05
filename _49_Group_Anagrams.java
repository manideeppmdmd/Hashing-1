/**** Method 1 ****/
//Time Complexity: O(n * k log k) where n is the number of strings and k is the maximum length of a string
//Space Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string

//Successfully submitted in LeetCode

// So, to group anagrams, we can sort each string and use the sorted string as a key in a hashmap. The value will be a list of strings that are anagrams of each other. We can then return the values of the hashmap as a list of lists.

/**** Method 2 ****/
//Time Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string
//Space Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string

//Successfully submitted in LeetCode

// Rather than sorting the each element, we can use a frequency array to count the occurrences of each character in the string. We can then use this frequency array with characters(a1b2c3) as a key in a hashmap. Using these we from a list of strings with anagrams and return list of map of values.

/**** Method 3 ****/
//Time Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string
//Space Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string

//Successfully submitted in LeetCode

// Instead of using a frequency array or sorting the string, we can use a prime number product to use as a key as product of prime numbers always gives a unique value. Convert these product into strings and use them as keys in HashMap. Using these we from a list of strings with anagrams and return list of map of values.

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**** Method 1 ****/
// public class _49_Group_Anagrams {

//   public List<List<String>> groupAnagrams(String[] strs) {
//     HashMap<String, List<String>> map = new HashMap<>();

//     for (String s : strs) {
//       char charArr[] = s.toCharArray();
//       Arrays.sort(charArr);
//       String sortedStr = new String(charArr);

//       map.putIfAbsent(sortedStr, new ArrayList<>());

//       map.get(sortedStr).add(s);
//     }

//     return new ArrayList<>(map.values());
//   }
// }

/**** Method 2 ****/
// public class _49_Group_Anagrams {

//   public List<List<String>> groupAnagrams(String[] strs) {

//     int chArr[] = new int[26];

//     Map<String, List<String>> map = new HashMap<>();

//     for (String s : strs) {
//       for (char c : s.toCharArray()) {
//         chArr[c - 'a']++;
//       }
//       StringBuilder stb = new StringBuilder();

//       for (int i = 0; i < chArr.length; i++) {
//         if (chArr[i] != 0) {
//           stb.append((char) (i + 97));
//           stb.append(chArr[i]);
//           chArr[i] = 0;
//         }
//       }

//       String str = stb.toString();
//       // System.out.println(str);
//       List<String> l;

//       if (map.containsKey(str)) {
//         l = map.get(str);
//       } else {
//         l = new ArrayList<>();
//       }

//       l.add(s);s
//       map.put(str, l);
//     }

//     return new ArrayList<>(map.values());
//   }
// }

/**** Method 3 ****/
class _49_Group_Anagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Double, List<String>> map = new HashMap<>();

    for (String str : strs) {
      double hash = getHash(str);

      if (!map.containsKey(hash)) {
        map.put(hash, new ArrayList<>());
      }

      map.get(hash).add(str);
    }

    return new ArrayList<>(map.values());
  }

  private double getHash(String str) {
    int[] primes = {
      2,
      3,
      5,
      7,
      11,
      13,
      17,
      19,
      23,
      29,
      31,
      37,
      41,
      43,
      47,
      53,
      59,
      61,
      67,
      71,
      73,
      79,
      83,
      89,
      97,
      101,
    };

    double hash = 1;

    for (char c : str.toCharArray()) {
      hash *= primes[c - 'a'];
    }

    return hash;
  }
}
