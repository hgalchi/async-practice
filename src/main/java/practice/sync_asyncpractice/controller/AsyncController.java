package practice.sync_asyncpractice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.sync_asyncpractice.service.AsyncService;

@RequiredArgsConstructor
@RestController
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/async-request")
    public void asyncRequest() {
        for (int i = 0; i < 10; i++) {
            asyncService.asyncMethod(i + " ");
        }
    }


}
