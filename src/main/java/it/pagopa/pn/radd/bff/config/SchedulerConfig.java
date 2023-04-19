package it.pagopa.pn.radd.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class SchedulerConfig {

    @Bean("raddBffScheduler")
    public Scheduler scheduler(){
        return Schedulers.boundedElastic();
    }

}
