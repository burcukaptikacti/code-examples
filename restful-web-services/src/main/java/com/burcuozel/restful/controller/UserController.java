package com.burcuozel.restful.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.burcuozel.restful.exception.UserNotFoundException;
import com.burcuozel.restful.model.User;
import com.burcuozel.restful.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/users")
	public List<User> retrieveAll() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieve(@PathVariable int id) {
		User user = service.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}

		EntityModel<User> resource = EntityModel.of(user);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());

		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user) {
		User createdUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUSer(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
	}

	/*
	 * Internationalization -1
	 */
	@GetMapping("/users-messages-old")
	public String retrieveUserMessageOld(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("user.message", null, locale);
	}

	@GetMapping("/users-messages")
	public String retrieveUserMessage() {
		return messageSource.getMessage("user.message", null, LocaleContextHolder.getLocale());
	}
}
