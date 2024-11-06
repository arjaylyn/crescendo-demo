package com.arjay.demo;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.utils.mapper.jackson.JacksonJsonMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.arjay.demo.model.StorageProperties;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    @Bean
    public StorageProperties storageProperties() {
        return new StorageProperties();
    }

    @Bean
    public StorageProvider storageProvider() {
        InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
        storageProvider.setJobMapper(new JobMapper(new JacksonJsonMapper()));
        return storageProvider;
    }
	
    @Bean
    public JobScheduler scheduler() {
        return new JobScheduler(storageProvider());
    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
