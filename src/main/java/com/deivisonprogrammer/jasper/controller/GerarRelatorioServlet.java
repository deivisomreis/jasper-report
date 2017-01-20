package com.deivisonprogrammer.jasper.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.deivisonprogrammer.jasper.dao.UsuarioDAO;

@WebServlet("/relatorio")
public class GerarRelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GerarRelatorioServlet() {
    	usuarioDAO = new UsuarioDAO();
    }
    
    private JasperReport report;
    private JasperPrint print;
    private JasperExportManager export;
    
    private static UsuarioDAO usuarioDAO;

	
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		
		if(option != null && !option.isEmpty() && option.equals("novorelatorio")){
			try {
				response.setContentType("application/pdf");
				report = JasperCompileManager.compileReport("/home/deivisonprogrammer/workspace/jasper-report2/src/main/webapp/jaspertemplate/report1.jrxml");
				print = JasperFillManager.fillReport(report, null,	new JRBeanCollectionDataSource(usuarioDAO.getUsuarios()));
				ServletOutputStream os = response.getOutputStream();
				// response.setContentLength(export.exportReportToPdf(print).length);
				os.write(export.exportReportToPdf(print));				
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			request.setAttribute("relatorio", usuarioDAO.getUsuarios());
			request.getRequestDispatcher("/relatorio.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
