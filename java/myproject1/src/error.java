public class error {
    public static void main()
    {
        try{
           String s=throwerror();
        }
        catch (Exception e)
        {
          System.out.println("-------------");
        }
        
        System.out.println("main run");
    }

    public static  void e1(){
        try
        {
           System.out.println("try run");
        }
        catch (Exception e)
        {
          System.out.println("catch run");
        }
    }

    public  static String throwerror() throws Exception{
        Exception s= new Exception("exception throw at throwerror");
        throw s;
    }
}
