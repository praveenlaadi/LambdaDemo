package com.example.employee.sales;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
	
	@Autowired
	private SalesDao salesDao;
	
	@GetMapping("/sales/{email}")
    public Map<String, Object> getUserDetails( @PathVariable String email) {
        return salesDao.getUserDetails(email);
    }
	
	@PutMapping("/sales/{id}")
    public Map<String, Object> updateUserById( @PathVariable int id, @RequestParam String email) {
        return salesDao.updateUserById(id,email);
    }

}
