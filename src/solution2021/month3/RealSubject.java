package solution2021.month3;

public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println(" do some thing");
    }
    @Override
    public void saySomething() {
        System.out.println(" say some thing2");
    }

    @Override
    public String returnSomething(String a, String b) {
        return a+b;
    }

}
