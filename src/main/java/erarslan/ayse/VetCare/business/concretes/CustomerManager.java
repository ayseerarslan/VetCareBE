package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.ICustomerService;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import erarslan.ayse.VetCare.dao.CustomerRepo;
import erarslan.ayse.VetCare.dto.request.customer.CustomerSaveRequest;
import erarslan.ayse.VetCare.dto.request.customer.CustomerUpdateRequest;
import erarslan.ayse.VetCare.dto.response.customer.CustomerResponse;
import erarslan.ayse.VetCare.entitiy.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;
    private final IModelMapperService modelMapperService;



    @Override
    public Customer getById(long id) {
        return this.customerRepo.findById(id);
    }

    @Override
    public Customer getByName(String name) {
        return this.customerRepo.findByName(name);
    }

    @Override
    public CustomerResponse save(CustomerSaveRequest customerSaveRequest) {
        Customer saveCustomer = this.modelMapperService.forRequest().map(customerSaveRequest, Customer.class);
        if (this.customerRepo.existsByMail(saveCustomer.getMail())){
            throw new IllegalArgumentException("Mail adresi daha önce girilmiştir, lütfen farklı bir adres giriniz");
        }
        return this.modelMapperService.forResponse().map(this.customerRepo.save(saveCustomer), CustomerResponse.class);
    }

    @Override
    public CustomerResponse update(long id, CustomerUpdateRequest customerUpdateRequest) {
        Customer updateCustomer = this.modelMapperService.forRequest().map(customerUpdateRequest, Customer.class);
        updateCustomer.setId(id);

        if (this.customerRepo.existsByMail(updateCustomer.getMail()) && !this.customerRepo.findById(id).getMail().equals(updateCustomer.getMail())){
            throw new IllegalArgumentException("Mail adresi daha önce girilmiştir, lütfen farklı bir adres giriniz");
        }
        return this.modelMapperService.forResponse().map(this.customerRepo.save(updateCustomer), CustomerResponse.class);
    }

    @Override
    public void delete(long id) {
        this.customerRepo.delete(this.getById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

}
