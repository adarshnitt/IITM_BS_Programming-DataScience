import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.*;

public class iterator {
    public static void main(String[] args) {
        string_formating();
    }

    public static void string_formating() {
        // string formatting
        String q = "Adash";
        int w = 2;
        float e = 0.8f;
        double r = 10.8;
        boolean t = true;

        String s1 = String.format(
                "name is %s, e loat value  is %.3f , bool value is  %b , int vlaue is %d, decimal value is %.3f", q, e,
                t, w, r);
        System.out.println(s1);
    }

    public static void tranformer() {

        // list->array
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(22);
        int sz = l.size();

        int[] array = new int[sz];
        for (int i = 0; i < sz; i++) {
            array[i] = l.get(i);
        }

        // list to set
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        l2.add(234);

        Set<Integer> s1 = new HashSet<>(l2);
        for (int i : s1) {
            // System.out.println(s1+""+l2);
        }

        // Set to list
        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(23);
        s2.add(44);
        s2.add(1);
        s2.add(23);
        s2.add(44);

        List<Integer> l3 = new ArrayList<>(s2);
        for (int i : l3) {
            // System.out.println(i);
        }

        // set to array
        Set<Integer> s4 = new HashSet<>();
        s4.add(1);
        s4.add(23);
        s4.add(44);
        s4.add(1);
        s4.add(23);
        s4.add(44);

        int sz1 = s4.size();
        int[] l4 = new int[sz1];
        int count = 0;
        for (int i : s4) {
            l4[count] = i;
            count = count + 1;
        }

        // array to list
        int[] l5 = { 1, 2, 3, 4, 5 };
        int len = l5.length;

        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            l1.add(l5[i]);
        }

        // array to set
        int[] l6 = { 1, 2, 3, 4, 5 };
        int leng = l6.length;

        Set<Integer> s7 = new HashSet<>();
        for (int i = 0; i < len; i++) {
            s7.add(l5[i]);
        }
        System.out.println(s7);

    }

    public static void set() {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s2.add(33);
        s2.add(34);
        s1.add(342);
        s1.add(341);

        System.out.println(s1 + "   " + s2 + " ");
        System.out.println(s1.isEmpty() + " isemoty\n" +
                s1.contains(1) + " contains 1\n" +
                s1.contains(14) + " contains 14 \n" +
                s1.size() + " size");
        if (s1.remove(3)) {
            System.out.println("elem exist");
        } else {
            System.out.println("elem not exit");
        }

        // union and intersection with set
        s1.addAll(s2); // union : all elem of s1 and s2
        s1.removeAll(s2); //
        System.out.println(s1 + "   " + s2);
    }

    public static void iterator() {
        // list
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        // iterator ormation
        Iterator<Integer> i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public static void list() {
        // list
        List<Integer> l = new ArrayList<Integer>();
        l.clear();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        System.out.println(l + " list starting ---");
        l.remove(0);
        System.out.println(l + "  ---");
        // l.clear();
        System.out.println(l.get(0) + " elem0 index\n " +
                l.set(1, 9999) + " index 1: 9999\n " +
                l.indexOf(1) + " index of 1\n " +
                l.size() + " sizeOf\n " +
                l.lastIndexOf(9) + " last index of 9\n " +
                l.subList(0, 4) + " sublist 0-4 \n " +
                l.isEmpty() + " isempty\n " +
                l.contains(1) + " contain 1 elem\n " +
                "  all elem:" + l);
        for (int j : l) {
            // System.out.println(j+ " elem in l ");
        }
    }

    public static void array() {
        // array:method-1
        int[] a1 = { 1, 2, 3 };
        for (int i : a1) {
            System.out.println("i");
        }
        // array:method-2
        int[] a2 = new int[2];
        a2[1] = 1;
        a2[0] = 2;
        for (int i : a2) {
            System.out.println("simple array " + i + " ");
        }
    }

    public static void list_to_array() {
        // lis to array
        // int []: array bolte isse
        // List< integer> --- ArrayList<>: isko list bolte

        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(123);
        l1.get(0);
        l1.size();

        Integer[] array_list = l1.toArray(new Integer[l1.size()]);
        for (int k : array_list) {
            System.out.println(k + " list to array");
        }
    }
}
