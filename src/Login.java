import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
public class Login extends JFrame implements ActionListener{
		
		JLabel a,b,c,d;
		JLabel aa,bb,cc,dd;
		JTextField e,g,h,ee;
		JLabel aaa;
		JPasswordField f;
		JButton i,ii;
	public Login(JFrame registro){
		Conexion conexion=new Conexion();
		  Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	     setResizable(false);
	      //setSize(width/2, height/2);
		setLocation(width/4, height/4);
	      setLayout(null);
		//setLocationRelativeTo(null);
		ActionListener salida=new de();
		setTitle ("BIENVENIDO");
		a=new JLabel("BIENVENIDO");
		a.setBounds(200, 5, 100, 30);
		b=new JLabel("Usuario:");
		b.setBounds(80, 80, 100, 30);
		e=new JTextField();
		e.setToolTipText("Ingresa Usuario");
		e.setBounds(180, 80,150, 30);
		c=new JLabel("Contraseña:");
		c.setBounds(80, 180, 100, 30);
		f = new JPasswordField();
		f.setBounds(180, 180,150, 30);
		f.setEchoChar('*');
		f.setToolTipText("ingresa Contraseña"); 
		i=new JButton("Aceptar");
		i.setBounds(200, 300, 100, 30);
		i.addActionListener(salida);
		add(a);
		add(b);
		add(c);
		add(i);
		add(e);
		add(f);
		setSize(500,500);
		setVisible(true);

	}

		public class de implements ActionListener{
		public void actionPerformed(ActionEvent z) {
		Sqlusuarios modSql = new Sqlusuarios(); 
		Usuarios mod = new Usuarios ();
		String pass = new String(f.getPassword());
		if(!e.getText().equals("") && !pass.equals("")) {
	   mod.setNombre(e.getText());
		mod.setContraseña(pass);
		if(modSql.login(mod)){
			JOptionPane.showMessageDialog(null, "Bienvenido","Bienvenido",  JOptionPane.DEFAULT_OPTION, null);	
			 setVisible(false);
			 PanelP lp=new PanelP(null,null, null, null, null, null, null, null);
		    lp.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(null, "USUARIO Y/O CONTRASEÑA INVALIDO","ERROR",  JOptionPane.DEFAULT_OPTION, null);
		}
		}
		else {
			JOptionPane.showMessageDialog(null, "PRIMERO INGRESA DATOS","ERROR",  JOptionPane.DEFAULT_OPTION, null);
		}
			
		}
		}	
		public static void main(String[] args) {
			Login o=new Login(null);//(pa, panelP);
		o.setVisible(true);
		o.setResizable(true);
		o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		public void actionPerformed(ActionEvent arg0) {
		}
	}