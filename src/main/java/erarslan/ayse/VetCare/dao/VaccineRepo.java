package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.Animal;
import erarslan.ayse.VetCare.entitiy.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    Vaccine findById(long id);
    boolean existsByCode(String code);
    boolean existsByNameAndCode(String name, String code);
    List<Vaccine> findByProtectionStartDateGreaterThanEqualAndProtectionFinishDateLessThanEqual(LocalDate protectionStartDate, LocalDate protectionFinishDate);
    List<Vaccine> findByAnimal(Animal animal);
}
