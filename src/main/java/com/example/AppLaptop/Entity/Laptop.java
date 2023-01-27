package com.example.AppLaptop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Integer ram;
    private Integer storage;
    private String cpu;
    private String gpu;

    public Laptop(){

    }

    public Laptop(Long id, String model, Integer ram, Integer storage, String cpu, String gpu) {
        this.id = id;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }
}
