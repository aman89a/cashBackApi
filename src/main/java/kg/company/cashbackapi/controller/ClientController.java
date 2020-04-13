package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Client;
import kg.company.cashbackapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id) throws Exception {
        return clientService.findById(id);
    }

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @PutMapping("/{id}")
    public Client putClient(@PathVariable("id") Long id, @RequestBody Client client) throws Exception {
        return clientService.putById(id, client);
    }

    @PostMapping()
    public Client postClient(@RequestBody Client client) {
        clientService.create(client);
        return client;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return clientService.deleteById(id);
    }

}
