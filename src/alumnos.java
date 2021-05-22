import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
public class alumnos extends javax.swing.JFrame  {
	static JFrame PanelP;
	    public alumnos(JFrame PanelP) {
	    	this.PanelP=PanelP;
	        initComponents();
	        try { 
	        	DefaultTableModel modelo = new DefaultTableModel ();
	        	jTable1.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT id,nombre,apellidop,apellidom,CURP,lista,grado,grupo,status,ingreso,sexo FROM registro";
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           ResultSetMetaData rsMd = rs.getMetaData();
	           int cantidadColumnas = rsMd.getColumnCount();
	           modelo.addColumn("id");
	           modelo.addColumn("nombre");
	           modelo.addColumn("apellidoP");
	           modelo.addColumn("apellidoM");
	           modelo.addColumn("CURP");
	           modelo.addColumn("lista");
	           modelo.addColumn("grado");
	           modelo.addColumn("grupo");
	           modelo.addColumn("status");
	           modelo.addColumn("ingreso");
	           modelo.addColumn("sexo");
					 while(rs.next()){
			               Object [] filas = new Object[cantidadColumnas];
			               for (int i =0;i< cantidadColumnas; i++) {
			                   filas[i] = rs.getObject(i + 1);
			               }
			               modelo.addRow(filas);
			           }
	        }catch (SQLException e) {
			            System.out.println(e.toString());
			        }
	        }
                       
	    private void initComponents() {
	    	jComboBox1 = new javax.swing.JComboBox<>();
	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        jButton1 = new javax.swing.JButton();
	        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
	        jComboBox1.addItem("id");
	             jComboBox1.addItem("apellidoP");
	             jComboBox1.addItem("apellidoM");
	             jComboBox1.addItem("CURP");
	             jComboBox1.addItem("lista");
	             jComboBox1.addItem("grado");
	             jComboBox1.addItem("grupo");
	             jComboBox1.addItem("status");
	             jComboBox1.addItem("ingreso");
	             jComboBox1.addItem("sexo");
	             jComboBox1.setBounds(180, 4, 100, 30);
	             add(jComboBox1);
	        JButton d= new JButton("Buscar");
	        d.setSize(50, 50);
	        d.setBounds(510, 4, 100, 30);
	        d.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent x) {
			        String bus = jTextField1.getText();
			        Object variable = jComboBox1.getSelectedItem();
			        if (!"".equals(bus)){
			        	String  where =("SELECT * FROM registro WHERE " +variable + "='" +bus+"'");
			               try {
			            DefaultTableModel modelo = new DefaultTableModel ();
			            jTable1.setModel(modelo);
			            PreparedStatement ps = null;
			            ResultSet rs= null;
			            Conexion conn = new Conexion ();
			            Connection con = conn.getConexion();
			           String sql = where;
			           ps = con.prepareStatement(sql);
			           rs = ps.executeQuery();
			           ResultSetMetaData rsMd = rs.getMetaData();
			           int cantidadColumnas = rsMd.getColumnCount();
			           modelo.addColumn("id");
			           modelo.addColumn("nombre");
			           modelo.addColumn("apellidoP");
			           modelo.addColumn("apellidoM");
			           modelo.addColumn("CURP");
			           modelo.addColumn("lista");
			           modelo.addColumn("grado");
			           modelo.addColumn("grupo");
			           modelo.addColumn("status");
			           modelo.addColumn("ingreso");
			           modelo.addColumn("sexo");
			           while(rs.next()){
			               Object [] filas = new Object[cantidadColumnas];
			               for (int i =0;i< cantidadColumnas; i++) {
			                   filas[i] = rs.getObject(i + 1);
			               }
			               modelo.addRow(filas);
			           }
			        } catch (SQLException e) {
			            System.out.println(e.toString());
			        }
			        
				}else {
					 try {
				            DefaultTableModel modelo = new DefaultTableModel ();
				            jTable1.setModel(modelo);
				            PreparedStatement ps = null;
				            ResultSet rs= null;
				            Conexion conn = new Conexion ();
				            Connection con = conn.getConexion();
				           String sql = "SELECT id,nombre,apellidop,apellidom,CURP,lista,grado,grupo,status,ingreso,sexo FROM registro";
				           ps = con.prepareStatement(sql);
				           rs = ps.executeQuery();
				           ResultSetMetaData rsMd = rs.getMetaData();
				           int cantidadColumnas = rsMd.getColumnCount();
				           modelo.addColumn("id");
				           modelo.addColumn("nombre");
				           modelo.addColumn("apellidoP");
				           modelo.addColumn("apellidoM");
				           modelo.addColumn("CURP");
				           modelo.addColumn("lista");
				           modelo.addColumn("grado");
				           modelo.addColumn("grupo");
				           modelo.addColumn("status");
				           modelo.addColumn("ingreso");
				           modelo.addColumn("sexo");
				           while(rs.next()){
				               Object [] filas = new Object[cantidadColumnas];
				               for (int i =0;i< cantidadColumnas; i++) {
				                   filas[i] = rs.getObject(i + 1);
				               }
				               modelo.addRow(filas);
				           }
				        } catch (SQLException e) {
				            System.out.println(e.toString());
				        }
				}
					
				}
			});
	        add(d);

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setText("Buscar Alumno por:");

	        jTextField1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            }
	        });
	       for (int i=0;i<=IdU;i++){
	    	   System.out.println(i);
	       jTable1.setModel(new javax.swing.table.DefaultTableModel(
	            	new Object [][] {
	            		 {null, null, null, null},
	 	                {null, null, null, null},
	 	                {null, null, null, null},
	 	                {null, null, null, null}
	 	            },
	            new String [] {
	                "id","nombre","apellidoP","apellidoM","CURP","lista","grado","grupo","status","ingreso","sexo"
	            }
	        ));
	       }
	       
	        jScrollPane1.setViewportView(jTable1);

	        jButton1.setText("Regresar");
	        jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					PanelP pp = new PanelP(null, null, null, null, null, null, null, null);
					pp.setVisible(true);
				}
			});
			

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(41, 41, 41)
	                        .addComponent(jLabel1)
	                        .addGap(157, 157, 157)
	                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(351, 351, 351)
	                        .addComponent(jButton1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(20, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(22, 22, 22)
	                .addComponent(jButton1)
	                .addContainerGap(27, Short.MAX_VALUE))
	        );

	        pack();
	    }                       

	    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) { 
	    }	   
	    public static void main(String args[]) {
	   
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	       
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new alumnos(null).setVisible(true);
	            }
	        });
	    }
	    private int IdU;
	                 private String Nom;  
	                 private String sexo;  
	                 private String apep;  
	                 private String apm;  
	                 private String curp;  
	                 private String lista;  
	                 private String grado;  
	                 private String grupo;  
	                 private String status; 
	                 private String ingreso;
	                 private String selec;
	                 private javax.swing.JComboBox<String> jComboBox1;
	    private javax.swing.JButton jButton1;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTextField jTextField1;
}

