

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import javax.swing.table.DefaultTableModel;
	public class validacion extends javax.swing.JFrame {
	    public validacion() {
	        initComponents();
	        try {
	            DefaultTableModel modelo = new DefaultTableModel ();
	            JTmodelo.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT * FROM registro";
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           ResultSetMetaData rsMd = rs.getMetaData();
	           int cantidadColumnas = rsMd.getColumnCount();
	           modelo.addColumn("Codigo");
	           modelo.addColumn("nombre");
	           modelo.addColumn("precio");
	           modelo.addColumn("cantidad");
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
	    private void initComponents() {

	        jScrollPane1 = new javax.swing.JScrollPane();
	        JTmodelo = new javax.swing.JTable();
	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        Buscar = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        JTmodelo.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "codigo", "nombre", "precio", "cantidad"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        jScrollPane1.setViewportView(JTmodelo);

	        jLabel1.setText("Buscar");

	        Buscar.setText("Buscar");
	        Buscar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                BuscarActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(33, 33, 33)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(32, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addGap(41, 41, 41)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(75, 75, 75))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(2, 2, 2)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel1)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Buscar))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(42, Short.MAX_VALUE))
	        );

	        pack();
	    }

	    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {                                       
	        // TODO add your handling code here:
	        String bus = Buscar.getText();
	        String where = "";
	        if (!"".equals(bus)){
	            where = "WHERE id = " + bus + "'";
	               try {
	            DefaultTableModel modelo = new DefaultTableModel ();
	            JTmodelo.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs= null;
	            Conexion conn = new Conexion ();
	            Connection con = conn.getConexion();
	           String sql = "SELECT * FROM registro" + where;
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           ResultSetMetaData rsMd = rs.getMetaData();
	           int cantidadColumnas = rsMd.getColumnCount();
	           modelo.addColumn("Codigo");
	           modelo.addColumn("nombre");
	           modelo.addColumn("precio");
	           modelo.addColumn("cantidad");
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
	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(validacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new validacion().setVisible(true);
	            }
	        });
	    }
	    private javax.swing.JButton Buscar;
	    private javax.swing.JTable JTmodelo;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextField jTextField1;
	}


