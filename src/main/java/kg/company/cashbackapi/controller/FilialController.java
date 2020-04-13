package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Filial;
import kg.company.cashbackapi.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/filial")
public class FilialController {
    @Autowired
    FilialService filialService;

    @GetMapping("/{id}")
    public Filial getFilialById(@PathVariable("id") Long id) throws Exception {
        return filialService.findById(id);
    }

    @GetMapping("/all")
    public List<Filial> getAll() {
        return filialService.findAll();
    }

    @PutMapping("/{id}")
    public Filial putFilial(@PathVariable("id") Long id, @RequestBody Filial filial) throws Exception {
        return filialService.putById(id, filial);
    }

    @PostMapping()
    public Filial postFilial(@RequestBody Filial filial) {
        filialService.create(filial);
        return filial;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return filialService.deleteById(id);
    }

}
