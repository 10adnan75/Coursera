class SuperClass {
    public String name1, name2;
    public SuperClass(String a, String b) {
	this.name1 = a;
	this.name2 = b;
    }
    public void displayHello() {
	System.out.println("Hello " + name1 + " and " + name2);
    }
    public void displayGoodbye() {
	System.out.println("Goodbye " + name2 + " and " + name1); 
    }
}

public class HelloGoodbye {
    public static void main(String args[]) {
	String name1 = args[0];
	String name2 = args[1];
	SuperClass sc = new SuperClass(name1, name2);
	sc.displayHello();
	sc.displayGoodbye();
    }
}