import java.util.*;
import java.util.stream.Stream;

public class iitmPractice {
    public static void main() {
        week8 w = new week8();
        try {
            w.get();

            // System.out.println(" .");
        } catch (Exception e) {
            // to handle erro thrown by week7.p2 method
        }
    }
}

class Faculty {
    private String name;
    private double salary;

    public Faculty(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double bonus(float percent) {
        return (percent / 100.0) * salary;
    }

    // Define method getDetails()
    public String getDetails() {
        return this.name + ", " + this.salary;
    }

    // Override method getDetails(float percent)
    public String getDetails(float n) {
        double b = bonus(n);
        return this.name + ", " + this.salary + ", bonus = " + b;
    }
}

class Hod extends Faculty {
    private String personalAssistant;

    public Hod(String name, double salary, String pa) {
        super(name, salary);
        this.personalAssistant = pa;
    }

    // Override method bonus(float percent)
    public double bonus(float percent) {
        return super.bonus(percent) / 2;
    }

    // Override method getDetails()
    public String getDetails() {
        return super.getDetails() + ", " + this.personalAssistant;
    }

    // Override method getDetails(float percent)
    public String getDetails(float n) {
        double b = super.bonus(n) / 2;
        return super.getDetails() + ", " + this.personalAssistant + ", " + b;
    }

}

public class InheritanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Faculty obj1 = new Faculty(sc.next(), sc.nextDouble());
        Faculty obj2 = new Hod(sc.next(), sc.nextDouble(), sc.next());
        System.out.println(obj1.getDetails());
        System.out.println(obj1.getDetails(10));
        System.out.println(obj2.getDetails());
        System.out.println(obj2.getDetails(10));
    }
}

class c1 implements Cloneable {
    int x;

