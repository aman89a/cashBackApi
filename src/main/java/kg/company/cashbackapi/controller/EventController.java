package kg.company.cashbackapi.controller;

import kg.company.cashbackapi.entity.Event;
import kg.company.cashbackapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") Long id) throws Exception {
        return eventService.findById(id);
    }

    @GetMapping("/all")
    public List<Event> getAll() {
        return eventService.findAll();
    }

    @PutMapping("/{id}")
    public Event putEvent(@PathVariable("id") Long id, @RequestBody Event event) throws Exception {
        return eventService.putById(id, event);
    }

    @PostMapping()
    public Event postEvent(@RequestBody Event event) {
        eventService.create(event);
        return event;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        return eventService.deleteById(id);
    }

}
