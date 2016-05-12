/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.vo;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Abelson
 */
public class LlamarReporte{
       
    public LlamarReporte(){
        
    }
    
    public void imprimirComprobante(int comprobante,int serie,int tipo,Connection conn){
        JasperReport reporte;
            JasperPrint reporte_view;
        try {
                        
            String in=System.getProperty("user.dir")+("\\src\\vista\\Reportes\\ImpresionFactura.jasper");
            reporte=(JasperReport) JRLoader.loadObjectFromFile(in);
            Map parametros=new HashMap();
            parametros.clear();
            parametros.put("comprobante", comprobante);
            parametros.put("serie", serie);
            parametros.put("tipo", tipo);
           reporte_view=JasperFillManager.fillReport(reporte, parametros,conn);
            JasperViewer.viewReport(reporte_view,false);
           
            
        } catch (Exception ex) {
            Logger.getLogger(LlamarReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
        

    
}
