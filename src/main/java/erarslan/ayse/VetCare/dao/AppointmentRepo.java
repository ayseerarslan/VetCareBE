package erarslan.ayse.VetCare.dao;

import erarslan.ayse.VetCare.entitiy.Animal;
import erarslan.ayse.VetCare.entitiy.Appointment;
import erarslan.ayse.VetCare.entitiy.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    Appointment findById(long id);
    boolean existsByAppointmentDate(LocalDateTime appointmentDate);
    List<Appointment> findByAppointmentDateBetweenAndDoctor(LocalDateTime startDate,LocalDateTime endDate, Doctor doctor);
    List<Appointment> findByAppointmentDateBetweenAndAnimal(LocalDateTime startDate, LocalDateTime endDate, Animal animal);

}
