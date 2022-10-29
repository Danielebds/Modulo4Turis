package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ClienteDAO {
	Connection conn=null;
	PreparedStatement pstm=null;
	
	
	public void save(Cliente cliente) {
		//Isso é uma sql comum,os?são os parâmetros que nós vamos adicionar na base //de dados
		
		String sql ="INSERT INTO clientes(nome,telefone,email)"+" VALUES(?,?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;
	
		try {
			
			//cria uma conexão com o banco 
			conn = Conexao.createConnectionToMySQL();
			//cria um PreparedStatment,classe usada para executar a query 
			pstm = conn.prepareStatement(sql);
			//adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1,cliente.getNome());
			//adicionar o valor do segundo parâmetro da sql
			pstm.setString(2,cliente.getTelefone());
			//adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3,cliente.getEmail());
			
			//Executa a sql para inserção dos dados
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões 
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	}

	public void removeById (int id) {
		String sql = "DELETE FROM clientes WHERE id = ?";
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt (1,id);
			
			pstm.execute ();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões 
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}

	public void update(Cliente cliente) {
		String sql ="UPDATE clientes SET nome =?,telefone = ?,email =?"+"WHERE id =?";
		
		try {
			//Cria uma conexão com o banco 
			conn = Conexao.createConnectionToMySQL();
			//cria um PreparedStatment,classe usada para executar a query 
			pstm = conn.prepareStatement(sql);
			//Adiciona O valor do primeiro parâmetro da sql 
			pstm.setString(1,cliente.getNome());
			//Adicionar o valor do segundo parâmetro da sql 
			pstm.setString(2, cliente.getTelefone());
			//Adiciona o valor do terceiro parâmetro da sql 
			pstm.setString(3,cliente.getEmail());
			pstm.setInt(4,cliente.getId());
			
			//Executa a sql para inserção dos dados 
			pstm.execute();
			}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões 
		try {
			if(pstm!=null) {
				pstm.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
	public List<Cliente> getClientes () {
		String sql = "SELECT * FROM clientes";
		List<Cliente> clientes = new ArrayList<Cliente> ();
		//Classe que vai recuperar os dados do banco de dados 
		ResultSet rset=null;
		
		try {
			conn=Conexao.createConnectionToMySQL();
			pstm=conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			//Enquanto existir dados no banco de dados,faça 
			while (rset.next()) {
				
				Cliente cliente = new Cliente ();
				
				//Recupera o id do banco e atribui ele ao objeto 
				cliente.setId(rset.getInt("id"));
				//Recupera o nome do banco e atribui ele ao objeto 
				cliente.setNome(rset.getString("nome"));
				//Recupera a idade do banco e atribui ele ao objeto 
				cliente.setTelefone(rset.getString("telefone"));
				//Recupera a data do banco e atribui ela ao objeto 
				cliente.setEmail(rset.getString("email"));
				
				//Adiciono o contato recuperado, a lista de contatos 
				clientes.add(cliente);
			}}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//Fecha as conexões 
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clientes;
	}
}
