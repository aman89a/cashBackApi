package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.ClientEvent;
import kg.company.cashbackapi.service.ClientEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientEvent")
public class ClientEventController {
    @Autowired
    ClientEventService clientEventService;

    @GetMapping("/{id}")
    public ClientEvent getClientEventById(@PathVariable("id") Long id) throws Exception {
        return clientEventService.findById(id);
    }

    @GetMapping("/all")
    public List<ClientEvent> getAll() {
        return clientEventService.findAll();
    }

    @PutMapping("/{id}")
    public ClientEvent putClientEvent(@PathVariable("id") Long id, @RequestBody ClientEvent clientEvent) throws Exception {
        return clientEventService.putById(id, clientEvent);
    }

    @PostMapping()
    public ClientEvent postClientEvent(@RequestBody ClientEvent clientEvent) {
        clientEventService.create(clientEvent);
        return clientEvent;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return clientEventService.deleteById(id);
    }

}
