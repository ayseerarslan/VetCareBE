package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
    Report findById(long id);
}
