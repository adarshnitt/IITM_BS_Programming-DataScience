import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class stream1 {

    public static void main() {
        List<Integer> l1 = new ArrayList<>();
        l1.add(12);
        l1.add(121);
        l1.add(123);

        // array sorting
        int[] a1={1,3,2,55,7,22,0};
        Arrays.sort(a1);
        //System.out.println(a1);

        List<Integer> f1 = l1.stream().filter(i -> i > 0).map(i -> i * 12).collect(Collectors.toList());
        //System.out.println(f1);

        // stream practice
        long f2 = l1.stream().filter(i -> i > 0).map(i -> i + 0.1).collect(Collectors.toList()).size();
        long f3 = l1.stream().filter(i -> i > 0).map(i -> i + 0.1).count();

        // stream functions
        ArrayList<Integer> a3=new ArrayList<>();
        a3.add(2);
        a3.add(21);
        a3.add(23);
        a3.add(62);
        a3.add(29);
        a3.add(201);

 
        
        Integer[] xx={1,2,3,4,5};
        Stream<Integer> s1= Stream.of(xx);
        //System.out.println(xx+"   stram for this array");
        //s1.forEach(System.out::println);

        Stream<Double> s2=Stream.generate(Math::random).limit(10);
        //System.out.println(" random");
        //s2.forEach(System.out::println);

        Stream<Integer> s3=Stream.iterate(0,n->n+11).limit(5);
        //System.out.println(" iterate");
        //s3.forEach(System.out::println);
        
        Stream<Integer> s4= Stream.iterate(0,n->n<10,n->n+1);
        //System.out.println(" random");
        //s4.forEach(System.out::println);


        Stream<Integer> s5=a3.stream();
        //System.out.println(" random");
        //s5.forEach(System.out::println);

        Stream<Double> s6= Stream.generate(Math::random).dropWhile(n->n<0.5).limit(5);
        //System.out.println(" random");
        //s6.forEach(System.out::println);


        Stream<Double> s7= Stream.generate(Math::random).skip(90).limit(5);
        //System.out.println(" random");
        //s7.forEach(System.out::println);

        Stream<Double> s8= Stream.generate(Math::random).skip(90).takeWhile(x->x>0.1).limit(5);
        System.out.println(" random");
        s8.forEach(System.out::println);

        // Stream<Double> s9= Stream.generate(Math::random).findFirst();
        // System.out.println(" random");
        // s9.forEach(System.out::println);

        
    }

}
