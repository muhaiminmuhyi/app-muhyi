package org.mumu.Service;

import net.sf.jasperreports.engine.*;

import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;

@RequestScoped
public class JasperReportGeneratorService {
    private final DataSource dataSource;

    public JasperReportGeneratorService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void generatePdfReport(String jasperReportPath, String outputFileName) throws Exception {
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperReportPath);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
