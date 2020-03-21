package br.com.morpheos.dao.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexao {
	   
	public Connection conn;
	public static String erro;
	protected static String mensagem;

	private DataSource ds;
	
	public void conecta() {
	    try {
	    	Class.forName("com.mysql.jdbc.Driver").newInstance();
	    }
	    catch (Exception ex) {
	      mensagem = "Driver não carregado!";
	      System.out.println("erro:"+mensagem);
	    }
	    try {
	    	Context initContext = new InitialContext();
	    	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    	ds = (DataSource)envContext.lookup("jdbc/MorpheosDB");
	    	conn = ds.getConnection();    	        
	    }
	    catch (NamingException e) {
	    	mensagem = e.getMessage();
		    setErro(e.getMessage());
		    System.out.println("erro:"+mensagem);
	    }
	    catch (SQLException ex) {
	      mensagem = ex.getMessage();
	      setErro(ex.getMessage());
	      System.out.println("erro:"+mensagem);
	    }
	}
	  
	private void setErro(String message) {
		Conexao.erro = message;
		
	}
	 			
	public static String getErro() {
		return erro;
	}

	public void fechar() {
		  try {
	 			if (conn != null)
	 				conn.close();
	 		} catch (SQLException e) {e.getMessage();}
	 
	  }
	

}

