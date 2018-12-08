package thread;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/6
 */

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:使用synchronized关键字和object的wait,notify，notifyall方法实现生产者消费者模式
 * @Date
 * @Param
 * @return
 **/
class ProAndCus1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "LOCK";

    public static void main(String[] args) {
        ProAndCus1 proAndCus1 = new ProAndCus1();
        new Thread(proAndCus1.new Producer()).start();
        new Thread(proAndCus1.new Consumer()).start();
        new Thread(proAndCus1.new Producer()).start();
        new Thread(proAndCus1.new Consumer()).start();
        new Thread(proAndCus1.new Producer()).start();
        new Thread(proAndCus1.new Consumer()).start();
        new Thread(proAndCus1.new Producer()).start();
        new Thread(proAndCus1.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            // 必须加catch，不然会报错
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}

/**
 * @Author liu Ruiqing
 * @Description  使用可重入锁ReentrantLock, lock, unlock方法实现
 * @Date  
 * @Param 
 * @return 
 **/
class ProAndCus2 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    // 可重入锁
    private static ReentrantLock lock = new ReentrantLock();
    // 两个条件变量，
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    public static void main(String[] args) {
        ProAndCus2 proAndCus2 = new ProAndCus2();
        new Thread(proAndCus2.new Producer()).start();
        new Thread(proAndCus2.new Consumer()).start();
        new Thread(proAndCus2.new Producer()).start();
        new Thread(proAndCus2.new Consumer()).start();
        new Thread(proAndCus2.new Producer()).start();
        new Thread(proAndCus2.new Consumer()).start();
        new Thread(proAndCus2.new Producer()).start();
        new Thread(proAndCus2.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            full.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有" + count);
                    // 要唤醒对方的线程
                    empty.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            empty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有" + count);
                    full.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

/**
 * @Author liu Ruiqing
 * @Description  阻塞队列blockingqueue实现
 * @Date
 * @Param
 * @return
 **/
class ProAndCus3 {
    private static Integer count = 0;
    static final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        ProAndCus3 proAndCus3 = new ProAndCus3();
        new Thread(proAndCus3.new Producer()).start();
        new Thread(proAndCus3.new Consumer()).start();
        new Thread(proAndCus3.new Producer()).start();
        new Thread(proAndCus3.new Consumer()).start();
        new Thread(proAndCus3.new Producer()).start();
        new Thread(proAndCus3.new Consumer()).start();
        new Thread(proAndCus3.new Producer()).start();
        new Thread(proAndCus3.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * @Author liu Ruiqing
 * @Description  信号量实现。用来控制同时访问特定资源的线程数量，可以用来解决哲学家就餐问题。
 * @Date
 * @Param
 * @return
 **/
class ProAndCus4 {
    private static Integer count = 0;
    //创建三个信号量
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);
    public static void main(String[] args) {
        ProAndCus4 proAndCus4 = new ProAndCus4();
        new Thread(proAndCus4.new Producer()).start();
        new Thread(proAndCus4.new Consumer()).start();
        new Thread(proAndCus4.new Producer()).start();
        new Thread(proAndCus4.new Consumer()).start();
        new Thread(proAndCus4.new Producer()).start();
        new Thread(proAndCus4.new Consumer()).start();
        new Thread(proAndCus4.new Producer()).start();
        new Thread(proAndCus4.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    notFull.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}

class ProAndCus5 {
    final PipedInputStream pis = new PipedInputStream();
    final PipedOutputStream pos = new PipedOutputStream();
    {
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    int num = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "生产者生产了一个数字，该数字为： " + num);
                    pos.write(num);
                    pos.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(1000);
                    int num = pis.read();
                    System.out.println("消费者消费了一个数字，该数字为：" + num);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    pos.close();
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProAndCus5 test5 = new ProAndCus5();
        new Thread(test5.new Producer()).start();
        new Thread(test5.new Consumer()).start();
    }
}