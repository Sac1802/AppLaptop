package com.example.AppLaptop.Controller;

import com.example.AppLaptop.Entity.Laptop;
import com.example.AppLaptop.Repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;

    private Logger log = LoggerFactory.getLogger(LaptopController.class);
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }



    @GetMapping("/api/laptop/get")
    public List<Laptop> findAll(){
        System.out.println(message);
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptop/getid/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOp = laptopRepository.findById(id);
        if (laptopOp.isPresent()){
            return ResponseEntity.ok(laptopOp.get());
        }else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptop/post")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        if (laptop.getId() != null){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptop/update")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){
            log.warn("Trying to update a not exist laptop");
            return ResponseEntity.badRequest().build();
        }

        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a not exist laptop");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptop/deleteid/{id}")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying to delete a not exist laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        log.info("The laptop was successfully removed from the database");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptop/delete")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for Deleting all laptops");
        laptopRepository.deleteAll();
        log.info("all data saved in the database was deleted");
        return ResponseEntity.noContent().build();
    }
}
