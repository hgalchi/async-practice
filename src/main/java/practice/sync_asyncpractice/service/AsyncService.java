package practice.sync_asyncpractice.service;

import java.util.concurrent.CompletableFuture;
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


}
