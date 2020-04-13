package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.ClientDevice;
import kg.company.cashbackapi.service.ClientDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientDevice")
public class ClientDeviceController {
    @Autowired
    ClientDeviceService clientDeviceService;

    @GetMapping("/{id}")
    public ClientDevice getClientDeviceById(@PathVariable("id") Long id) throws Exception {
        return clientDeviceService.findById(id);
    }

    @GetMapping("/all")
    public List<ClientDevice> getAll() {
        return clientDeviceService.findAll();
    }

    @PutMapping("/{id}")
    public ClientDevice putClientDevice(@PathVariable("id") Long id, @RequestBody ClientDevice clientDevice) throws Exception {
        return clientDeviceService.putById(id, clientDevice);
    }

    @PostMapping()
    public ClientDevice postClientDevice(@RequestBody ClientDevice clientDevice) {
        clientDeviceService.create(clientDevice);
        return clientDevice;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return clientDeviceService.deleteById(id);
    }

}
