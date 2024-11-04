package practice.sync_asyncpractice.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("taskExecutor")
    public void asyncMethod(String s) {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+":"+s + "비동기:" + i);
        }
        System.out.println("done:"+s);
    }


    @Async
    public CompletableFuture asyncCompletableFutureType() {
        return CompletableFuture.completedFuture(nonBlockingMethod());
    }

    public String nonBlockingMethod(){
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+"thread sleep...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interruptedException");
            }

        }
        System.out.println("wake up!!");
        return "asyncMethod done";
    }

    @Async
    public Future<String> asyncFutureType() {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+"thread sleep...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interruptedException");
            }

        }
        System.out.println("wake up!!");
        return null;
    }
}
