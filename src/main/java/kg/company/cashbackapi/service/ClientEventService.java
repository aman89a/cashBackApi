package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.ClientEvent;
import kg.company.cashbackapi.repository.ClientEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientEventService {
    @Autowired
    private ClientEventRepository clientEventRepository;

    public ClientEvent findById(Long id) throws Exception {
        return clientEventRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<ClientEvent> findAll() {
        return clientEventRepository.findAll();
    }

    public ClientEvent create(ClientEvent clientEvent) {
        return clientEventRepository.save(clientEvent);
    }

    public String deleteById(Long id) {
        clientEventRepository.deleteById(id);
        return "ClientEvent number " + id + " has been deleted!";
    }

    public ClientEvent putById(Long id, ClientEvent clientEvent) throws Exception {
        return clientEventRepository.findById(id)
                .map(newClientEvent -> {
                    newClientEvent.setId(clientEvent.getId());
                    newClientEvent.setClient(clientEvent.getClient());
                    newClientEvent.setEvent(clientEvent.getEvent());
                    newClientEvent.setCreatedDate(clientEvent.getCreatedDate());
                    newClientEvent.setNotificationDate(clientEvent.getNotificationDate());
                    return clientEventRepository.save(newClientEvent);
                })
                .orElseThrow(Error::new);
    }


}
