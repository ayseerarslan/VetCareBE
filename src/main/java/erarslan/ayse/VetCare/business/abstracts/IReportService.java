package erarslan.ayse.VetCare.business.abstracts;

import erarslan.ayse.VetCare.dto.request.report.ReportSaveRequest;
import erarslan.ayse.VetCare.dto.request.report.ReportUpdateRequest;
import erarslan.ayse.VetCare.dto.response.report.ReportResponse;
import erarslan.ayse.VetCare.entitiy.Report;

import java.util.List;

public interface IReportService {
    Report getById(long id);
    ReportResponse save(ReportSaveRequest reportSaveRequest);
    ReportResponse update(long id, ReportUpdateRequest reportUpdateRequest);
    void delete(long id);
    List<Report> findAll();
}
