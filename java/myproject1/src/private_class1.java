public class private_class1 {
    public static void main(String[] args) {
        System.out.println(" Private class  in side a classexplain kar raha hu hai");
        parent p = new parent();
        p.question();
    }
}

class parent {
    // private class deined in a public class
    public parent() {
        System.out.println("Parent constructor..");
    }

    public void question() {
        System.out.println("question function -> parent class");
        // way to access private class 
        data d = new data();
        d.query();
    }

    // private class
    private class data {
        public data() {
            System.out.println("constructor unction in constructor->private class-> parent class");
        }

        public void query() {
            System.out.println("query unction in constructor->private class-> parent class");
        }
    }

}