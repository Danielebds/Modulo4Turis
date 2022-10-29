package controller;
import model.Cliente;
import model.ClienteDAO;

@WebServlet("/SalvarCliente")
public class SalvarCliente extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String nome = request.getParameter("nome");
	String telefone = request.getParameter("telefone");
	String email = request.getParameter("email");
	Cliente cli = new Cliente();
	cli.setNome(nome);
	cli.setTelefone(telefone);
	cli.setEmail(email);
	request.setAttribute("Cliente", cli);
	
	ClienteDAO clienteDAO = new ClienteDAO(); 
	clienteDAO.save(cli);
	
	RequestDispatcher rd = request.getRequestDispatcher("sucesso.jsp");
	rd.forward(request, response);
	}
}
