package com.springbatchexample.config;

import com.springbatchexample.entity.Customer;
import com.springbatchexample.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerAsyncWritter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void write(Chunk<? extends Customer> chunk) throws Exception {
        System.out.println("Thread Name :" + Thread.currentThread().getName());
        customerRepository.saveAll(chunk);
    }
}
