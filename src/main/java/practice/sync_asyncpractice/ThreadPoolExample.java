package practice.sync_asyncpractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {

        //스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //submit
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("Thread name:" + Thread.currentThread().getName());
            });
        }
        //스레드 풀 종료
        executorService.shutdown();
    }
}
