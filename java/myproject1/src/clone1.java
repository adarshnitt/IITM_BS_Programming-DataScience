public class clone1 {
    public static void main( ) throws CloneNotSupportedException
    {
        child c1= new child();
        c1.cname="c1";
        c1.parent1= new parent("p1");

        System.out.println("---------------------");

        child c2= c1.clone();
        c2.cname="c2";
        c2.parent1= new parent("p2");

      
        System.out.println(c1);
        System.out.println(c2);
    }
}


class child implements Cloneable
{
    String cname;
    parent parent1;
    public String toString()
    {
       return this.cname+"   " +parent1.pname;
    }

    public child clone() throws CloneNotSupportedException
  {
    child c0 = (child) super.clone();

    parent p0=new parent();

    c0.parent1=p0;
    return c0;
  }

}
class parent implements Cloneable 
{
    String pname;
    public parent()
  {
    //
  }
    public parent(String x)
  {
    this.pname=x;
  }

    public Object clone() throws CloneNotSupportedException
    {
       return super.clone();
       // shallow cloning
    }

}