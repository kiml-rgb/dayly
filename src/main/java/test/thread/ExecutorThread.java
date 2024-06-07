package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZYF
 * @date: 2024/6/5 22:13
 * @description:
 */
public class ExecutorThread implements Runnable{
    @Override
    public void run() {
        System.out.println("run一下");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ExecutorThread());
        executorService.shutdown();
    }
}
