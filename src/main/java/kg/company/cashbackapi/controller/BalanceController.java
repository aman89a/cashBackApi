package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Balance;
import kg.company.cashbackapi.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/balance")
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    @GetMapping("/{id}")
    public Balance getBalanceById(@PathVariable("id") Long id) throws Exception {
        return balanceService.findById(id);
    }

    @GetMapping("/all")
    public List<Balance> getAll() {
        return balanceService.findAll();
    }

    @PutMapping("/{id}")

    public Balance putBalance(@PathVariable("id") Long id, @RequestBody Balance balance) throws Exception {
        return balanceService.putById(id, balance);
    }

    @PostMapping()
    public Balance postBalance(@RequestBody Balance balance) {
        balanceService.create(balance);
        return balance;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return balanceService.deleteById(id);
    }

}
