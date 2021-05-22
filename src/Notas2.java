import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Notas2 extends javax.swing.JFrame {
	    public Notas2() {
	        initComponents();
	        try { 
	        	DefaultTableModel modelo = new DefaultTableModel ();
	        	jTable1.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT id,notass FROM notas;";
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           ResultSetMetaData rsMd = rs.getMetaData();
	           int cantidadColumnas = rsMd.getColumnCount();
	           modelo.addColumn("id");
	           modelo.addColumn("notas");
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
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        jLabel1.setText("Notas ");
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
	        jScrollPane1.setViewportView(jTable1);
	        jButton2.setText("Borrar");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	int zaz=Integer.parseInt(jTextField1.getText());
					Sqlusuarios modSql = new Sqlusuarios();
					borras xx = new borras ();
	    			if (0!=zaz) {
	    				String borro =("DELETE FROM notas WHERE id='"+zaz+"'");
	    				xx.setId(zaz);
	    				if(modSql.Boo(xx)) {
	    					JOptionPane.showMessageDialog(null, "Borrado");
	    					jTextField1.setText(" ");
	    					PanelP l=new PanelP(null, null, null, null, null, null,null, null);
	    					l.setVisible(true);
	    					setVisible(false);
	    				}
	    				else {
	    					JOptionPane.showMessageDialog(null, "No se pudo procesar la peticion");
	    					jTextField1.setText(" ");
	    					
	    				}
	    			}
	            }
	        });
	        jButton3.setText("Regresar");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jLabel2.setText("Borrar Nota por id:");
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(309, 309, 309)
	                .addComponent(jLabel1)
	                .addContainerGap(516, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(76, 76, 76)
	                .addComponent(jLabel2)
	                .addGap(18, 18, 18)
	                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jButton2)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jButton3)
	                .addGap(213, 213, 213))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton3)
	                    .addComponent(jButton2)
	                    .addComponent(jLabel2)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(51, 51, 51))
	        );

	        pack();
	    }                     
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    }                                        
	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	setVisible(false);
			PanelP pp = new PanelP(null, null, null, null, null, null, null, null);
			pp.setVisible(true);
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
	            java.util.logging.Logger.getLogger(Notas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Notas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Notas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Notas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Notas2().setVisible(true);
	            }
	        });
	    }                  
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTextField jTextField1;                
	}


