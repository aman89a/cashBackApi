package kg.company.cashbackapi.service;

import kg.company.cashbackapi.entity.Event;
import kg.company.cashbackapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event findById(Long id) throws Exception {
        return eventRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public String deleteById(Long id) {
        eventRepository.deleteById(id);
        return "Event number " + id + " has been deleted!";
    }

    public Event putById(Long id, Event event) throws Exception {
        return eventRepository.findById(id)
                .map(newEvent -> {
                    newEvent.setId(event.getId());
                    newEvent.setDescription(event.getDescription());
                    newEvent.setCreatedDate(event.getCreatedDate());
                    newEvent.setDateTo(event.getDateTo());
                    newEvent.setDateFrom(event.getDateFrom());
                    newEvent.setOrganization(event.getOrganization());
                    return eventRepository.save(newEvent);
                })
                .orElseThrow(Error::new);
    }


}
