package erarslan.ayse.VetCare.business.concretes;

import erarslan.ayse.VetCare.business.abstracts.IReportService;
import erarslan.ayse.VetCare.dao.ReportRepo;
import erarslan.ayse.VetCare.dto.request.report.ReportSaveRequest;
import erarslan.ayse.VetCare.dto.request.report.ReportUpdateRequest;
import erarslan.ayse.VetCare.dto.response.report.ReportResponse;
import erarslan.ayse.VetCare.entitiy.Report;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import erarslan.ayse.VetCare.core.modelmapper.IModelMapperService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportManager implements IReportService {

    private final ReportRepo reportRepo;
    private final IModelMapperService modelMapperService;

    @Override
    public Report getById(long id) {
        return this.reportRepo.findById(id);
    }

    @Override
    public ReportResponse save(ReportSaveRequest reportSaveRequest) {
        Report saveReport = this.modelMapperService.forRequest().map(reportSaveRequest, Report.class);
        return this.modelMapperService.forResponse().map(this.reportRepo.save(saveReport), ReportResponse.class);
    }

    @Override
    public ReportResponse update(long id, ReportUpdateRequest reportUpdateRequest) {
        Report existingReport = reportRepo.findById(id);
        if (existingReport != null) {
            String newTitle = reportUpdateRequest.getTitle();
            String newDiagnosis = reportUpdateRequest.getDiagnosis();
            double newPrice = reportUpdateRequest.getPrice();

            if (newTitle != null) {
                existingReport.setTitle(newTitle);
            }
            if (newDiagnosis != null) {
                existingReport.setDiagnosis(newDiagnosis);
            }
            if (newPrice != 0.0) {
                existingReport.setPrice(newPrice);
            }
            existingReport = reportRepo.save(existingReport);
            return this.modelMapperService.forResponse().map(existingReport, ReportResponse.class);
        } else {
            throw new EntityNotFoundException("Güncellenmek istenen rapor bulunamadı");
        }
    }

    @Override
    public void delete(long id) {
        this.reportRepo.delete(this.getById(id));
    }

    @Override
    public List<Report> findAll() {
        return this.reportRepo.findAll();
    }
}
