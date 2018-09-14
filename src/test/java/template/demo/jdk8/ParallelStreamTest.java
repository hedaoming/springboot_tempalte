package template.demo.jdk8;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

/**
 * Created by peishen on 2018/09/14
 **/
public class ParallelStreamTest {

    @Test
    public void testParallelStream(){
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);
        integerList.parallelStream().forEach(System.out::println);
    }

    @Test
    public void testParalleThread(){
        List<Integer> list = Lists.newArrayList();
        Set<Thread> threadList = new CopyOnWriteArraySet();
        for (int i = 0;i<10000;i++){
            list.add(i);
        }

        list.parallelStream().forEach(integer -> {
            Thread thread = Thread.currentThread();
            threadList.add(thread);
        });

        System.out.println("thread count:" + threadList.size());
        System.out.println(threadList);
        System.out.println("cpu count :" + Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void testTwoThreadParalleThread() throws InterruptedException {
        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();
        for (int i = 0;i<10000;i++){
            list1.add(i);
            list2.add(i);
        }

        Set<Thread> threadSet1 = new CopyOnWriteArraySet<>();
        Set<Thread> threadSet2 = new CopyOnWriteArraySet<>();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                list1.parallelStream().forEach(integer -> {
                    Thread thread = Thread.currentThread();
                    threadSet1.add(thread);
                });
                countDownLatch.countDown();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                list2.parallelStream().forEach(integer -> {
                    Thread thread = Thread.currentThread();
                    threadSet2.add(thread);
                });
                countDownLatch.countDown();
            }
        });

        t1.start();
        t2.start();
        countDownLatch.await();
        System.out.println("thread1:" + threadSet1.size() + "\n" + threadSet1);
        System.out.println("thread2:" + threadSet1.size() + "\n" + threadSet2);
        System.out.println("cpu count:" + Runtime.getRuntime().availableProcessors());

    }
}
