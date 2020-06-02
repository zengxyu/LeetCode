package medium;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * 注释: 判断两个字符串是否是anagram可以用Arrays.sort, 如果排序后的字符串相等， 那么这两个字符串是anagram
 *
 * 以下自己写的is_same方法太费时
 *
 */
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> strList = Arrays.asList(strs);
        //一个个判断, 如果有和之前相同的，就加到list中
        for (int i = 0; i < strList.size(); i++) {
            String s = strList.get(i);
            if (map.size() == 0) {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(s, temp);
            } else {
                //遍历map的keys，判断有没有和当前string相同的
                //如果有，加入当前key的value
                //如果没有，用当前string新建一个key并加入
                boolean find_same = false;
                //这个可以直接用map.keyset.contains来替代.
                for (String str : map.keySet()) {
                    if (is_same(str, s)) {
                        map.get(str).add(s);
                        find_same = true;
                        break;
                    }
                }
                if (!find_same) {
                    List<String> temp = new ArrayList<>();
                    temp.add(s);
                    map.put(s, temp);
                }
            }
        }
        List<List<String>> values =  new ArrayList<>(map.values());
        return values;
    }

    public boolean is_same(String a, String b) {
        /**
         * 判断两个字符串是否为anagram
         */
        if (a.length() != b.length()) {
            return false;
        }
        List<Character> aList = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            aList.add(a.charAt(i));
        }
        List<Character> bList = new ArrayList<>();
        for (int i = 0; i < b.length(); i++) {
            bList.add(b.charAt(i));
        }
        for (int i = aList.size()-1; i >= 0; i--) {
            int index = bList.indexOf(aList.get(i));
            if (index != -1) {
                aList.remove(i);
                bList.remove(index);
            }else {
                return false;
            }
        }
        if (aList.size() == 0 && bList.size() == 0) {
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {
        GroupAnagrams_49 groupAnagrams = new GroupAnagrams_49();
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        groupAnagrams.groupAnagrams(strs);
    }
}
