/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Conexion.Conexion;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
 ;

/**
 *
 * @author Alexander
 */
public class GenerarReporte {

    Conexion conexion = new Conexion();
    Connection con = (Connection) conexion.getConnection();

    public void generarPDF(Date inicio,Date finall) {
        JasperReport reporte=null;
        String path="src/Reportes/Reporte.jasper";

        Map parametro=new HashMap();
        parametro.put("inicio", inicio);
        parametro.put("final", finall);

        try {
            reporte=(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint=JasperFillManager.fillReport(reporte, parametro,con);

            JasperViewer view=new JasperViewer(jprint,false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error en "+ex.toString());
        }

    }
}
