/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedsim.gui;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import schedsim.Process;
import schedsim.Scheduler.Algorithm;

/**
 *
 * @author francisco
 */
public class SchedSim extends javax.swing.JFrame {

	private DefaultTableModel tModel = null;
	private int pid = 0;
	private int lastTime = 0;
	private final int processLimit = 14;

	/**
	 * Creates new form SchedSim
	 */
	public SchedSim() {
		initComponents();
		tModel = (DefaultTableModel) tProcesses.getModel();
		//http://stackoverflow.com/questions/7440439/easy-multicolored-text-in-java
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCreate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ftfBurst = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        ftfTime = new javax.swing.JFormattedTextField();
        bCreate = new javax.swing.JButton();
        lPriority = new javax.swing.JLabel();
        ftfPriority = new javax.swing.JFormattedTextField();
        cbAlgorithm = new javax.swing.JComboBox();
        bStart = new javax.swing.JButton();
        spTable = new javax.swing.JScrollPane();
        tProcesses = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SchedSim: Simulador de Algoritmos de Escalonamento de CPU");

        pCreate.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar processos"));

        jLabel1.setText("Tempo de burst");

        ftfBurst.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftfBurst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfBurstActionPerformed(evt);
            }
        });
        ftfBurst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfBurstKeyReleased(evt);
            }
        });

        jLabel2.setText("Tempo de chegada");

        ftfTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftfTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTimeActionPerformed(evt);
            }
        });
        ftfTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfTimeKeyReleased(evt);
            }
        });

        bCreate.setText("Criar");
        bCreate.setEnabled(false);
        bCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateActionPerformed(evt);
            }
        });

        lPriority.setText("Prioridade (opcional)");

        ftfPriority.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftfPriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfPriorityActionPerformed(evt);
            }
        });
        ftfPriority.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfPriorityKeyReleased(evt);
            }
        });

        cbAlgorithm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FCFS", "SJF", "Prioridades", "RoundRobin" }));
        cbAlgorithm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlgorithmActionPerformed(evt);
            }
        });

        bStart.setText("Iniciar");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCreateLayout = new javax.swing.GroupLayout(pCreate);
        pCreate.setLayout(pCreateLayout);
        pCreateLayout.setHorizontalGroup(
            pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCreateLayout.createSequentialGroup()
                        .addComponent(ftfBurst, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(bCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pCreateLayout.createSequentialGroup()
                        .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pCreateLayout.createSequentialGroup()
                                .addComponent(ftfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(pCreateLayout.createSequentialGroup()
                                .addComponent(ftfPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lPriority)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbAlgorithm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pCreateLayout.setVerticalGroup(
            pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCreateLayout.createSequentialGroup()
                        .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ftfBurst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ftfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lPriority)
                            .addComponent(ftfPriority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pCreateLayout.createSequentialGroup()
                        .addComponent(bCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStart)))
                .addContainerGap())
        );

        spTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Processos"));

        tProcesses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Processo", "Chegada", "Burst", "Prioridade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        tProcesses.setEnabled(false);
        tProcesses.setFocusable(false);
        tProcesses.getTableHeader().setReorderingAllowed(false);
        spTable.setViewportView(tProcesses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ftfBurstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfBurstActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_ftfBurstActionPerformed

    private void ftfBurstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfBurstKeyReleased
		checkBurstAndTime();
    }//GEN-LAST:event_ftfBurstKeyReleased

    private void ftfTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTimeActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_ftfTimeActionPerformed

    private void ftfTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfTimeKeyReleased
		checkBurstAndTime();
    }//GEN-LAST:event_ftfTimeKeyReleased

    private void bCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateActionPerformed
		int burst = parseInt(ftfBurst.getText());
		int time = parseInt(ftfTime.getText());
		int priority = 0;

		String priorityText = ftfPriority.getText();

		if (!priorityText.equals("")) {
			priority = parseInt(priorityText);
		}

		if (burst <= 0) {
			String msg = "Burst deve ser maior que zero";
			JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (time < lastTime) {
			String msg = "Tempo de chegada deve ser maior que " + lastTime;
			JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (pid < processLimit) {
			Process process;
			process = new Process(pid, burst, time, priority);

			lastTime = time;
			//drawProcesses(scheduler.getReadyQueue());
			tModel.addRow(new Object[]{"P" + pid, time, burst, priority});
			pid++;
		} else {
			String msg = "Limite de processos: " + processLimit;
			JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_bCreateActionPerformed

    private void ftfPriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfPriorityActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_ftfPriorityActionPerformed

    private void ftfPriorityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfPriorityKeyReleased
		// TODO add your handling code here:
    }//GEN-LAST:event_ftfPriorityKeyReleased

    private void cbAlgorithmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlgorithmActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_cbAlgorithmActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed

		switch (cbAlgorithm.getSelectedIndex()) {
			case 0:
				new FScheduler(null, Algorithm.FCFS).setVisible(true);
				break;
			case 1:
				new FScheduler(null, Algorithm.SJF).setVisible(true);
				break;
			case 2:
				new FScheduler(null, Algorithm.Priorities).setVisible(true);
				break;
			case 3:
				new FScheduler(null, Algorithm.RoundRobin).setVisible(true);
				break;
		}
    }//GEN-LAST:event_bStartActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SchedSim.class
				.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SchedSim().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCreate;
    private javax.swing.JButton bStart;
    private javax.swing.JComboBox cbAlgorithm;
    private javax.swing.JFormattedTextField ftfBurst;
    private javax.swing.JFormattedTextField ftfPriority;
    private javax.swing.JFormattedTextField ftfTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lPriority;
    private javax.swing.JPanel pCreate;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable tProcesses;
    // End of variables declaration//GEN-END:variables

	private void checkBurstAndTime() {

		boolean isBurstFilled = ftfBurst.getText().length() > 0;
		boolean isTimeFilled = ftfTime.getText().length() > 0;

		if (ftfBurst.isEditValid() && ftfTime.isEditValid() && isBurstFilled && isTimeFilled) {
			bCreate.setEnabled(true);
		} else {
			bCreate.setEnabled(false);
		}
	}
}