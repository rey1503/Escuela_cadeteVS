import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Calificaciones2 extends javax.swing.JFrame {
	static JFrame PanelP;
    public Calificaciones2(JFrame PanelP) {
    	this.PanelP=PanelP;initComponents();
    	try { 
        	DefaultTableModel modelo = new DefaultTableModel ();
        	jTable1.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs= null;
            Conexion conn = new Conexion ();
            Connection con = conn.getConexion();
           String sql = "SELECT id,nombre,apellidop,apellidom,calificacion,lista,grado,grupo,status,asignatura,parcial FROM registro";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           ResultSetMetaData rsMd = rs.getMetaData();
           int cantidadColumnas = rsMd.getColumnCount();
           modelo.addColumn("id");
           modelo.addColumn("nombre");
           modelo.addColumn("apellidoP");
           modelo.addColumn("apellidoM");
           modelo.addColumn("calificacion");
           modelo.addColumn("lista");
           modelo.addColumn("grado");
           modelo.addColumn("grupo");
           modelo.addColumn("status");
           modelo.addColumn("asignatura");
           modelo.addColumn("parcial");
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
       // buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();//calificacion
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextField3 = new javax.swing.JTextField();//asignatura
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Buscar Alumno por id :");
        jLabel2.setText("Calificacion:");
        jLabel4.setText("Parciales:");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jComboBox1.addItem("Parcial 1");
        jComboBox1.addItem("Parcial 2");
        jComboBox1.addItem("Parcial 3");
        jComboBox1.addItem("Parcial 4");
        jComboBox1.addItem("Parcial 5");
        jComboBox1.addItem("Parcial 6");
        jComboBox1.setSelectedItem(null);
        jLabel5.setText("Status:");
        jRadioButton1.setText("Aprobado");
        jRadioButton2.setText("Reprobado");
        jButton2.setText("Guardar");
        jButton3.setText("Regresar");
        jButton3.setActionCommand("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        g5=new JLabel("Aplicar cambios para alumno con id=");
        g5.setBounds(170, 210, 300, 200);
        add(g5);
        cam=new JTextField();
        cam.setBounds(430, 299, 50, 30);
        add(cam);
        
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent q) {
				Sqlusuarios modSql = new Sqlusuarios();
				Cali cl = new Cali ();
				String gtr =(String)jComboBox1.getSelectedItem();
				double za=Double.parseDouble(jTextField1.getText());
				int zaz=Integer.parseInt(cam.getText());
				if (!(za==0) && !jTextField3.getText().equals("") && !gtr.equals("")) {
					cl.setCalificacion(za);
					cl.setAsignatura(jTextField3.getText());
					cl.setParcial(gtr);
					cl.setId(zaz);
					if(modSql.califi(cl)){
						JOptionPane.showMessageDialog(null, "GUARDADO");
						jTextField1.setText(" ");
						jTextField3.setText(" ");
						PanelP l=new PanelP(null, null, null, null, null, null, null,null);
						l.setVisible(true);
						setVisible(false);
						
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo procesar la peticion");
						jTextField1.setText(" ");
						jTextField3.setText(" ");
						
					}
				}else {
					
					JOptionPane.showMessageDialog(null, "ingresa el texto");
					jTextField1.setText(" ");
					jTextField3.setText(" ");	
			}
			}
		});
        jButton4.setText("Buscar");
        jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent z) {
				String bus = jTextField2.getText();
		        if (!"".equals(bus)){
		        	String  where =("SELECT id,nombre,apellidop,apellidom,calificacion,lista,grado,grupo,status,asignatura,parcial FROM registro WHERE id='"+bus+"'");
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
		           modelo.addColumn("calificacion");
		           modelo.addColumn("lista");
		           modelo.addColumn("grado");
		           modelo.addColumn("grupo");
		           modelo.addColumn("status");
		           modelo.addColumn("asignatura");
		           modelo.addColumn("parcial");
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
			            String sql = "SELECT id,nombre,apellidop,apellidom,calificacion,lista,grado,grupo,status,asignatura,parcial FROM registro";
			           ps = con.prepareStatement(sql);
			           rs = ps.executeQuery();
			           ResultSetMetaData rsMd = rs.getMetaData();
			           int cantidadColumnas = rsMd.getColumnCount();
			           modelo.addColumn("id");
			           modelo.addColumn("nombre");
			           modelo.addColumn("apellidoP");
			           modelo.addColumn("apellidoM");
			           modelo.addColumn("calificacion");
			           modelo.addColumn("lista");
			           modelo.addColumn("grado");
			           modelo.addColumn("grupo");
			           modelo.addColumn("status");
			           modelo.addColumn("asignatura");
			           modelo.addColumn("parcial");
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
    
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jLabel3.setText("Asignatura");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(47, 47, 47))
        );

        pack();
    }                        
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
    }                                          

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	setVisible(false);
		PanelP pp = new PanelP(null, null, null, null, null, null, null,null);
		pp.setVisible(true);
    }                                        
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {   
    	
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
            java.util.logging.Logger.getLogger(Calificaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calificaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calificaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calificaciones2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calificaciones2(null).setVisible(true);
            }
        });
    }                
   // private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private JTextField cam;
    private JLabel g5;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private  javax.swing.JTextField jTextField2;
}