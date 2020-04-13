package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Client;
import kg.company.cashbackapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public String deleteById(Long id) {
        clientRepository.deleteById(id);
        return "Client number " + id + " has been deleted!";
    }

    public Client putById(Long id, Client client) throws Exception {
        return clientRepository.findById(id)
                .map(newClient -> {
                    newClient.setId(client.getId());
                    newClient.setClientSex(client.getClientSex());
                    newClient.setCreatedDate(client.getCreatedDate());
                    newClient.setFirstName(client.getFirstName());
                    newClient.setLastName(client.getLastName());
                    newClient.setLocale(client.getLocale());
                    newClient.setNationality(client.getNationality());
                    newClient.setPatronymic(client.getPatronymic());
                    newClient.setPersonalCode(client.getPersonalCode());
                    newClient.setOrganizations(client.getOrganizations());
                    return clientRepository.save(newClient);
                })
                .orElseThrow(Error::new);
    }


}
