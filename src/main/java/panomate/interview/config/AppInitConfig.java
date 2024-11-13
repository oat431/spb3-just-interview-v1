package panomate.interview.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import panomate.interview.utils.MockDataUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppInitConfig implements ApplicationListener<ApplicationReadyEvent> {
    private final MockDataUtils mockDataUtils;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Application is starting...");
        if(mockDataUtils.checkMovie() == 0) {
            mockDataUtils.mockMovie();
        }
        log.info("Application started successfully");
    }
}
