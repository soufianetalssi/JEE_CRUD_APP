package services;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Tp5.Contact;


public class Service {
	public void ajouter(Contact c) {
		java.sql.PreparedStatement st;
		try {
			st = Singleton.getCnx().prepareStatement("insert into client values (?,?,?,?,?)");
			st.setInt(1,c.getCode() );
			st.setString(2, c.getNom());
			st.setString(3, c.getPrenom());
			st.setString(4, c.getVille());
			st.setDate(5, new java.sql.Date(c.getDn().getTime()));
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void supprimer(int c) {
			System.out.println(c);
			java.sql.PreparedStatement st;
			try {
				st = Singleton.getCnx().prepareStatement("delete from client where Code=?");
				st.setInt(1,c );
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		public void modifier(Contact c) {
			java.sql.PreparedStatement st;
			try {
				st = Singleton.getCnx().prepareStatement("update client set Nom=?,Prenom=?,Ville=? where Code=?");
				st.setString(1,c.getNom());
				st.setString(2,c.getPrenom());
				st.setString(3,c.getVille());
			//	st.setDate(4,new java.sql.Date(c.getDn().getTime()));
				st.setInt(4,c.getCode());
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		public List<Contact> afficher(){
			List<Contact> result=new ArrayList<>();
			String s="select * from client";
			java.sql.PreparedStatement st;
			try {
				st = Singleton.getCnx().prepareStatement(s);
				ResultSet res=st.executeQuery();
				
				
				while(res.next()) {
					Contact c=new Contact();
					c.setCode(res.getInt(1));
					c.setNom(res.getString(2));
					c.setPrenom(res.getString(3));
					c.setVille(res.getString(4));
					c.setDn(new java.util.Date(res.getDate(5).getTime()));
					result.add(c);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		public List<Contact> afficherVille(String ville){
			List<Contact> result=new ArrayList<>();
			String s="select * from client where Ville=?";
			java.sql.PreparedStatement st;
			try {
				st = Singleton.getCnx().prepareStatement(s);
				st.setString(1, ville);
				ResultSet res=st.executeQuery();				
				
				while(res.next()) {
					Contact c=new Contact();
					c.setCode(res.getInt(1));
					c.setNom(res.getString(2));
					c.setPrenom(res.getString(3));
					c.setVille(res.getString(4));
					c.setDn(new java.util.Date(res.getDate(5).getTime()));
					result.add(c);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
		}
		public Contact afficherContact(int code){
			String s="select * from client where Code=?";
			System.out.println(code);
			java.sql.PreparedStatement st;
			Contact c=null;
			try {
				st = Singleton.getCnx().prepareStatement(s);
				st.setInt(1, code);
				ResultSet res=st.executeQuery();	
				while(res.next())
				{
					c=new Contact();
					c.setCode(res.getInt(1));
					c.setNom(res.getString(2));
					c.setPrenom(res.getString(3));
					c.setVille(res.getString(4));
					c.setDn(new java.util.Date(res.getDate(5).getTime()));
				}

			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return c;
		}
		public List<Contact> afficherPagination(int page,int size){
			List<Contact> result=new ArrayList<>();
			String s="select * from client Limit ?,?";
			java.sql.PreparedStatement st;
			try {
				st = Singleton.getCnx().prepareStatement(s);
				st.setInt(1, (page-1)*size);
				st.setInt(2, size);
				ResultSet res=st.executeQuery();
				
				
				while(res.next()) {
					Contact c=new Contact();
					c.setCode(res.getInt(1));
					c.setNom(res.getString(2));
					c.setPrenom(res.getString(3));
					c.setVille(res.getString(4));
					c.setDn(new java.util.Date(res.getDate(5).getTime()));
					result.add(c);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		public int nbrPages(int size){
	
			String s="SELECT COUNT(*) as nombre FROM client ";
			java.sql.PreparedStatement st;
			int nbr=0;
			try {
				st = Singleton.getCnx().prepareStatement(s);
				ResultSet res=st.executeQuery();
				
				
				
				while(res.next()) {
					 nbr= res.getInt("nombre");
					
				}
				
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return nbr%size==0?nbr/size:(nbr/size)+1;
			
		}
		

}
