public class static_word {
  public static void main() {
    System.out.println("HIi");

    // call static varibale directly : class_name.variable_name
    System.out.println("staic value: " + parent.x);
    // call non static variable
    parent c = new child();
    System.out.println("non staic value: " + c.y);

    // fun1(): static function, so run from parent class
    c.fun1();
    //// fun2(): static function, so run from child class
    c.fun2();
  }
}

class parent {
  static int x = 10;
  int y = 20;

  // static function cannot overwrite in inheritance
  public static void fun1() {
    System.out.println("static function in parent class");
  }

  public void fun2() {
    System.out.println("non static function in parent class ");
  }
}

class child extends parent {

  // static function cannot overwrite in inheritance
  public static void fun1() {
    System.out.println("static function in child class");
  }

  public void fun2() {
    System.out.println("non static function in child class ");
  }
}
