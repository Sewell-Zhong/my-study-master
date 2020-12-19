package com;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Mr-Z
 * @date : 2020/12/07 1:42
 */
public class ThreadStatTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Object object = new Object();
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
//                        Thread.sleep(50*1000);
                        System.out.println("thread1 waiting");
//                        object.wait();
                        object.wait(5000);
                        System.out.println("thread1 after waiting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        System.out.println("thread2 notify");
                        // 打开或关闭这段注释，观察Thread1的状态
                        object.notify();
                        // notify之后当前线程并不会释放锁，只是被notify的线程从等待队列进入同步队列
                        // sleep也不会释放锁
                        Thread.sleep(500*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread2").start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock.lock();
//                System.out.println("thread3 waiting");
//                try {
//                    condition.await();
////                condition.await(200, (TimeUnit).SECONDS);
//                    System.out.println("thread3 after waiting");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "Thread3").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock.lock();
//                System.out.println("thread4");
//                // 打开或关闭这段注释，观察Thread3的状态
////            condition.signal();
//                // signal之后当前线程并不会释放锁，只是被signal的线程从等待队列进入同步队列
//                // sleep也不会释放锁
//                try {
//                    Thread.sleep(1000000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "Thread4").start();

    }

}
