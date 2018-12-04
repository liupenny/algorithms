package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/30
 */
class ThreadDemo extends Thread{
    public void run(){
        for (int i = 0; i < 60; i++) {
            System.out.println(Thread.currentThread().isInterrupted() + ": " + i);
            System.out.println(Thread.interrupted());
        }
    }

}

class Test implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Test ss = new Test();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}

class Demo{
    public static void main(String[] args) {
        runThread();
        runThread();
    }

    private static void runThread() {
        ThreadDemo demo = new ThreadDemo();
        demo.start();
    }
}