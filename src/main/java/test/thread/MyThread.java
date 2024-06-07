package test.thread;

/**
 * @author ZYF
 * @date: 2024/6/5 21:56
 * @description:
 */
public class MyThread extends Thread {
    private int count = 5;

    /**
     * 重写父类中的run()， 执行具体的业务逻辑
     */
    @Override
    public void run() {
        count--;
        System.out.println(count);
    }

    public static void main(String[] args) {
        //1. 创建线程对象的实例， 该对象必须继承Thread类及重写了run()
        MyThread my = new MyThread();

        //2. 创建多个线程的实例， 进入线程的初始化状态
        Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);
        Thread t3 = new Thread(my);

		/*3. 启动线程， 线程只有执行start()之后才算是真正的启动, 才会执行run()方法里面的具体逻辑
		 	线程启动后会进入线程的就绪状态，等待CPU的调用*/
        t1.start();
        t2.start();
        t3.start();
    }
}
