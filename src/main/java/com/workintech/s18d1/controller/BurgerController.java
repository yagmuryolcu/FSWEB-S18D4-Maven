package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
@Slf4j
public class BurgerController {

    private final BurgerDao burgerDao;

    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> getAllBurgers(){
        log.info("Fetching all burgers");
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id){
        log.info("Fetching burger with id : {}", id);
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger createBurger(@RequestBody Burger burger){
        log.info("Creating new burger : {}", burger.getName());
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger updatedBurger){
        log.info("Updating burger with id : {}", updatedBurger.getId());
        return burgerDao.update(updatedBurger);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBurger(@PathVariable Long id){
        log.info("Deleting burger with id : {}", id);
        burgerDao.remove(id);
        return ResponseEntity.ok("Burger deleted successfully");
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        log.info("Finding burgers with price : {}", price);
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType) {
        log.info("Finding burgers with breadType : {}", breadType);
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        log.info("Finding burgers containing : {}", content);
        return burgerDao.findByContent(content);
    }
}