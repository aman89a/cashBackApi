package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.ClientDevice;
import kg.company.cashbackapi.repository.ClientDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDeviceService {
    @Autowired
    private ClientDeviceRepository clientDeviceRepository;

    public ClientDevice findById(Long id) throws Exception {
        return clientDeviceRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<ClientDevice> findAll() {
        return clientDeviceRepository.findAll();
    }

    public ClientDevice create(ClientDevice clientDevice) {
        return clientDeviceRepository.save(clientDevice);
    }

    public String deleteById(Long id) {
        clientDeviceRepository.deleteById(id);
        return "ClientDevice number " + id + " has been deleted!";
    }

    public ClientDevice putById(Long id, ClientDevice clientDevice) throws Exception {
        return clientDeviceRepository.findById(id)
                .map(newClientDevice -> {
                    newClientDevice.setId(clientDevice.getId());
                    newClientDevice.setClient(clientDevice.getClient());
                    newClientDevice.setClientLocale(clientDevice.getClientLocale());
                    newClientDevice.setImei(clientDevice.getImei());
                    newClientDevice.setLastEnterDate(clientDevice.getLastEnterDate());
                    newClientDevice.setPassword(clientDevice.getPassword());
                    newClientDevice.setPhoneNumber(clientDevice.getPhoneNumber());
                    newClientDevice.setStatus(clientDevice.getStatus());
                    return clientDeviceRepository.save(newClientDevice);
                })
                .orElseThrow(Error::new);
    }


}
