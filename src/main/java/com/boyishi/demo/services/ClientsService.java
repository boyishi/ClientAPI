package com.boyishi.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boyishi.demo.entities.Client;
import com.boyishi.demo.repositories.ClientRepository;

@Service
@EnableCaching
public class ClientsService {
	@Autowired
	ClientRepository clientRepository;

	@Cacheable("clients")
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Cacheable("clients")
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

	public Client save(Client client) {
		return clientRepository.save(client);
	}

	public ResponseEntity<Client> updateClient(Long id, Client client) {
		Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
		currentClient.setName(client.getName());
		currentClient.setEmail(client.getEmail());
		currentClient = clientRepository.save(client);

		return ResponseEntity.ok(currentClient);
	}

	public ResponseEntity<?> deleteClient(Long id) {
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
