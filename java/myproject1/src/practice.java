import java.util.*;


class Main {
  public static  void main1(String args[]) {
    String x="1.0";
    double d=Double.parseDouble(x);

    int x1=1;
    Double d1=Double.parseDouble(Integer.toString(x1));


    double d2=1.0;
    int d22=(int)d2;
    double d33=(int)d22;
    System.out.println(d33);

    
  }
}

class practice {
  public static void main(String[] args) {
    
    // reverse a string
    String s1= "tested";
    System.out.println("original string : "+s1);
    String s2="";

    for (int i=0;i<s1.length();i++)
      {
        // System.out.println(s1.charAt(i));
        s2=s2+s1.charAt(s1.length()-i-1);
      }

    //System.out.println(s2);

    //count no of unique char in string
    Set<String> c2=new HashSet<>();
    for (int i=0;i<s1.length()-1;i++)
      {
        // System.out.println(s1.charAt(i));
        String s11=s1.substring(i,i+1);
        c2.add(s11);
      }
    for(String i : c2)
    {
      //System.out.println(i);
    }

    // check vowel in string
    Set<String> s22=new HashSet<String>();
    s22.add("a");
    s22.add("e");
    s22.add("i");
    s22.add("o");
    s22.add("u");

    Dictionary<String, Integer> d=new Hashtable<>();

    for( String s:s22)
    {
      d.put(s, 0);
      if(s1.contains(s))
      {
        System.out.println(s);
        int x=d.get(s)+1;
        d.put(s,x);
      }
    }
    System.out.println(d);

    
  }
}


// given an array with mixture of int and double values; sprate int and double values in seprate lists
import java.util.*;
class Main1 {
  public static  void main1(String args[]) {
    ArrayList<String> d1=new ArrayList<>();
    d1.add("1.0");
    d1.add("11");
    d1.add("12.0");
    d1.add("1232");
    ArrayList<Integer> int1=new ArrayList<>();
     ArrayList<Double> int2=new ArrayList<>();

    for (String i:d1)
      {
        System.out.println(i);
        try
        {
          int j=Integer.parseInt(i);
          int1.add(j);
        }
        catch( Exception e)
          {
            double d=Double.parseDouble(i);
            int2.add(d);
          }
      }
    for(double i:int2)
      {
        System.out.println("-----------"+i);
      }
  }
}


 


class Main3 {
  public static  void main(String args[]) 
  {
    //Given as input two integers n_1,n_2 and two double values d_1,d_2 complete the Java code to form two complex numbers c_1 and c_2, as described below, and print their sum.

    complex<Integer,Double> v1=new complex(1,1.0);
    complex <Integer,Double> v2=v1;
    v1.get();
    complex<?,?> v11=v1.add(v2);
    
  }
}



class complex<t, d>
  {
    // class will accept 2 datatype input: t1,t2
    t r;
    d i;
    public complex(t x,d y)
    {
      this.r=x;
      this.i=y;
    }
    public  void get()
    {
      System.out.println(this.r+" i "+this.i);
    }

    public complex<?,?> add(complex<Integer,Double> n)
    {

      complex<Integer,Double> n1=new complex(0,0.0);
      n1.r=(Integer)this.r+(Integer)n.r;
      n1.i=(double)this.i+(double)n.i;
      System.out.println(n1.r+" i "+n1.i);
      return n1;
    }

    public String toString()
    {
      return this.r+" i "+this.i;
    }
  }