    public c1(int y) {
        this.x = y;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class stream2 {
    Date d;
    int id;
    String data;

    public stream2(int x, String y) {
        this.id = x;
        this.data = y;
    }

    public int getid() {
        return this.id;
    }

    public String getdata() {
        return this.data;
    }
}

class week8 {
    Map<Integer, String> m1 = new HashMap<>();
    ArrayList<stream2> a2 = new ArrayList<>();

    public week8() {
        m1.put(1, "30/12/2022");
        m1.put(2, "30/11/2022");
        m1.put(3, "30/10/2022");
        m1.put(4, "1/11/2022");
    }

    public boolean check1(stream2 x) {
        if (x.id > 0) {
            return true;
        }
        return false;
    }

    public void stream22() {

        for (int i : m1.keySet()) {
            stream2 s2 = new stream2(i, m1.get(i));
            a2.add(s2);
        }
    }

    public void stream23() {
        Stream<stream2> a22 = a2.stream().filter(x -> x.getid() > 2).filter(y -> check1(y));
    }

    public int change(String x) {
        return Integer.parseInt(x);
    }

    public void stream1() {
        Stream<Map<Integer, String>> m3 = m1.stream();
    }

    public public Map<Integer, String> get() {
        ArrayList<Integer> a = new ArrayList<>();
        Map<Integer, String> m2 = new HashMap<>();
        for (int i : m1.keySet()) {

            String[] x = m1.get(i).split("/");
            int diff = (30 - change(x[0])) + 30 * (12 - change(x[1])) + 360 * (2022 - change(x[2]));
            // System.out.println(diff);
            if (diff > 30) {
                a.add(i);
                m2.put(i, m1.get(i));
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
        return m2;
    }
}

class myException1 extends Exception {
    // constructor
    public myException1(String x) {
        super(x);
    }
}

class myException extends Exception {
    // constructor
    public myException(String x) {
        super(x);
    }
}

class exceptiontesting {
    public void e1() throws myException1 {
        try {
            throw new myException(" new exception");
        } catch (myException e) {
            // handling upper exception which raiseing
            System.out.println(";" + e.getMessage() + " []" + e);
            throw new myException1("asd");
        }
    }
}

class divby3exception extends Exception {
    public divby3exception(String msg) {
        super(msg);
    }
}

class week7 {
    public static double divby3() throws divby3exception {

        int n = 1;
        int b = 3;

        if (b == 3) {
            throw new divby3exception("no is div by not 3");
        } else {
            return n / 3;
        }

    }

    public static void g2() throws Exception {
        Scanner s = new Scanner(System.in);
        // String s1=s.nextLine();
        // String s3=s1.split(" ")[0];
        // int v3=Integer.parseInt(s1.split(" ")[1]);

        int[] i1 = new int[3];
        i1[1] = 2;
        i1[2] = 3;
        i1[0] = 4;
        for (int i : i1) {
            System.out.println(i);
        }
        int index = 3;
        if (index > i1.length) {
            throw new Exception();
        }
    }

    public static double g1() throws Exception {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        try {
            if (x == 3) {
                throw new Exception();
            }
            return 35 / x;
        } catch (Exception e) {
            System.out.println("divisible by 3 exception");
            throw new Exception();
        }

    }

    public void p2() throws Exception {
        String s = "abcd";
        int ind = 5;
        char c = 'z';
        char[] cc = s.toCharArray();
        String ss = new String(cc);

        System.out.println(ss + "  ." + cc.length);
        try {
            if (ind <= s.length()) {
                System.out.println(s);
                // s[s.length()-1]=String(c);
                s = s.substring(0, ind - 1) + c + s.substring(ind, s.length());
                System.out.println(s);
            } else {
                throw new ArrayIndexOutOfBoundsException();
                // it will raise error and try block will give error
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            s = s.substring(0, s.length() - 1) + c;
            System.out.println("ArrayIndexOutOfBound123" + "  " + s);
        }
    }
}

class week6 {
    public boolean prop(Double d) {
        if (d < 5) {
            return true;
        } else {
            return false;
        }
    }

    public void p1() {
        Scanner s = new Scanner(System.in);
        int n = 2;
        String k;
        Double d;
        Map<String, Double> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter k v pair");
            k = s.next();
            d = s.nextDouble();
            m.put(k, d);
        }

        ArrayList<String> kset = new ArrayList<>();
        for (String i : m.keySet()) {
            System.out.println(i + " ");
            if (prop(m.get(i))) {
                // m.remove(i);
                kset.add(i);
            }
        }
        for (String i : kset) {
            m.remove(i);
        }
        System.out.println(m);
    }

    public void p2() {
        // player and their name,score,wicket,matches
        // m1- nested
        // m2- generic

        // m2

        // m1
        Map<String, Map<String, Integer>> data = new HashMap<>();

        Map<String, Integer> m = new HashMap<>();
        m.put("Score", 12);
        m.put("match", 1);
        m.put("wicket", 2);

        data.put("Sachin", m);
        ArrayList<String> a1 = new ArrayList<>();
        // System.out.println(data.keySet());
        for (String i : data.keySet()) {
            System.out.println(data.get(i));
            double avgRun = data.get(i).get("Score") / data.get(i).get("match");
            if (avgRun > 10) {
                //
                a1.add(i);
            }
        }
    }
}

class player {
    String name;
    int score;
    int match;
    int wicket;

    public player(String n, int s, int w, int m) {
        this.name = n;
        this.score = s;
        this.match = m;
        this.wicket = w;
    }

    public void data() {
        ArrayList<player> d = new ArrayList<>();
        player p1 = new player("a", 1, 2, 3);
        d.add(p1);
        d.get(0);

    }
}

class week5 {
    public void q5() {
        // take array size and make array with user input elem
        Scanner s = new Scanner(System.in);
        System.out.println("enter array size");
        int arrsize = s.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < arrsize; i++) {
            System.out.println("enter array elem");
            int v = s.nextInt();
            l.add(v);
        }
        for (int i : l) {
            System.out.println("---" + i);
        }
    }
}