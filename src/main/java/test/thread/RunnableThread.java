package test.thread;

/**
 * @author ZYF
 * @date: 2024/6/5 21:59
 * @description:
 */
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("thread run ......");
    }

    public static void main(String[] args) {
        new Thread(new RunnableThread()).run();
    }
}
