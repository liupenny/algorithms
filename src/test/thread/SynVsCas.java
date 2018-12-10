package thread;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/10
 */
public class SynVsCas {
    public static int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            for (int j = 0; j < 100; j++) {
                                synchronized (SynVsCas.class) {
                                    count++;
                                }
                            }
                        }
                    }
            ).start();
        }

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count = " + count);
    }
}
