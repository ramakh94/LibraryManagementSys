package com.example.service;

import com.example.entity.Rent;

import java.util.List;

public interface RentService {

    public List<Rent> findAllRent();

    public void createRent(Rent rent);

    public List<Rent> findAllRentByCustomer(String customer);
    public List<Rent> findAllRentByDate(String date);
}
