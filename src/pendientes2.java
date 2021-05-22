import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class pendientes2  extends javax.swing.JFrame {
	static JFrame PanelP;
	    public pendientes2() {
	    	this.PanelP=PanelP;
	        initComponents();
	        try { 
	        	DefaultTableModel modelo = new DefaultTableModel ();
	        	jTable1.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT id,pendiente FROM pendientes";
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           ResultSetMetaData rsMd = rs.getMetaData();
	           int cantidadColumnas = rsMd.getColumnCount();
	           modelo.addColumn("id");
	           modelo.addColumn("pendientes");
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
	        jButton1 = new javax.swing.JButton();
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jButton2 = new javax.swing.JButton();
	        jLabel2 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jButton3 = new javax.swing.JButton();
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        jLabel1.setText("Pendientes");
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
	        jButton1.setText("Regresar");
	        jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					PanelP pp = new PanelP(null, null, null, null, null, null,null,null);
					pp.setVisible(true);
			        
				}
			});
	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane2.setViewportView(jTextArea1);
	        jButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ox) {
					int zaz=Integer.parseInt(jTextField1.getText());
					Sqlusuarios modSql = new Sqlusuarios();
					Borrado pp = new Borrado ();
	    			if (0!=zaz) {
	    				String borro =("DELETE FROM pendientes WHERE id='"+zaz+"'");
	    				pp.setId(zaz);
	    				if(modSql.Bo(pp)) {
	    					JOptionPane.showMessageDialog(null, "Borrado");
	    					jTextArea1.setText(" ");
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
	        jButton2.setText("<html>Agregar nuevo pendiente <html>");
	        jButton2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Sqlusuarios modSql = new Sqlusuarios();
	    	    	Pend pp = new Pend ();
	    			if (!jTextArea1.getText().equals("")) {
	    				pp.setPendiente(jTextArea1.getText());
	    				if(modSql.pen(pp)) {
	    					JOptionPane.showMessageDialog(null, "GUARDADO");
	    					jTextArea1.setText(" ");
	    					
	    					PanelP l=new PanelP(null, null, null, null, null, null, null, null);
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
	        jLabel2.setText("Borrar pendiente con id");
	        jButton3.setText("Borrar");
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(35, 35, 35)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(12, 12, 12)
	                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(131, 131, 131)
	                                .addComponent(jLabel2))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(383, 383, 383)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jLabel1))))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jButton3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jButton1)))
	                .addGap(40, 40, 40))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(32, 32, 32)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton1)
	                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGap(34, 34, 34))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel2)
	                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton3))
	                        .addGap(39, 39, 39))))
	        );

	        pack();
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
	            java.util.logging.Logger.getLogger(pendientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(pendientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(pendientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(pendientes2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new pendientes2().setVisible(true);
	            }
	        });
	    }
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextField jTextField1;                 
	}

