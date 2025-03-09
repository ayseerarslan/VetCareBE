package erarslan.ayse.VetCare.api;

import erarslan.ayse.VetCare.business.abstracts.ICustomerService;
import erarslan.ayse.VetCare.dto.request.customer.CustomerSaveRequest;
import erarslan.ayse.VetCare.dto.request.customer.CustomerUpdateRequest;
import erarslan.ayse.VetCare.dto.response.customer.CustomerResponse;
import erarslan.ayse.VetCare.entitiy.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public String home(){
        return "Customers";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)

    public List<Customer> findAll(){
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findById(@PathVariable("id")int id){
        return this.customerService.getById(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
        return this.customerService.save(customerSaveRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse update(@Valid @PathVariable("id") int id, @RequestBody CustomerUpdateRequest customerUpdateRequest){
        return this.customerService.update(id, customerUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }
}
