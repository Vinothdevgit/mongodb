package com.vinoth.mdbspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinoth.mdbspringboot.model.GroceryItem;
import com.vinoth.mdbspringboot.service.MdbCrudService;



@RestController
@RequestMapping(value="/mdb/crud")
public class MdbCrudController {

    @Autowired
    MdbCrudService mdbCrudService;

    @GetMapping("/find/{category}")
    public ResponseEntity<List<GroceryItem>> getItemsByCategory(@PathVariable String category) {
        List<GroceryItem> groceryItem = mdbCrudService.getItemsByCategory(category);
        return new ResponseEntity<>(groceryItem,groceryItem==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @GetMapping("/create")
    public String createGroceryItems() {
        mdbCrudService.createGroceryItems();
        return "Created Successfully!";
    }

    @PostMapping("/createitem")
    public String createGroceryItem(@RequestBody(required=true) GroceryItem groceryItem) {
        mdbCrudService.createGroceryItem(groceryItem);
        return "Created Successfully!";
    }

    @GetMapping("/getallitems/")
    public ResponseEntity<List<GroceryItem>> showAllGroceryItems(){
        List<GroceryItem> groceryItem = mdbCrudService.showAllGroceryItems();
        return new ResponseEntity<>(groceryItem,groceryItem==null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    
}
