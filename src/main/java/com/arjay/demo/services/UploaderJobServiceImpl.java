package com.arjay.demo.services;

import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.arjay.demo.entity.Order;
import com.arjay.demo.entity.OrderDetail;
import com.arjay.demo.entity.Pizza;
import com.arjay.demo.entity.PizzaCategory;
import com.arjay.demo.entity.PizzaType;
import com.arjay.demo.entity.Size;
import com.arjay.demo.exception.UploadJobException;
import com.arjay.demo.repository.OrderDetailRepository;
import com.arjay.demo.repository.OrderRepository;
import com.arjay.demo.repository.PizzaRepository;
import com.arjay.demo.repository.PizzaTypeRepository;
import com.opencsv.CSVReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UploaderJobServiceImpl implements IUploaderJobService{

    public static int BATCH_COUNT = 20;
    
    @Autowired
    private IStorageService storateService;

    @Autowired
    private PizzaTypeRepository pizzaTypeRepo;

    @Autowired
    private PizzaRepository pizzaRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderDetailRepository orderDetailRepo;

    @Override
    @Job(name = "Upload Pizza Type Job", retries = 0)
    public void uploadPizzaType(String file){

        Resource csvFile = storateService.loadAsResource(file);
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile.getFile()))) {

            String[] values = null;
            List<PizzaType> records = new ArrayList<PizzaType>();
            while ((values = csvReader.readNext()) != null) {
                if(!values[0].equalsIgnoreCase("pizza_type_id")){
                    records.add(new PizzaType(values[0], values[1], PizzaCategory.valueOf(values[2]), values[3]));
                    if(records.size() == BATCH_COUNT) {
                        pizzaTypeRepo.saveAll(records);
                        records.clear();
                    }
                }
            }

            if(records.size() > 0) {
                pizzaTypeRepo.saveAll(records);
            }
        } catch (Exception e) {
            throw new UploadJobException(e.getMessage(), e);
        }
        log.info("Pizza Type Uploaded..");
    }

    @Override
    @Job(name = "Upload Pizza Job", retries = 0)
    public void uploadPizza(String file){

        Resource csvFile = storateService.loadAsResource(file);
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile.getFile()))) {

            String[] values = null;
            List<Pizza> records = new ArrayList<Pizza>();
            while ((values = csvReader.readNext()) != null) {
                if(!values[0].equalsIgnoreCase("pizza_id")){
                    records.add(new Pizza(values[0], new PizzaType(values[1]), Size.valueOf(values[2]), Float.parseFloat(values[3])));
                    if(records.size() == BATCH_COUNT) {
                        pizzaRepo.saveAll(records);
                        records.clear();
                    }
                }
            }

            if(records.size() > 0) {
                pizzaRepo.saveAll(records);
            }
        } catch (Exception e) {
            throw new UploadJobException(e.getMessage(), e);
        }
        log.info("Pizza Uploaded..");
    }

    @Override
    @Job(name = "Upload Order Job", retries = 0)
    public void uploadOrder(String file){

        Resource csvFile = storateService.loadAsResource(file);
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile.getFile()))) {

            String[] values = null;
            List<Order> records = new ArrayList<Order>();
            while ((values = csvReader.readNext()) != null) {
                if(!values[0].equalsIgnoreCase("order_id")){
                    records.add(new Order(Long.parseLong(values[0]), Date.valueOf(values[1]), Time.valueOf(values[2])));
                    if(records.size() == BATCH_COUNT) {
                        orderRepo.saveAll(records);
                        records.clear();
                    }
                }
            }

            if(records.size() > 0) {
                orderRepo.saveAll(records);
            }
        } catch (Exception e) {
            throw new UploadJobException(e.getMessage(), e);
        }
        log.info("Orders Uploaded..");
    }

    @Override
    @Job(name = "Upload Order Detail Job", retries = 0)
    public void uploadOrderDetail(String file){

        Resource csvFile = storateService.loadAsResource(file);
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile.getFile()))) {

            String[] values = null;
            List<OrderDetail> records = new ArrayList<OrderDetail>();
            while ((values = csvReader.readNext()) != null) {
                if(!values[0].equalsIgnoreCase("order_details_id")){
                    records.add(new OrderDetail(
                        Long.parseLong(values[0]), 
                        new Order(Long.parseLong(values[1])), 
                        new Pizza(values[2]),
                        Short.parseShort(values[3])
                    ));
                    if(records.size() == BATCH_COUNT) {
                        orderDetailRepo.saveAll(records);
                        records.clear();
                    }
                }
            }

            if(records.size() > 0) {
                orderDetailRepo.saveAll(records);
            }
        } catch (Exception e) {
            throw new UploadJobException(e.getMessage(), e);
        }
        log.info("Order Details Uploaded..");
    }
}