package com.arjay.demo.services;

public interface IUploaderJobService {
    
    public void uploadPizzaType(String file);

    public void uploadPizza(String file);

    public void uploadOrder(String file);

    public void uploadOrderDetail(String file);
}
