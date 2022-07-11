package com.example.service.impl;

import com.example.entity.Rent;
import com.example.repository.RentRepository;
import com.example.service.RentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RentServiceImp implements RentService {

        private final RentRepository rentRepository;

    public RentServiceImp(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Rent> findAllRent() {
        return rentRepository.findAll();    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Rent> findAllRentByCustomer(String customer) {

        return rentRepository.findAllByCustomer(customer);
    }


    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Rent> findAllRentByDate(String date) {
        return rentRepository.findAllByDateOfRetern(date);    }
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public void createRent(Rent rent) {
    try{

    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, rent.getPeriod());
    Date returnDate=c.getTime();
    System.out.println(returnDate);
    rent.setDateOfRetern(returnDate.toString());

    }catch (Exception e){
        System.out.println("error");
    }

        rentRepository.save(rent);
    }

}
