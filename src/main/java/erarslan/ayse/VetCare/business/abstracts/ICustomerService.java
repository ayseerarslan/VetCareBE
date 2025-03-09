package erarslan.ayse.VetCare.business.abstracts;

import erarslan.ayse.VetCare.dto.request.customer.CustomerSaveRequest;
import erarslan.ayse.VetCare.dto.request.customer.CustomerUpdateRequest;
import erarslan.ayse.VetCare.dto.response.customer.CustomerResponse;
import erarslan.ayse.VetCare.entitiy.Customer;

import java.util.List;

public interface ICustomerService {


    Customer getById(long id);
    Customer getByName(String name);
    CustomerResponse save(CustomerSaveRequest customerSaveRequest);
    CustomerResponse update(long id, CustomerUpdateRequest customerUpdateRequest);
    void delete(long id);
    List<Customer> findAll();
}
