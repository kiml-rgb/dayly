package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ZYF
 * @date: 2024/6/5 22:07
 * @description:
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new CallableThread());
        new Thread(futureTask).start();
        Object o = futureTask.get();
        System.out.println(o);
    }
}

class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("call一下");
        return 1;
    }
}
