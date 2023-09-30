package com.boyishi.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boyishi.demo.entities.Client;
import com.boyishi.demo.services.ClientsService;

@RestController
@RequestMapping("/api/clients")
@SuppressWarnings("rawtypes")
@EnableCaching
public class ClientsController {
	@Autowired
	private final ClientsService clientService;

	public ClientsController(ClientsService clientService) {
		this.clientService = clientService;
	}

	@GetMapping
	public List<Client> getClients() {
		return clientService.findAll();
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable Long id) {
		return clientService.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
		Client savedClient = clientService.save(client);
		return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
		Client currentClient = clientService.findById(id).orElseThrow(RuntimeException::new);
		currentClient.setName(client.getName());
		currentClient.setEmail(client.getEmail());
		currentClient = clientService.save(client);

		return ResponseEntity.ok(currentClient);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return ResponseEntity.ok().build();
	}
}