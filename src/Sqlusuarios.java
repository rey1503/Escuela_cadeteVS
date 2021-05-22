import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

public class Sqlusuarios  extends Conexion{
	public boolean agregarAlumno(agregarAl aAl) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO registro (nombre, sexo,apellidop, apellidom, curp, lista, grado, grupo, status, ingreso) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, aAl.getNombre());
			ps.setString(2, aAl.getSexo());
			ps.setString(3, aAl.getApellidop());
			ps.setString(4, aAl.getApellidom());
			ps.setString(5, aAl.getCurp());
			ps.setString(6, aAl.getLista());
			ps.setString(7,aAl.getGrado());
			ps.setString(8, aAl.getGrupo());
			ps.setString(9, aAl.getStatus());
			ps.setString(10, aAl.getIngreso());
			ps.execute();
			return true;
		}catch (SQLException e) {
			Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
		}
		return false;
		}

public boolean login (Usuarios usr) {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConexion();
	String sql = "SELECT * FROM profe WHERE nombre = ?"; 	
	try {
		ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, usr.getNombre());
		rs=ps.executeQuery();
		if(rs.next()) {
		if(usr.getContraseña().equals(rs.getString(3))){
			usr.setIdprofe(rs.getInt(1));
			usr.setNombre(rs.getString(2));
			return true;			
		}else {
			System.out.println("algo salio mal"); 
			System.out.println(usr.getContraseña());
			System.out.println(rs.getString(3));
			
		}
		}else {
			System.out.println("algo salio mal");
			System.out.println(usr.getContraseña());
			return false;
	}
		return false;
	}catch (SQLException e) {
		System.out.println("algo salio mal");
		System.out.println(usr.getContraseña());
		Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
	}
	return false;	
}

public boolean alumnitos(alumnos bal) {
	Conexion conexion=new Conexion();
	conexion.getConexion();
	Connection cn = null;
	Statement stm=null;
	ResultSet rs=null;
	try {
		cn =conexion.getConexion();
		stm =(Statement) cn.createStatement();
		rs =stm.executeQuery("SELECT * FROM registro");
		while(rs.next()){
			int IdU=rs.getInt(1);
			String Nom=rs.getString(2);
			String sexo=rs.getString(3);
			String apep=rs.getString(4);
			String apm=rs.getString(5);
			String curp=rs.getString(6);
			String lista=rs.getString(7);
			String grado=rs.getString(8);
			String grupo=rs.getString(9);
			String status=rs.getString(10);
			String ingreso=rs.getString(11);
		}
	} catch (Exception e) {
	}
	return false;
}

	public boolean califi(Cali cl) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "UPDATE registro SET calificacion = ?, Asignatura =?, parcial= ? where id=?";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setDouble(1, cl.getCalificacion());
			ps.setString(2, cl.getAsignatura());
			ps.setString(3, cl.getParcial());
			ps.setInt(4,cl.getId());
			ps.execute();
			return true;
		}catch (SQLException e) {
			Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
		}
		return false;
		}
	public boolean pen(Pend pendientes) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql = "INSERT INTO pendientes (pendiente) VALUES (?)";
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pendientes.getPendiente());
			ps.execute();
			return true;
		}catch (SQLException e) {
			Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
		}
		return false;
		}
	public boolean Bo(Borrado borrar) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql =("DELETE FROM pendientes WHERE id=(?)");
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, borrar.getId());
			ps.execute();
			return true;
		}catch (SQLException e) {
			Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
		}
		return false;
		}
	public boolean Boo(borras bor) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		String sql =("DELETE FROM notas WHERE id=(?)");
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, bor.getId());
			ps.execute();
			return true;
		}catch (SQLException e) {
			Logger.getLogger(Sqlusuarios.class.getName()).log(Level.SEVERE,null,e);
		}
		return false;
		}
}




