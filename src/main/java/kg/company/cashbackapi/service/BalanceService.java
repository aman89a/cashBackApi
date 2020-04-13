package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Balance;
import kg.company.cashbackapi.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balanceRepository;

    public Balance findById(Long id) throws Exception {
        return balanceRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Balance> findAll() {
        return balanceRepository.findAll();
    }

    public Balance create(Balance balance) {
        return balanceRepository.save(balance);
    }

    public String deleteById(Long id) {
        balanceRepository.deleteById(id);
        return "Balance number " + id + " has been deleted!";
    }

    public Balance putById(Long id, Balance balance) throws Exception {
        return balanceRepository.findById(id)
                .map(newBalance -> {
                    newBalance.setId(balance.getId());
                    newBalance.setAmount(balance.getAmount());
                    newBalance.setClient(balance.getClient());
                    newBalance.setOrgBonus(balance.getOrgBonus());
                    return balanceRepository.save(newBalance);
                })
                .orElseThrow(Error::new);
    }


}
