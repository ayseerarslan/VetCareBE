package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Doctor findById(long id);
    boolean existsByMail(String mail);

}
