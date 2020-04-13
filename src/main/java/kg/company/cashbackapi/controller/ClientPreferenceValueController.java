package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.ClientPreferenceValue;
import kg.company.cashbackapi.service.ClientPreferenceValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientPreferenceValue")
public class ClientPreferenceValueController {
    @Autowired
    ClientPreferenceValueService clientPreferenceValueService;

    @GetMapping("/{id}")
    public ClientPreferenceValue getClientPreferenceValueById(@PathVariable("id") Long id) throws Exception {
        return clientPreferenceValueService.findById(id);
    }

    @GetMapping("/all")
    public List<ClientPreferenceValue> getAll() {
        return clientPreferenceValueService.findAll();
    }

    @PutMapping("/{id}")
    public ClientPreferenceValue putClientPreferenceValue(@PathVariable("id") Long id, @RequestBody ClientPreferenceValue clientPreferenceValue) throws Exception {
        return clientPreferenceValueService.putById(id, clientPreferenceValue);
    }

    @PostMapping()
    public ClientPreferenceValue postClientPreferenceValue(@RequestBody ClientPreferenceValue clientPreferenceValue) {
        clientPreferenceValueService.create(clientPreferenceValue);
        return clientPreferenceValue;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return clientPreferenceValueService.deleteById(id);
    }

}
