package com.arjay.demo.controller;

import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arjay.demo.model.UploadResponse;
import com.arjay.demo.services.IStorageService;
import com.arjay.demo.services.IUploaderJobService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    
    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private IUploaderJobService jobServ;

    @Autowired
    private IStorageService storageService;
    
    @PostMapping("/pizzaType")
	public UploadResponse uploadPizzaType(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
        log.info("Upload Success:" + file.getOriginalFilename());

        JobId job = jobScheduler.enqueue(()->jobServ.uploadPizzaType(file.getOriginalFilename()));
        log.info("JobID:" + job.asUUID());

        return new UploadResponse("Successfully uploaded", job.asUUID());
	}

    @PostMapping("/pizza")
	public UploadResponse uploadPizza(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
        log.info("Upload Success:" + file.getOriginalFilename());

        JobId job = jobScheduler.enqueue(()->jobServ.uploadPizza(file.getOriginalFilename()));
        log.info("JobID:" + job.asUUID());

        return new UploadResponse("Successfully uploaded", job.asUUID());
	}

    @PostMapping("/order")
	public UploadResponse uploadOrder(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
        log.info("Upload Success:" + file.getOriginalFilename());

        JobId job = jobScheduler.enqueue(()->jobServ.uploadOrder(file.getOriginalFilename()));
        log.info("JobID:" + job.asUUID());

        return new UploadResponse("Successfully uploaded", job.asUUID());
	}

    @PostMapping("/orderDetail")
	public UploadResponse uploadOrderDetail(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
        log.info("Upload Success:" + file.getOriginalFilename());

        JobId job = jobScheduler.enqueue(()->jobServ.uploadOrderDetail(file.getOriginalFilename()));
        log.info("JobID:" + job.asUUID());

        return new UploadResponse("Successfully uploaded", job.asUUID());
	}
}
