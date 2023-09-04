public class methods {
    public static void main() {
        int a = 10;
        int[] arr1 = { 0, 9, 8, 7 };
        System.out.println("method class call" + "------------------------------------------------------");

        // int values canot change by another function but arr values can be
        // System.out.println(change1(a)+"int value cannot updated by another function
        // "+a+"---------");
        // System.out.println("arr1 value updated by another function
        // "+arr1[0]+"---------");

        // methods overloading
        // System.out.println(overload2(7,7)+" "+"overload2");
        // System.out.println(overload1(6)+" "+"overload1");

        // var argumrnts
        // System.out.println(varargs(1,2,3,4,5,6,7)+" var arguments...");

        // recursion
        System.out.println(recursion(5) + "   " + "recursion: factorial of 10");
    }

    static public int change1(int xx) {
        // method to update arguments
        xx = 100;
        return xx;
    }

    static public int[] change2(int[] xx) {
        // method to update arguments
        xx[0] = 100;
        return xx;
    }

    static public int add(int x, int y) {
        return x + y;
    }

    static int overload1(int x) {
        System.out.println("overload1");
        return x;
    }

    static int overload2(int x, int y) {
        System.out.println("overload2");
        return x + y;
    }

    static int varargs(int... args) {
        // use 3 dots for var argumrnts
        int sum = 0;
        for (int i : args) {
            sum = sum + i;
        }
        return sum;
    }

    public static int recursion(int x) {
        // find factorial o x
        if (x == 1) {
            return 1;
        } else {
            return x * recursion(x - 1);
        }
    }
}
