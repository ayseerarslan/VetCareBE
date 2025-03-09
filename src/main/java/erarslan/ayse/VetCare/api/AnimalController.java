package erarslan.ayse.VetCare.api;

import erarslan.ayse.VetCare.business.abstracts.IAnimalService;
import erarslan.ayse.VetCare.business.abstracts.ICustomerService;
import erarslan.ayse.VetCare.dto.request.animal.AnimalSaveRequest;
import erarslan.ayse.VetCare.dto.request.animal.AnimalUpdateRequest;
import erarslan.ayse.VetCare.dto.response.animal.AnimalResponse;
import erarslan.ayse.VetCare.entitiy.Animal;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService animalService;
    private final ICustomerService customerService;

    public AnimalController(IAnimalService animalService, ICustomerService customerService) {
        this.animalService = animalService;
        this.customerService = customerService;
    }

    @GetMapping()
    public String home(){
        return "Animals";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> findAll(){
        return this.animalService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal findById(@PathVariable("id") Long id){
        return this.animalService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalResponse save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        return animalService.save(animalSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalResponse update(@Valid @PathVariable("id") long id, @RequestBody AnimalUpdateRequest animalUpdateRequest){
        return this.animalService.update(id, animalUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.animalService.delete(id);
    }
}
