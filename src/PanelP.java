import javax.swing.JFrame;

public class PanelP  extends javax.swing.JFrame {
	static JFrame alumnos;
	static JFrame Aprobados;
	static JFrame bajas2;
	static JFrame Notas2;
	static JFrame pendientes2;
	static JFrame Reprobados;
	static JFrame AgregarAlumno;
	static JFrame Calificaciones2;
	
	    public PanelP(JFrame alumnos, JFrame Aprobados,JFrame bajas2,JFrame Calificaciones2,JFrame Notas2,JFrame pendientes2,JFrame Reprobados,JFrame AgregarAlumno) {
	    	this.alumnos=alumnos;
	    	this.Aprobados=Aprobados;
	    	this.bajas2=bajas2;
	    	this.Calificaciones2=Calificaciones2;
	    	this.Notas2=Notas2;
	    	this.pendientes2=pendientes2;
	    	this.Reprobados=Reprobados;
	    	this.AgregarAlumno=AgregarAlumno;
	        initComponents();
	    }                     
	    private void initComponents() {
	    	this.setResizable(false);
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jButton8 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jButton9 = new javax.swing.JButton();
	        jButton10 = new javax.swing.JButton();
	        jButton11 = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        salida = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jButton1.setText("Alumnos");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	setVisible(false);
	            	alumnos alu=new alumnos(null);
		 			alu.setVisible(true);
	            }
	        });

	        jButton2.setText("<html>Agregar alumno<html>");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	setVisible(false);
	            	AgregarAlumno agr=new AgregarAlumno(null);
		 			agr.setVisible(true);
	            }
	        });
	        salida.setText("Salir");
	        salida.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	setVisible(false);
	            	Login ba=new Login(null);
	            	 ba.setVisible(true);
	               
	            }
	        });

	        jButton3.setText("Calificaciones");
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	        	 public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	 setVisible(false);
	        	 Calificaciones2 cal=new Calificaciones2(null);
	 			cal.setVisible(true);
	        	 }
	        });
	        

	        jButton4.setText("Pendientes");
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 setVisible(false);
	            	 pendientes2 pe=new pendientes2();
		 			pe.setVisible(true);
	            }
	        });

	        jButton5.setText("Aprobados");
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            setVisible(false);
	            Aprobados apr=new Aprobados(null);
           	 apr.setVisible(true);
	            }
	            });

	        jButton6.setText("Reprobados");
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 setVisible(false);
	            	 Reprobados rep=new Reprobados(null);
	            	 rep.setVisible(true);
	            	
	            }
	            });

	        jButton8.setText("Bajas");
	        jButton8.setActionCommand("Bajas");
	        jButton8.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	setVisible(false);
	            	bajas2 ba=new bajas2();
	            	 ba.setVisible(true);
	            }
	        });

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);

	        jButton9.setText("Notas");
	        jButton9.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 setVisible(false);
	            	 Notas2 not=new Notas2();
	            	 not.setVisible(true);
	            }
	        });

	        jButton10.setText("Calendario");

	        jButton11.setText("Guardar como nota");
	        jLabel1.setText("BIENVENID@");
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                .addComponent(jButton1)
	                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addComponent(jButton5))
	                        .addGap(32, 32, 32)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(0, 3, Short.MAX_VALUE)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(jButton10)
	                                            .addComponent(jButton9))
	                                        .addGap(6, 6, 6))))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jButton4)
	                                .addGap(0, 0, Short.MAX_VALUE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(jButton11)
	                        .addGap(227, 227, 227)
	                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addGap(30, 30, 30))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(367, 367, 367)
	                .addComponent(jLabel1)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(5, 5, 5)
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jScrollPane1)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(14, 14, 14)
	                                .addComponent(jButton1)
	                                .addGap(37, 37, 37)
	                                .addComponent(jButton3))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(63, 63, 63)
	                                .addComponent(jButton4)))
	                        .addGap(61, 61, 61)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jButton9)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(jButton10)
	                                .addGap(53, 53, 53))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jButton5)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
	                                .addComponent(jButton6)
	                                .addGap(65, 65, 65)))))
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(jButton11)
	                        .addComponent(jButton8))
	                    .addComponent(salida))
	                .addContainerGap())
	        );

	        pack();
	    }                    

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent a) {                                         
	    	this.setVisible(false);
			alumnos al=new alumnos(null);
			al.setVisible(true);
	    }                                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent e) {                                         
	        
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent i) {                                         
	    	this.setVisible(false);
	    	pendientes2 pen=new pendientes2();
	    	pen.setVisible(true);
	    }                                        

	    private void jButton8ActionPerformed(java.awt.event.ActionEvent o) {                                         
	      
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
	            java.util.logging.Logger.getLogger(PanelP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(PanelP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(PanelP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(PanelP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	new PanelP(null, null, null, null, null, null, null,null).setVisible(true);
	            }
	        });
	    }
                 
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton salida;
	    private javax.swing.JButton jButton10;
	    private javax.swing.JButton jButton11;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JButton jButton8;
	    private javax.swing.JButton jButton9;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextArea jTextArea1;
	                   
	}
