public class cloning {
   public static void main()
   {
    s s2= new s();
    s s22=s2;
    s22.setx(100);
    s22.printx();
    s2.printx();


    int val1=121;
    int val2=val1;
    val1=122;
    System.out.println(val1+"----- main "+val2);
   }   
}

class s
{
    static private int x=10;
    public static void printx()
    {
       System.out.println(x+"    value of x");
    }

    public void  setx( int xx )
    {
        this.x=xx;
    }

}
