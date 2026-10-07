package com.example.employee.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SalesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Map<String,Object> getUserDetails(String email){
		Map<String, Object> response = new HashMap<>();

        try {

            String getQuery = "SELECT * FROM myapp.users where email=?";

            List<Map<String, Object>> dataList =
                    jdbcTemplate.queryForList(getQuery,email);

            response.put("success", true);
            response.put("message", "Successfully retrieved user details");
            response.put("data", dataList);

        } catch (Exception e) {

            response.put("success", false);
            response.put("message", e.getMessage());
            response.put("data", List.of());
        }

        return response;
	}
	
	public Map<String, Object> updateUserById(int id, String email) {
		Map<String, Object> response = new HashMap<>();
		response.put("success", false);
		response.put("message", "Failed to connect the database");
		try {
			if (id <= 0) {
				response.put("message", "Please send valid id");
				return response;
			}

			String updateQuery = "UPDATE users SET email=? WHERE id=?";

			int i = jdbcTemplate.update(updateQuery, email, id);
			if (1 > 0) {
				response.put("success", true);
				response.put("message", "Successfully retrieved user details");
			} else {
				response.put("message", "Something went wrong, Please try again after sometime.");
			}

		} catch (Exception e) {

			response.put("success", false);
			response.put("message", e.getMessage());
			response.put("data", List.of());
		}

		return response;
	}
 
}
