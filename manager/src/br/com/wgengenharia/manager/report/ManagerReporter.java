package br.com.wgengenharia.manager.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.wgengenharia.manager.model.Student;

public class ManagerReporter implements ManagerReporterInterface 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde est�o armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relat�rios
	public ManagerReporter() throws UnsupportedEncodingException {
	   StringBuilder sb = new StringBuilder();
	   sb.append("/").append(System.getProperty("jboss.server.base.dir")).append("/deployments/manager.war/WEB-INF/classes/br/com/wgengenharia/manager/jasper/");
		 pathToReportPackage = sb.toString().replaceAll("\\\\","/");
	}
	
	
	//Imprime/gera uma lista de Clientes
	public InputStream generate(Student student) throws Exception{
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "StudentContract.jrxml");
		
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(students));
 
		JasperExportManager.exportReportToPdfFile(print, "C:/Users/william.galindo/Desktop/firstReport.pdf");
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		JasperExportManager.exportReportToPdfStream(print, out);
		
		InputStream is = new ByteArrayInputStream(out.toByteArray());

//		StreamedContent file = new DefaultStreamedContent(is, "", "contrato.pdf");
		
		return is;
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}