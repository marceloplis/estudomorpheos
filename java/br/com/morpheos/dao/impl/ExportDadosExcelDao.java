package br.com.morpheos.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import br.com.morpheos.dao.common.Conexao;

public class ExportDadosExcelDao {

	public String exportVisitasExcel() throws SQLException, Exception {
		Conexao cnct = new Conexao();
		StringBuffer dados = null; //// acho que seria melhor usar o StringBuilder
		// procura no banco de dados
		try {
			PreparedStatement sql = null;
			ResultSet rs = null;			
			cnct.conecta();
			sql = cnct.conn.prepareStatement
					 ( "SELECT * "+
						" FROM tbpaciente p "+
						  
						" LEFT JOIN visita00 v0 ON v0.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita01 v1 ON v1.idPaciente = p.idTBPaciente "+
						 
						" LEFT JOIN visita02 v2 ON v2.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita03 v3 ON v3.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita04 v4 ON v4.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita05 v5 ON v5.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita06 v6 ON v6.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita07 v7 ON v7.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita08 v8 ON v8.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita09 v9 ON v9.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita10 v10 ON v10.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita11 v11 ON v11.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita12 v12 ON v12.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita13 v13 ON v13.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita14 v14 ON v14.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita15 v15 ON v15.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita16 v16 ON v16.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita17 v17 ON v17.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita18 v18 ON v18.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita19 v19 ON v19.idPaciente = p.idTBPaciente "+
						  
						" LEFT JOIN visita20 v20 ON v20.idPaciente = p.idTBPaciente "+
						
						" LEFT JOIN tbsaidaestudo v21 ON v21.idPaciente = p.idTBPaciente");			
			rs = sql.executeQuery();
			
			try {				
				dados = new StringBuffer("");
				ResultSetMetaData rsMeta = rs.getMetaData();
				for(int i = 1; i<=rsMeta.getColumnCount(); i++){
					dados.append(rsMeta.getColumnLabel(i)+"\t"); /// nesta linha imprime somente os nome dos campos da tabela
				}
				dados.append("\n"); // e temos que colocar todos os dados no StringBuffer
				rs.beforeFirst();
				while(rs.next()){
					for(int i = 1; i<=rsMeta.getColumnCount(); i++){
						dados.append(rs.getString(i) +"\t"); /// aqui mostra todos os dados
					}
					dados.append("\n"); 
			 
				} //fim do while
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 
			rs.close();
			sql.close();
				
		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());				
		}
		finally {
			try{
				if ((cnct.conn!=null) && (!cnct.conn.isClosed())) {
					 cnct.conn.close();
				 }
		     }
		     catch(Exception e){e.printStackTrace();}
	    }
		
		return new String(dados);

	}
	
	public String exportEventosExcel() throws SQLException, Exception {
		Conexao cnct = new Conexao();
		StringBuffer dados = null; //// acho que seria melhor usar o StringBuilder
		// procura no banco de dados
		try {
			PreparedStatement sql = null;
			ResultSet rs = null;			
			cnct.conecta();
			sql = cnct.conn.prepareStatement
					 ( "SELECT * "+
					   "  FROM tbpaciente p "+
					   "  LEFT JOIN tbeventoadverso ev ON ev.idPaciente = p.idTBPaciente "+
					   "  LEFT JOIN tbdoencaevento d   ON d.iddoencaevento = ev.iddoencaevento");			
			rs = sql.executeQuery();
			
			try {				
				dados = new StringBuffer("");
				ResultSetMetaData rsMeta = rs.getMetaData();
				for(int i = 1; i<=rsMeta.getColumnCount(); i++){
					dados.append(rsMeta.getColumnLabel(i)+"\t"); /// nesta linha imprime somente os nome dos campos da tabela
				}
				dados.append("\n"); // e temos que colocar todos os dados no StringBuffer
				rs.beforeFirst();
				while(rs.next()){
					for(int i = 1; i<=rsMeta.getColumnCount(); i++){
						dados.append(rs.getString(i) +"\t"); /// aqui mostra todos os dados
					}
					dados.append("\n"); 
			 
				} //fim do while
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 
			rs.close();
			sql.close();
				
		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());				
		}
		finally {
			try{
				if ((cnct.conn!=null) && (!cnct.conn.isClosed())) {
					 cnct.conn.close();
				 }
		     }
		     catch(Exception e){e.printStackTrace();}
	    }
		
		return new String(dados);

	}
	
	public String exportPacientesExcel() throws SQLException, Exception {
		Conexao cnct = new Conexao();
		StringBuffer dados = null; //// acho que seria melhor usar o StringBuilder
		// procura no banco de dados
		try {
			PreparedStatement sql = null;
			ResultSet rs = null;			
			cnct.conecta();
			sql = cnct.conn.prepareStatement
					 ("SELECT * FROM tbpaciente");			
			rs = sql.executeQuery();
			
			try {				
				dados = new StringBuffer("");
				ResultSetMetaData rsMeta = rs.getMetaData();
				for(int i = 1; i<=rsMeta.getColumnCount(); i++){
					dados.append(rsMeta.getColumnLabel(i)+"\t"); /// nesta linha imprime somente os nome dos campos da tabela
				}
				dados.append("\n"); // e temos que colocar todos os dados no StringBuffer
				rs.beforeFirst();
				while(rs.next()){
					for(int i = 1; i<=rsMeta.getColumnCount(); i++){
						dados.append(rs.getString(i) +"\t"); /// aqui mostra todos os dados
					}
					dados.append("\n"); 
			 
				} //fim do while
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			 
			rs.close();
			sql.close();
				
		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());				
		}
		finally {
			try{
				if ((cnct.conn!=null) && (!cnct.conn.isClosed())) {
					 cnct.conn.close();
				 }
		     }
		     catch(Exception e){e.printStackTrace();}
	    }
		
		return new String(dados);

	}
	
}
