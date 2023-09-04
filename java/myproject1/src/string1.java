public class string1 {
    public static void main()
    {
        String s="Adarsh";
        
        //string to char
        char[] c =s.toCharArray();
        //System.out.println(c);

        // char to string
        String s2=new String(c);
        //System.out.println(s2);
        
        char c1= s.charAt(2);
        //System.out.println(c1);
        
        //length
        //System.out.println(s.length());
        
        //substring
        //System.out.println(s.substring(1,4));

        //contain
        //System.out.println(s.contains("s"));
        
        // is empty
        //System.out.println(s.isEmpty());
 
        //equal: case senstive, upper cannot same as lower
        String s3= "Swati";
        //System.out.println(s3.equals(s));

        s=s.replace("a","w");
        //System.out.println(s);

        //index o elem
        //System.out.println(s.indexOf("w"));
        
        // lowercase
        s=s.toLowerCase();
        //System.out.println(s);

        //upper case
        s=s.toUpperCase();
        //System.out.println(s);
 
        //string concat
        s=s+" "+s3+" "+10;
        //System.out.println(s);

        s=s.concat(" asdf");
        //System.out.println(s);

        // join using delimeter
        s=s.join(";",s,s3);
        //System.out.println(s);


    }
}
