package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    Customer findById(long id);
    boolean existsByMail(String mail);
}
