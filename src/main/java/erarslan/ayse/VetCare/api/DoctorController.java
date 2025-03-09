package erarslan.ayse.VetCare.api;

import erarslan.ayse.VetCare.business.abstracts.IDoctorService;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorSaveRequest;
import erarslan.ayse.VetCare.dto.request.doctor.DoctorUpdateRequest;
import erarslan.ayse.VetCare.dto.response.doctor.DoctorResponse;
import erarslan.ayse.VetCare.entitiy.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {

    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    public String home(){
        return "Doctors";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findAll(){
        return this.doctorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor findById(@PathVariable("id")int id){
        return this.doctorService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest){
        return this.doctorService.save(doctorSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorResponse update(@Valid @PathVariable("id") long id, @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        return this.doctorService.update(id, doctorUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.doctorService.delete(id);
    }
}
