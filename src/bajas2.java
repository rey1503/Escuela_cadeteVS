import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class bajas2 extends javax.swing.JFrame {
	    public bajas2() {
	        initComponents();
	        try { 
	        	DefaultTableModel modelo = new DefaultTableModel ();
	        	jTable1.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT id,nombre,apellidop,apellidom,calificacion,lista,grado,grupo,status,asignatura,parcial,motivob FROM registro";
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
	           modelo.addColumn("motivo baja");
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
	    	 jLabel1 = new javax.swing.JLabel();
	         jLabel2 = new javax.swing.JLabel();
	         jTextField1 = new javax.swing.JTextField();
	         jLabel3 = new javax.swing.JLabel();
	         jScrollPane1 = new javax.swing.JScrollPane();
	         jEditorPane1 = new javax.swing.JEditorPane();
	         jButton1 = new javax.swing.JButton();
	         jButton2 = new javax.swing.JButton();
	         jButton3 = new javax.swing.JButton();
	         jScrollPane2 = new javax.swing.JScrollPane();
	         jTable1 = new javax.swing.JTable();
	         jLabel5 = new javax.swing.JLabel();
	         jTextField2 = new javax.swing.JTextField();

	         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	         jLabel1.setText("Bajas");

	         jLabel2.setText("Buscar Alumno con id:");

	         jLabel3.setText("Motivo:");

	         jScrollPane1.setViewportView(jEditorPane1);

	         jButton1.setText("Guardar");

	         jButton2.setText("Regresar");
	         
				 jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							setVisible(false);
							PanelP pp = new PanelP(null, null, null, null, null, null,null,null);
							pp.setVisible(true);
						}
					});
	         jButton3.setText("Buscar");
	         jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent q) {
	
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

	         jLabel5.setText("Aplicar baja para Alumno con id=");

	         jTextField2.addActionListener(new java.awt.event.ActionListener() {
	             public void actionPerformed(java.awt.event.ActionEvent evt) {
	                 jTextField2ActionPerformed(evt);
	             }
	         });
	         
	         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	         getContentPane().setLayout(layout);
	         layout.setHorizontalGroup(
	             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jLabel1)
	                 .addContainerGap())
	             .addGroup(layout.createSequentialGroup()
	                 .addGap(38, 38, 38)
	                 .addComponent(jLabel5)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                 .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jButton2)
	                 .addGap(135, 135, 135))
	             .addGroup(layout.createSequentialGroup()
	                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                     .addGroup(layout.createSequentialGroup()
	                         .addGap(108, 108, 108)
	                         .addComponent(jLabel2)
	                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                         .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
	                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                         .addComponent(jButton3))
	                     .addGroup(layout.createSequentialGroup()
	                         .addGap(20, 20, 20)
	                         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE))
	                     .addGroup(layout.createSequentialGroup()
	                         .addContainerGap()
	                         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                             .addGroup(layout.createSequentialGroup()
	                                 .addGap(12, 12, 12)
	                                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))
	                             .addComponent(jLabel3))))
	                 .addContainerGap(22, Short.MAX_VALUE))
	         );
	         layout.setVerticalGroup(
	             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	             .addGroup(layout.createSequentialGroup()
	                 .addGap(8, 8, 8)
	                 .addComponent(jLabel1)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                     .addComponent(jLabel2)
	                     .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addComponent(jButton3))
	                 .addGap(18, 18, 18)
	                 .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                 .addComponent(jLabel3)
	                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
	                 .addGap(36, 36, 36)
	                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                     .addComponent(jLabel5)
	                     .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                     .addComponent(jButton1)
	                     .addComponent(jButton2))
	                 .addGap(54, 54, 54))
	         );

	         jLabel5.getAccessibleContext().setAccessibleName("Aplicar baja para alumno con id=");

	         pack();
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
	             java.util.logging.Logger.getLogger(bajas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	         } catch (InstantiationException ex) {
	             java.util.logging.Logger.getLogger(bajas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	         } catch (IllegalAccessException ex) {
	             java.util.logging.Logger.getLogger(bajas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	             java.util.logging.Logger.getLogger(bajas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	         }
	  
	         java.awt.EventQueue.invokeLater(new Runnable() {
	             public void run() {
	                 new bajas2().setVisible(true);
	             }
	         });
	     }
                  
	     private javax.swing.JButton jButton1;
	     private javax.swing.JButton jButton2;
	     private javax.swing.JButton jButton3;
	     private javax.swing.JEditorPane jEditorPane1;
	     private javax.swing.JLabel jLabel1;
	     private javax.swing.JLabel jLabel2;
	     private javax.swing.JLabel jLabel3;
	     private javax.swing.JLabel jLabel5;
	     private javax.swing.JScrollPane jScrollPane1;
	     private javax.swing.JScrollPane jScrollPane2;
	     private javax.swing.JTable jTable1;
	     private javax.swing.JTextField jTextField1;
	     private javax.swing.JTextField jTextField2;
                  
	 }