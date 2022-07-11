package com.example.repository;

import com.example.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {

    public List<Rent> findAllByCustomer(String customer);

    public List<Rent> findAllByDateOfRetern(String date);

}
