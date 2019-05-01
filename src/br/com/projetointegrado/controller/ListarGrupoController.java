package br.com.projetointegrado.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetointegrado.model.Grupo;
import br.com.projetointegrado.service.GrupoService;

@WebServlet("/listar_grupos.do") 
public class ListarGrupoController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");   
			String chave = request.getParameter("data[search]");   
			String acao = request.getParameter("acao");   
			GrupoService grupo = new GrupoService();   
			ArrayList<Grupo>lista = null;   
			HttpSession session = request.getSession();
			if (acao.equals("buscar")) {    
				if (chave != null&&chave.length() > 0) {     
					lista = grupo.findAll(chave);    
				} else {     
					lista = grupo.findAll();    
				}    
				session.setAttribute("lista", lista);   
			} else if (acao.equals("reiniciar")) {    
				session.setAttribute("lista", null);   
			}	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListarGrupos.jsp");   
			   dispatcher.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request,    HttpServletResponse response) throws ServletException, IOException {   
		doGet(request, response);  
	}


}
