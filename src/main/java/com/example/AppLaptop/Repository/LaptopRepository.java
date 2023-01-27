package com.example.AppLaptop.Repository;

import com.example.AppLaptop.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
