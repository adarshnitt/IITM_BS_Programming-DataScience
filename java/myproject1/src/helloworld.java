/*  step to run in java
 fist make a folder "helloworld" and make a claas "helloworld.helloworld" 
 then make function like "helloworld.helloworld.input0"
 on main file , here app.java: import helloworld.helloworld // package.class

 if function is static 
    class.function
 if not function is not static
    class_name var = new class_name()
    class_name.function()
*/



import java.io.Console;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class helloworld {

    public void printfunc() {
        // string is immutable cant be changed
        System.out.print("hiii ");
        // println : add new line after text
        // print: dont add new line
        System.out.println("hiii ");
        System.out.print("hiii ");
        // printf for print formating..(format, arguments)
        System.out.printf("x", "y", "z");
    }

    public void comparison() {
        int a = 10;
        int b = 11;
        String s = "asdasd";

        // bodmas is not applied in java use {bodmas+left2right} which comes first , cal
        // first.
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a > b && a < b);
        System.out.println((a > b) || (a < b));

        int x = 12;
        System.out.println((x++) + " first print 12 then increment to ++ " + x);
        System.out.println((++x) + " first increment 12 then print to ++ " + x);
    }

    public void input0() {
        Scanner inp0 = new Scanner(System.in);
        System.out.println(" enter your string,...");
        // scanner.next: text first arg as str\\ "{aasss} nkjn hjghh"
        // String x = inp0.next();
        // scanner.nextLine: take whoe line as input \\"{aaassss nlkhjn hjkl}"
        // String xx = inp0.nextLine();
        inp0.close();
        // System.out.println("your input was ..." + x);

        String strt = "Adarsh kumar";
        System.out.println("your input was ..." + strt);
        System.out.println("your input was ..." + strt.toLowerCase());
        System.out.println("your input was ..." + strt.length());

        System.out.println("trim ..." + strt.trim());
        System.out.println("len ..." + strt.length());
        System.out.println("substring ..." + strt.substring(1, 5));
        System.out.println("replace a with b ..." + strt.replace("a", "z"));
        System.out.println("starts with a ..." + strt.startsWith("a"));
        System.out.println("index of ars ..." + strt.indexOf("Ars"));

        System.out.println(" a equals b ..." + "a".equalsIgnoreCase("a"));
        System.out.println(" a equals b ..." + "a".equals("A"));
    }

    public void input_funtion1() {
        Scanner inp = new Scanner(System.in);
        int x2 = inp.nextInt(); //
        String x22 = inp.next();
        String x222 = inp.nextLine();
        System.out.println(x2 + " input var");
        inp.close();
    }

    public void input_console()
    {
        Console c=System.console();
        String username= c.readLine("username:");
        char[] pass=c.readPassword("pass");

        System.out.println(username + " input var:"+pass);

    }

    public void basic_operation() {
        int x = Integer.parseInt("230");
        byte b = 2;
        char y = 'c';
        String s = "adarsh";

        // use f for flaot; l for list; d for double {double have more var than float}
        long lng = 23333333333333L;
        short srt = 23;
        float flt = 2.3f;
        double dbl = 2.33333333d;
        boolean a = true;

        // use "datatype var =(datatype)value#" need output in desire form
        int x12 = (int) 12; // need output as int dtype
        String x13 = (String) "asdf"; // need output as String dtype

        System.out.println(dbl + " double var " + x);
        System.out.println(flt + " float var");
        System.out.println(lng + " long var");
        System.out.println(s + " value of string" + s.toCharArray());
        System.out.println(x + " value of int");
        System.out.println(y + " value of char");
        System.out.println(s.charAt(0));
        System.out.println(s.equals(s));
    }

    public void listfunc() {
        // The indexes of elements in a Java array always start with 0

        int[] arr2 = { 1, 2, 3, 4 };
        for (int i : arr2) {
            if (i == 4) {
                System.out.println("elem arr ");
            }
        }

        int[][] arr3 = new int[2][2];
        arr3[0][0] = 1234;

        int[] array = new int[10];
        int j = 0;
        while (j < 10) {
            array[j] = j;
            j = j + 1;
        }
        System.out.println(array + "fff");

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(0, 234);
        list1.add(1, 2034);
        System.out.println(list1 + "list elem");

        Set<Integer> s11 = new HashSet<>();
        s11.add(1);
        s11.add(19);
        System.out.println(s11 + "set elem");

        Dictionary<String, String> d1 = new Hashtable<>();
        d1.put("key_1", "val1");
        System.out.println(d1 + "dict elem");

        HashMap<String, Integer> h1 = new HashMap<>();
        h1.put("asd", 2);
        h1.put("sdf", 2343);
        System.out.println(h1 + "hash elem");

    }

    public void nestedList() {
        {
            // 1
            Map<String, Integer> m1 = new HashMap<String, Integer>();
            m1.put("k1", 1);
            System.out.println(m1);
            // 2
            Map<Integer, ArrayList<Integer>> m2 = new HashMap<Integer, ArrayList<Integer>>();
            m2.put(1, new ArrayList<Integer>());
            m2.get(1).add(11);
            m2.get(1).add(111);
            System.out.println(m2);
            // 3
            Map<Integer, Integer> m3 = new HashMap<Integer, Integer>();
            m3.put(2, 3);
            System.out.println(m3);
            // 4
            Map<Integer, HashSet<Integer>> m4 = new HashMap<Integer, HashSet<Integer>>();
            m4.put(1, new HashSet<Integer>());
            m4.get(1).add(23);
            m4.get(1).add(23);
            System.out.println(m4);

        }
        ;
    }

    public void sum() {
        int sm = 2 + 3;
        System.out.println(sm + " value of sum:2,3");
    }

    public void ifloop() {
        int var1 = 12;
        if (var1 < 10) {
            System.out.println("10<");
        } else if (var1 < 12) {
            System.out.println("12=");
        } else {
            System.out.println("12>");
        }

    }

    public void whileloop() {
        int var2 = 0;
        while (var2 < 10) {
            System.out.println(var2);
            var2 = var2 + 1;
            if (var2 == 5) {
                break;
            }
        }
    }

    public void dowhileloop() {
        int var2 = 0;
        do {
            var2 = var2 + 1;
            if (var2 == 5) {
                System.out.println(var2);
                continue;

            }
        } while (var2 < 10);
    }

    public void forloop() {
        int var3 = 1;
        for (int x = 0; x < 10; x++) {
            System.out.println(x);
        }
        for (int x = 0; x > -10; x--) {
            System.out.println(x);
        }

        int [] data={8,9,6,8,9};
        for(int i:data)
        {
            System.out.println(i);
        }

    }

    public void primeno() {
        // for 10 prime no
        int[] x = new int[20];
        boolean check = true;
        int start = 0;
        int count = 0;
        while (check) {
            if (start > 1) {
                boolean found = false;
                for (int i = 2; i < start / 2 + 1; i++) {
                    if (start % i == 0) {
                        found = true;
                    }
                }
                if (found == false) {
                    x[count] = start;
                    count = count + 1;
                    if (count > 19) {
                        break;
                    }

                }
            }
            start = start + 1;

        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }

    public void practice() {
        int[] x = new int[9];
    }

}
