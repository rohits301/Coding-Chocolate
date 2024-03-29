import java.util.*;

public class Main {

    private static String generateKey(String str) {
        StringBuilder key = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            int diff = curr - prev; // implicit typecasting takes place

            if (diff < 0) {
                diff += 26; // to handle 'a' - 'y', in "yab"
            }

            key.append(diff + "#");
        }

        key.append("."); // to handle unit-length strings

        return key.toString();
    }

    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
        // write your code here

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = generateKey(str);

            if (map.containsKey(key)) {
                ArrayList<String> al = map.get(key);
                al.add(str);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(key, al);
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        // get AL from map and put into res
        // map.values() - returns Value Set of hm, similar to keySet()
        for (ArrayList<String> al : map.values()) {
            res.add(al);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
        for (ArrayList<String> lst : shiftedGroup) {
            Collections.sort(lst);
        }
        shiftedGroup.sort(new ListComparator());
        display(shiftedGroup);
    }

    // it is used to make the result unique
    static class ListComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> l1, List<String> l2) {
            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            String l1str = l1.get(0);
            String l2str = l2.get(0);
            return l1str.compareTo(l2str);

        }
    }

    public static void display(ArrayList<ArrayList<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> currList = list.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }

}
