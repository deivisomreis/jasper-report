package com.deivisonprogrammer.jasper.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deivisonprogrammer.jasper.dao.UsuarioDAO;
import com.deivisonprogrammer.jasper.model.Usuario;

@WebServlet({"/CadastroServlet", "/cadastro/novo"})
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CadastroServlet() {
		usuarioDAO = new UsuarioDAO();
	}
    
	private static UsuarioDAO usuarioDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		
		if(option != null && !option.isEmpty() && option.equals("cadastrar")){
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			
			if(nome != null && !nome.isEmpty() && telefone != null && !telefone.isEmpty()){
				Usuario user = new Usuario();
				user.setNome(nome);
				user.setTelefone(telefone);
				usuarioDAO.insert(user);
				
				request.setAttribute("sucesso", nome + " cadastrado com sucesso!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				request.setAttribute("error" , "Favor preencher todos os dados!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		else
			request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
