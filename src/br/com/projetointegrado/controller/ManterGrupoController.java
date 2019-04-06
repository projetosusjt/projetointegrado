package br.com.projetointegrado.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetointegrado.model.Grupo;
import br.com.projetointegrado.service.GrupoService;

@WebServlet("/ManterGrupo.do")
public class ManterGrupoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int pGrupo_id = Integer.parseInt(request.getParameter("id"));
		int pNumero = Integer.parseInt(request.getParameter("numero"));
		String pNome = request.getParameter("nome");
		
		//instanciar o javabean
		Grupo grupo = new Grupo();
		//grupo.setGrupo_id(pGrupo_id);
		grupo.setNumero(pNumero);
		grupo.setGrupo_nome(pNome);
		
		//instanciar o service
		GrupoService cs = new GrupoService();
		cs.criar(grupo);
		//grupo = cs.carregar(grupo.getGrupo_id());
		
		request.setAttribute("grupo", grupo);
        
        RequestDispatcher view = 
        request.getRequestDispatcher("Grupo.jsp");
        view.forward(request, response);
        
    }

}

