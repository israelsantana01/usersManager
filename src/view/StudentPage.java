package view;

import controllers.DBOperations;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Students;
import net.sf.jasperreports.engine.JRException;
import pages.StudentActions;
import report.Report;

public class StudentPage extends javax.swing.JFrame {

    String columns[] = {"Id", "Nome", "Matéria", "Ano de entrada"};
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    DBOperations operations = new DBOperations();
    ArrayList<Object[]> data = new ArrayList<>();

    public StudentPage()
    {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        load();
    }

    public void load()
    {
        this.data = this.operations.Select();
        model.setNumRows(0);

        for (Object[] DBdata : this.data) {
            this.model.addRow(DBdata);
        }

        tblData.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonAdd_ = new javax.swing.JButton();
        buttonEdit_ = new javax.swing.JButton();
        buttonDelete_ = new javax.swing.JButton();
        buttonReport_ = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        buttonRefresh_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblData.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Id", "Nome", "Matéria", "Ano de ingresso"
            }
        ));
        tblData.setRowHeight(30);
        tblData.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0)
        {
            tblData.getColumnModel().getColumn(0).setMinWidth(50);
            tblData.getColumnModel().getColumn(0).setMaxWidth(50);
            tblData.getColumnModel().getColumn(3).setMinWidth(120);
            tblData.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblSearch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSearch.setText("Pesquisa");

        txtSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        btnSearch.setText("Procurar");
        btnSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Opções");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonAdd_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/plus.png"))); // NOI18N
        buttonAdd_.setText("Incluir");
        buttonAdd_.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                buttonAdd_MouseClicked(evt);
            }
        });
        buttonAdd_.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonAdd_ActionPerformed(evt);
            }
        });

        buttonEdit_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/pencil.png"))); // NOI18N
        buttonEdit_.setText("Editar");
        buttonEdit_.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                buttonEdit_MouseClicked(evt);
            }
        });
        buttonEdit_.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonEdit_ActionPerformed(evt);
            }
        });

        buttonDelete_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/trash.png"))); // NOI18N
        buttonDelete_.setText("Deletar");
        buttonDelete_.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonDelete_ActionPerformed(evt);
            }
        });

        buttonReport_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/printer.png"))); // NOI18N
        buttonReport_.setText("Imprimir");
        buttonReport_.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonReport_ActionPerformed(evt);
            }
        });

        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profilepng.png"))); // NOI18N
        btnProfile.setText("Visualizar perfil");
        btnProfile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonAdd_, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonEdit_)
                .addGap(27, 27, 27)
                .addComponent(buttonDelete_)
                .addGap(26, 26, 26)
                .addComponent(buttonReport_)
                .addGap(18, 18, 18)
                .addComponent(btnProfile)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit_)
                    .addComponent(buttonDelete_)
                    .addComponent(buttonReport_)
                    .addComponent(btnProfile)
                    .addComponent(buttonAdd_))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        buttonRefresh_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/loading.png"))); // NOI18N
        buttonRefresh_.setText("Atualizar");
        buttonRefresh_.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                buttonRefresh_MouseClicked(evt);
            }
        });
        buttonRefresh_.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buttonRefresh_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRefresh_, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSearch)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(buttonRefresh_, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new StudentPage().setVisible(true);
            }
        });
    }

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblDataMouseClicked
    {//GEN-HEADEREND:event_tblDataMouseClicked

    }//GEN-LAST:event_tblDataMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSearchActionPerformed
    {//GEN-HEADEREND:event_btnSearchActionPerformed
        String searchTxt = txtSearch.getText();

        if (!searchTxt.isEmpty()) {
            String query = "SELECT * FROM students WHERE username LIKE '%" + searchTxt + "%'";
            DBOperations operations = new DBOperations();
            operations.searchData(query, tblData, this);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtSearchKeyReleased
    {//GEN-HEADEREND:event_txtSearchKeyReleased
        String searchTxt = txtSearch.getText();

        if (!searchTxt.isEmpty()) {
            String query = "SELECT * FROM students WHERE username LIKE '%" + searchTxt + "%'";
            DBOperations operations = new DBOperations();
            operations.searchData(query, tblData, this);
        } else {
            String query = "SELECT * FROM students";
            DBOperations operations = new DBOperations();
            operations.searchData(query, tblData, this);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void buttonAdd_MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buttonAdd_MouseClicked
    {//GEN-HEADEREND:event_buttonAdd_MouseClicked

    }//GEN-LAST:event_buttonAdd_MouseClicked

    private void buttonRefresh_MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buttonRefresh_MouseClicked
    {//GEN-HEADEREND:event_buttonRefresh_MouseClicked

    }//GEN-LAST:event_buttonRefresh_MouseClicked

    private void buttonRefresh_ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonRefresh_ActionPerformed
    {//GEN-HEADEREND:event_buttonRefresh_ActionPerformed
        this.data = this.operations.Select();
        model.setNumRows(0);

        for (Object[] DBdata : this.data) {
            this.model.addRow(DBdata);
        }

        tblData.setModel(model);
    }//GEN-LAST:event_buttonRefresh_ActionPerformed

    private void buttonEdit_ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonEdit_ActionPerformed
    {//GEN-HEADEREND:event_buttonEdit_ActionPerformed
        if (!tblData.getSelectionModel().isSelectionEmpty()) {
            Students selectedStudent = new Students(
                    tblData.getValueAt(tblData.getSelectedRow(), 1).toString(),
                    tblData.getValueAt(tblData.getSelectedRow(), 2).toString(),
                    Integer.parseInt(tblData.getValueAt(tblData.getSelectedRow(), 3).toString())
            );
            
            int selectedStudentId = Integer.parseInt(
                    tblData.getValueAt(tblData.getSelectedRow(), 0).toString()
            );
            selectedStudent.setId(selectedStudentId);
            
            StudentActions addStudent = new StudentActions(
                    new javax.swing.JFrame(), 
                    "EDIT", selectedStudent
            );
            addStudent.setVisible(true);
            addStudent.toFront();
        } else {
            JOptionPane.showMessageDialog(this, "Erro: Selecione um item");
        }

        /*
        Students itemSelected = new Students(
                tblData.getValueAt(tblData.getSelectedRow(), 1).toString(),
                tblData.getValueAt(tblData.getSelectedRow(), 2).toString(),
                Integer.parseInt(tblData.getValueAt(tblData.getSelectedRow(), 3).toString())
        );
         */
        //operations.getImage(tblData.getValueAt(tblData.getSelectedRow(), 0).toString());
        /*EditStudent editPage = new EditStudent(
                new javax.swing.JFrame(),
                itemSelected,
                Integer.parseInt(tblData.getValueAt(tblData.getSelectedRow(), 0).toString())
        );
        editPage.setVisible(true);
        editPage.toFront();*/
    }//GEN-LAST:event_buttonEdit_ActionPerformed

    private void buttonAdd_ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonAdd_ActionPerformed
    {//GEN-HEADEREND:event_buttonAdd_ActionPerformed
        Students emptyStudent = new Students();
        StudentActions addStudent = new StudentActions(new javax.swing.JFrame(), "ADD", emptyStudent);
        addStudent.setVisible(true);
        addStudent.toFront();
    }//GEN-LAST:event_buttonAdd_ActionPerformed

    private void buttonEdit_MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_buttonEdit_MouseClicked
    {//GEN-HEADEREND:event_buttonEdit_MouseClicked

    }//GEN-LAST:event_buttonEdit_MouseClicked

    private void buttonDelete_ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonDelete_ActionPerformed
    {//GEN-HEADEREND:event_buttonDelete_ActionPerformed
        if (!tblData.getSelectionModel().isSelectionEmpty()) {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja deletar o estudante?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (response == JOptionPane.YES_OPTION) {
                DBOperations operations = new DBOperations();
                Students student = new Students();

                student.setId(
                        Integer.parseInt(
                                tblData.getValueAt(tblData.getSelectedRow(), 0)
                                        .toString()
                        )
                );
                student.setUsername(
                        tblData.getValueAt(tblData.getSelectedRow(), 1).toString()
                );
                student.setSubject(
                        tblData.getValueAt(tblData.getSelectedRow(), 2).toString()
                );
                student.setYear_of_entry(
                        Integer.parseInt(
                                tblData.getValueAt(tblData.getSelectedRow(), 3)
                                        .toString()
                        )
                );
                operations.Delete(student);

            } else if (response == JOptionPane.NO_OPTION) {
                JOptionPane.getRootFrame().dispose();
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "ERRO: Selecione pelo menos um estudante"
            );
        }

    }//GEN-LAST:event_buttonDelete_ActionPerformed

    private void buttonReport_ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buttonReport_ActionPerformed
    {//GEN-HEADEREND:event_buttonReport_ActionPerformed
        if (!tblData.getSelectionModel().isSelectionEmpty()) {
            ArrayList<Students> student = new ArrayList<>();
            Students item = new Students();
            Report report = new Report();

            item.setId(Integer.parseInt(tblData.getValueAt(tblData.getSelectedRow(), 0).toString()));
            item.setUsername(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
            item.setSubject(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
            item.setYear_of_entry(Integer.parseInt(tblData.getValueAt(tblData.getSelectedRow(), 3).toString()));

            student.add(item);

            try {
                report.generateReport(student);
            } catch (JRException error) {
                error.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "ERRO: Selecione pelo menos um estudante"
            );
        }
    }//GEN-LAST:event_buttonReport_ActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProfileActionPerformed
    {//GEN-HEADEREND:event_btnProfileActionPerformed
        if (!tblData.getSelectionModel().isSelectionEmpty()) {
            
            String id = tblData.getValueAt(tblData.getSelectedRow(), 0).toString();
            String pathImage = operations.getImage(id);

            try {
                java.awt.Desktop.getDesktop().open(
                        new File(pathImage + id + ".jpeg")
                );
            } catch (IOException ex) {
                Logger.getLogger(StudentPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos um usuário!");
        }

    }//GEN-LAST:event_btnProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton buttonAdd_;
    private javax.swing.JButton buttonDelete_;
    private javax.swing.JButton buttonEdit_;
    private javax.swing.JButton buttonRefresh_;
    private javax.swing.JButton buttonReport_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    public javax.swing.JTable tblData;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void setVisible(int NORMAL)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
