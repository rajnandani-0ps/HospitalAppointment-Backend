package com.hospital.appointments;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins="*")
public class AppointmentController {
 private final AppointmentRepository repo;
 public AppointmentController(AppointmentRepository repo){this.repo=repo;}
 @GetMapping public List<Appointment> all(){return repo.findAll();}
 @GetMapping("/{id}") public Appointment one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment not found"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Appointment create(@Valid @RequestBody Appointment a){a.id=null;return repo.save(a);}
 @PutMapping("/{id}") public Appointment update(@PathVariable Long id,@Valid @RequestBody Appointment a){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment not found");a.id=id;return repo.save(a);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Appointment not found");repo.deleteById(id);}
}
