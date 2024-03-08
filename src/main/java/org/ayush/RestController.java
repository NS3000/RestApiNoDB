package org.ayush;

import org.ayush.Entity.Product;
import org.ayush.Exceptions.ProductAlreadyExistsException;
import org.ayush.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.ayush.Inventory.productMap;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/shop")
public class RestController{

    @GetMapping()
    public String print(){
        StringBuilder temp = new StringBuilder(" ");
        for (Product p : productMap.values())
        {
            temp.append("<br>").append(p.toString()).append("<br>");}
        return temp.toString();
    }
    @GetMapping("/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productMap.values(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        if(productMap.containsKey(product.getId())){throw new ProductAlreadyExistsException();}
        productMap.put(product.getId(), product);
        return new ResponseEntity<>(product +"      --    Added Successfully",HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id,@RequestParam int count){
        if(!productMap.containsKey(id)){throw new ProductNotFoundException();}
        productMap.get(id).setCount(count);
        return new ResponseEntity<>("Inventory Updated successfully.",HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){
        if(!productMap.containsKey(id)){throw new ProductNotFoundException();}
        productMap.remove(id);
        return new ResponseEntity<>("Item Deleted Successfully.",HttpStatus.OK);
    }






}
