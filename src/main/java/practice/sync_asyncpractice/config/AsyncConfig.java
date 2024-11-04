package practice.sync_asyncpractice.config;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //기본적으로 유지할 스레드 수
        threadPoolTaskExecutor.setCorePoolSize(5);
        //풀에서 허용되는 최대 스레드 수
        threadPoolTaskExecutor.setMaxPoolSize(5);
        //큐 대기열에 저장할 수 있는 최대 작업 수
        threadPoolTaskExecutor.setQueueCapacity(500);
        //생성된 스레드 이름의 접두사 설정
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        //설정한 내용을 바탕으로 스레드 풀 초기화
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
}
