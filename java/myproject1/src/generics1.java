public class generics1 {
    public static void main()
    {
        gen.f1();
        System.out.println("---------- main");
    }
}
class gen <t>
{
   public static <v> void f1()
   {
     System.out.println("----------gen.f1");
   }
}