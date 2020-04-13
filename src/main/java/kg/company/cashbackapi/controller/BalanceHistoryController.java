package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.BalanceHistory;
import kg.company.cashbackapi.service.BalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/balanceHistory")
public class BalanceHistoryController {
    @Autowired
    BalanceHistoryService balanceHistoryService;

    @GetMapping("/{id}")
    public BalanceHistory getBalanceHistoryById(@PathVariable("id") Long id) throws Exception {
        return balanceHistoryService.findById(id);
    }

    @GetMapping("/all")
    public List<BalanceHistory> getAll() {
        return balanceHistoryService.findAll();
    }

    @PutMapping("/{id}")
    public BalanceHistory putBalanceHistory(@PathVariable("id") Long id, @RequestBody BalanceHistory balanceHistory) throws Exception {
        return balanceHistoryService.putById(id, balanceHistory);
    }

    @PostMapping()
    public BalanceHistory postBalanceHistory(@RequestBody BalanceHistory balanceHistory) {
        balanceHistoryService.create(balanceHistory);
        return balanceHistory;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return balanceHistoryService.deleteById(id);
    }

}
