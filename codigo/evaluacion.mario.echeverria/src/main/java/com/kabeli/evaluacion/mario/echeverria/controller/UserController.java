package com.kabeli.evaluacion.mario.echeverria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kabeli.evaluacion.mario.echeverria.entity.User;
import com.kabeli.evaluacion.mario.echeverria.service.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ResponseEntity<?> save(@Valid @RequestBody User request, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "En el campo: '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			User user = userService.findByEmail(request.getEmail());
			if (user == null) {
				User newUser = new User();
				newUser = userService.save(request);
				response.put("id", newUser.getIdUser());
				response.put("created", newUser.getCreated());
				response.put("modified", (newUser.getModified() != null)? newUser.getModified(): "null");
				response.put("last_login", newUser.getLastLogin());
				response.put("isactive", newUser.getIsactive());
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			} else {
				response.put("mensaje", "El correo ya existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getUsers", method = { RequestMethod.GET })
	public ResponseEntity<?> getUsers() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<User> listUsers = userService.getAllUsers();
			response.put("users", listUsers);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("mensaje", "Error al buscar los usuarios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
