package util;

import java.util.*;

/***
 *@ClassName hw003
 *@Description
 * @author sukbear
 * @create 2019-09-11 20:15
 */
public class hw003 {
    static class Info implements Comparable {
        String id;
        String set;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSet() {
            return set;
        }

        public void setSet(String set) {
            this.set = set;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Info(String id, String set, String name) {
            this.id = id;
            this.set = set;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class Change {
        String fID;
        String fset;
        String tID;
        String tset;

        public Change(String fID, String fset, String tID, String tset) {
            this.fID = fID;
            this.fset = fset;
            this.tID = tID;
            this.tset = tset;
        }
    }

    static List<Info> list1 = new ArrayList<>();
    static List<Change> list2 = new ArrayList<>();
    static HashMap<String, String> map1 = new HashMap<>();
    static HashMap<String, String> map2 = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s1 = new String[n];
        for (int i = 0; i < n; i++) {
            s1[i] = sc.nextLine();
        }
        int m = Integer.parseInt(sc.nextLine());
        String[] s2 = new String[m];
        for (int i = 0; i < m; i++) {
            s2[i] = sc.nextLine();
        }

        for (String s : s1) {
            String[] tmp = s.split(",");
            list1.add(new Info(tmp[0], tmp[1], tmp[2]));
        }
        for (String s : s2) {
            String[] tmp = s.split(",");
            list2.add(new Change(tmp[0], tmp[1], tmp[2], tmp[3]));
        }
        for (Info info : list1) {
            map1.put(info.id + info.set, info.name);
        }
        for (Change c : list2) {
            String s = c.fID + c.fset;
            String t = c.tID + c.tset;
            if (map1.containsKey(s)) {
                map1.put(t, map1.get(s));
                map1.remove(s);
            }
        }
        Collections.sort(list1);
        for (Info info : list1) {
            print(info.id, info.set, map1.get(info.id + info.set));
        }
    }

    static void print(String s1, String s2, String s3) {
        System.out.print(s1);
        System.out.print(",");
        System.out.print(s2);
        System.out.print(",");
        System.out.print(s3);
        System.out.println();
    }
}
