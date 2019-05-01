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
		
		String pAcao = request.getParameter("acao");
		String pNome = request.getParameter("nome");
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch(NumberFormatException e) {
			
		}
		
		
		//instanciar o javabean
		Grupo grupo = new Grupo();
		grupo.setGrupo_id(id);
		grupo.setGrupo_nome(pNome);
		
		//instanciar o service
		GrupoService cs = new GrupoService();
		RequestDispatcher view = null;   
		HttpSession session = request.getSession(); 
		//cs.carregar(grupo.getGrupo_id());
		
		if (pAcao.equals("Criar")) {  
			int pNumero = Integer.parseInt(request.getParameter("numero"));
			grupo.setNumero(pNumero);
			cs.criar(grupo);    
			ArrayList<Grupo>lista = new ArrayList<>();    
			lista.add(grupo);    
			session.setAttribute("lista", lista);    
			view = request.getRequestDispatcher("ListarGrupos.jsp"); 
		} else if (pAcao.equals("Excluir")) {    
			cs.excluir(grupo.getGrupo_id());    
			ArrayList<Grupo>lista = (ArrayList<Grupo>)session.getAttribute("lista");    
			lista.remove(busca(grupo, lista));    
			session.setAttribute("lista", lista);    
			view = request.getRequestDispatcher("ListarGrupos.jsp");
		} else if (pAcao.equals("Alterar")) {    
			cs.atualizar(grupo);    
			ArrayList<Grupo>lista = (ArrayList<Grupo>)session.getAttribute("lista");    
			int pos = busca(grupo, lista);    
			lista.remove(pos);    
			lista.add(pos, grupo);    
			session.setAttribute("lista", lista);    
			request.setAttribute("grupo", grupo);    
			view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		} else if (pAcao.equals("Visualizar")) {    
			grupo = cs.carregar(grupo.getGrupo_id());    
			request.setAttribute("grupo", grupo);    
			view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		} else if (pAcao.equals("Editar")) {    
			grupo = cs.carregar(grupo.getGrupo_id());    
			request.setAttribute("grupo", grupo);    
			view = request.getRequestDispatcher("AlterarGrupo.jsp");
		}
		
		view.forward(request, response);
        
    }
	
	public int busca(Grupo grupo, ArrayList<Grupo> lista) {   
		Grupo to;   
		for(int i = 0; i<lista.size(); i++){    
			to = lista.get(i);    
			if(to.getGrupo_id() == grupo.getGrupo_id()){     
				return i;    
			}   
		}   
		return -1;  
	} 

}

