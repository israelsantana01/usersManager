package report;

import java.io.InputStream;
import java.util.ArrayList;
import models.Students;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class Report {
    
    public void generateReport(ArrayList<Students> student) throws JRException{
        InputStream source = Report.class.getResourceAsStream("/report/reports.jrxml");
        
        JasperReport report = JasperCompileManager.compileReport(source);
        JasperPrint print = JasperFillManager.fillReport(
                report, 
                null, 
                new JRBeanCollectionDataSource(student)
        );
        
        JasperViewer.viewReport(print, false);
    }
}
