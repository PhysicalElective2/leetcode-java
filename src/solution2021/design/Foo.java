package solution2021.design;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Foo {
    private BlockingQueue<Integer> one;
    private BlockingQueue<Integer> two;

    public Foo() {
        one=new LinkedBlockingQueue<>();
        two =new LinkedBlockingQueue<>();

    }



    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.put(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        one.take();
        printSecond.run();
        two.put(1);
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        two.take();
        printThird.run();
    }
}
