package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.ClientPreferenceValue;
import kg.company.cashbackapi.repository.ClientPreferenceValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientPreferenceValueService {
    @Autowired
    private ClientPreferenceValueRepository clientPreferenceValueRepository;

    public ClientPreferenceValue findById(Long id) throws Exception {
        return clientPreferenceValueRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<ClientPreferenceValue> findAll() {
        return clientPreferenceValueRepository.findAll();
    }

    public ClientPreferenceValue create(ClientPreferenceValue clientPreferenceValue) {
        return clientPreferenceValueRepository.save(clientPreferenceValue);
    }

    public String deleteById(Long id) {
        clientPreferenceValueRepository.deleteById(id);
        return "ClientPreferenceValue number " + id + " has been deleted!";
    }

    public ClientPreferenceValue putById(Long id, ClientPreferenceValue clientPreferenceValue) throws Exception {
        return clientPreferenceValueRepository.findById(id)
                .map(newClientPreferenceValue -> {
                    newClientPreferenceValue.setId(clientPreferenceValue.getId());
                    newClientPreferenceValue.setClient(clientPreferenceValue.getClient());
                    newClientPreferenceValue.setOrganization(clientPreferenceValue.getOrganization());
                    newClientPreferenceValue.setOrganizationPreferenceCategory(clientPreferenceValue.getOrganizationPreferenceCategory());
                    newClientPreferenceValue.setValue(clientPreferenceValue.getValue());
                    return clientPreferenceValueRepository.save(newClientPreferenceValue);
                })
                .orElseThrow(Error::new);
    }


}
