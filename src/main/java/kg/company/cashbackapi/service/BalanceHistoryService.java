package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.BalanceHistory;
import kg.company.cashbackapi.repository.BalanceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceHistoryService {
    @Autowired
    private BalanceHistoryRepository balanceHistoryRepository;

    public BalanceHistory findById(Long id) throws Exception {
        return balanceHistoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<BalanceHistory> findAll() {
        return balanceHistoryRepository.findAll();
    }

    public BalanceHistory create(BalanceHistory balanceHistory) {
        return balanceHistoryRepository.save(balanceHistory);
    }

    public String deleteById(Long id) {
        balanceHistoryRepository.deleteById(id);
        return "BalanceHistory number " + id + " has been deleted!";
    }

    public BalanceHistory putById(Long id, BalanceHistory balanceHistory) throws Exception {
        return balanceHistoryRepository.findById(id)
                .map(newBalanceHistory -> {
                    newBalanceHistory.setId(balanceHistory.getId());
                    newBalanceHistory.setAmount(balanceHistory.getAmount());
                    newBalanceHistory.setBalance(balanceHistory.getBalance());
                    newBalanceHistory.setCreatedDate(balanceHistory.getCreatedDate());
                    newBalanceHistory.setOperationType(balanceHistory.getOperationType());
                    return balanceHistoryRepository.save(newBalanceHistory);
                })
                .orElseThrow(Error::new);
    }


}
