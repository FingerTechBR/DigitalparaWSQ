import com.nitgen.SDK.BSP.NBioBSPJNI;

public class NBioAPI_WSQDemo extends javax.swing.JDialog {

    /** Creates new form NBioAPI_WSQDemo */
    public NBioAPI_WSQDemo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                Closing();
                System.exit(0);
            }
        });

        bsp = new NBioBSPJNI();

        if (CheckError())
            return ;

        exportEngine = bsp.new Export();

        if (CheckError())
            return ;

        setTitle("NBioAPI_WSQDemo BSP version: " + bsp.GetVersion());

        bsp.OpenDevice();

        if (CheckError())
            return ;

        btnMakeWSQ.setEnabled(true);
    }

    public void dispose()
    {
        if (hWSQFIR1 != null)  {
            hWSQFIR1.dispose();
            hWSQFIR1 = null;
        }

        if (hWSQFIR2 != null)  {
            hWSQFIR2.dispose();
            hWSQFIR2 = null;
        }

        if (bsp != null) {
            bsp.CloseDevice();
            bsp.dispose();
            bsp = null;
        }
    }

    public void Closing()
    {
        dispose();
    }

    private Boolean CheckError()
    {
        if (bsp.IsErrorOccured())  {
            javax.swing.JOptionPane.showMessageDialog(null, "NBioBSP Error Occured [" + bsp.GetErrorCode() + "]");
            return true;
        }

        return false;
    }

    private Boolean WriteFile(String fileName, byte[] data)
    {
        java.io.File newFile = new java.io.File(fileName);
        java.io.DataOutputStream out;

        try  {
            out = new java.io.DataOutputStream(new java.io.FileOutputStream(newFile, false));
        }
        catch (java.io.FileNotFoundException ex)  {
            javax.swing.JOptionPane.showMessageDialog(null, "File Creat failed!!");
            return false;
        }

        try  {
            out.write(data);
            out.close();
        }
        catch (java.io.IOException e)  {
            javax.swing.JOptionPane.showMessageDialog(null, "File Write failed!!");
            return false;
        }

        return true;
    }

   
    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMakeWSQ = new javax.swing.JButton();
        btnSaveWSQ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnLoad1 = new javax.swing.JButton();
        btnLoad2 = new javax.swing.JButton();
        btnMatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Make WSQ"));

        btnMakeWSQ.setText("Capture & Make WSQ Data");
        btnMakeWSQ.setEnabled(false);
        btnMakeWSQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeWSQActionPerformed(evt);
            }
        });

        btnSaveWSQ.setText("Save WSQ Data");
        btnSaveWSQ.setEnabled(false);
        btnSaveWSQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveWSQActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnMakeWSQ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 257, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnSaveWSQ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 257, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnMakeWSQ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnSaveWSQ, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Matching WSQ"));

        btnLoad1.setText("Load WSQ Data[1]");
        btnLoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoad1ActionPerformed(evt);
            }
        });

        btnLoad2.setText("Load WSQ Data[2]");
        btnLoad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoad2ActionPerformed(evt);
            }
        });

        btnMatch.setText("Matching");
        btnMatch.setEnabled(false);
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnLoad1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnLoad2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnMatch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnLoad1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLoad2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnMatch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMakeWSQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeWSQActionPerformed
        NBioBSPJNI.FIR_HANDLE       hSavedFIR;
        NBioBSPJNI.FIR_HANDLE       hSavedAuditFIR;

        hSavedFIR = bsp.new FIR_HANDLE();
        hSavedAuditFIR = bsp.new FIR_HANDLE();

        bsp.Capture(NBioBSPJNI.FIR_PURPOSE.VERIFY, hSavedFIR, -1, hSavedAuditFIR, null);

        if (CheckError())
            return ;

        if (hSavedAuditFIR != null)  {
            NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();

            inputFIR.SetFIRHandle(hSavedAuditFIR);

            NBioBSPJNI.Export.AUDIT exportAudit = exportEngine.new AUDIT();

            exportEngine.ExportAudit(inputFIR, exportAudit);

            if (CheckError())
                return ;

            float fQuality = 0.7f;

            if (SaveWSQData != null)
                SaveWSQData = null;

            SaveWSQData = exportEngine.new TEMPLATE_DATA();
            exportEngine.ConvertRawToWsq(exportAudit.FingerData[0].Template[0].Data , exportAudit.ImageWidth, exportAudit.ImageHeight, SaveWSQData, fQuality);

            if (CheckError())
                return ;

            btnSaveWSQ.setEnabled(true);
            javax.swing.JOptionPane.showMessageDialog(null, "Make WSQ Data Success");
        }
    }//GEN-LAST:event_btnMakeWSQActionPerformed

    private void btnSaveWSQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveWSQActionPerformed
        if (SaveWSQData != null)  {
            javax.swing.JFileChooser fs = new javax.swing.JFileChooser();

            fs.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
            fs.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));
            fs.setFileFilter(new javax.swing.filechooser.FileFilter() {
                public boolean accept(java.io.File f) {
                    return f.getName().toUpperCase().endsWith(".wsq") || f.isDirectory();
                }

                public String getDescription() {
                    return "WSQ Image data";
                }
            });
            fs.setMultiSelectionEnabled(false);
            fs.setDialogTitle("Save WSQ Image Data");
            fs.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);

            if (fs.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION)  {
                String szSavePath = fs.getSelectedFile().getPath() + ".wsq";

                if (WriteFile(szSavePath, SaveWSQData.Data) == false)  {
                    javax.swing.JOptionPane.showMessageDialog(null, "WSQ Image save fail");
                }
                else  {
                    javax.swing.JOptionPane.showMessageDialog(null, "WSQ Image save success");
                }
            }
        }
    }//GEN-LAST:event_btnSaveWSQActionPerformed

    private void btnLoad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoad1ActionPerformed
        javax.swing.JFileChooser fs = new javax.swing.JFileChooser();

        fs.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));
        fs.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(java.io.File f) {
                return f.getName().toLowerCase().endsWith(".wsq") || f.isDirectory();
            }

            public String getDescription() {
                return "NITGEN WSQ data";
            }
        });

        fs.setMultiSelectionEnabled(false);
        fs.setDialogTitle("Load WSQ data");
        fs.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);

        if (fs.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION)  {
            byte[] loadData;
            int nLoadLen = 0;
            java.io.FileInputStream fis = null;
            long nFileLen = fs.getSelectedFile().length();

            loadData = new byte[(int) nFileLen];

            try  {
                fis = new java.io.FileInputStream(fs.getSelectedFile());

                java.io.File fp = fs.getSelectedFile();

                nLoadLen = fis.read(loadData);
            }
            catch (Exception e)  {
                javax.swing.JOptionPane.showMessageDialog(null, "FIle IO Error!!");
                return ;
            }
            finally  {
                try  {
                    fis.close();
                }
                catch (java.io.IOException e)
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "FIle IO Error!!");
                    return ;
                }
            }

            if (nLoadLen > 0)  {
                NBioBSPJNI.Export.AUDIT exportAudit = exportEngine.new AUDIT();
                NBioBSPJNI.FIR_HANDLE hAudtiFIR;

                exportEngine.ConvertWsqToRaw(loadData, nLoadLen, exportAudit);

                if (CheckError())
                    return ;

                if (hWSQFIR1 != null)  {
                    hWSQFIR1.dispose();
                    hWSQFIR1 = null;
                }

                hAudtiFIR = bsp.new FIR_HANDLE();

                exportEngine.ImportAudit(exportAudit, hAudtiFIR);

                if (CheckError())
                    return ;

                NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();

                inputFIR.SetFIRHandle(hAudtiFIR);
                hWSQFIR1 = bsp.new FIR_HANDLE();

                bsp.Process(inputFIR, hWSQFIR1);

                if (CheckError())
                    return ;

                if (hWSQFIR2 != null)  {
                    btnMatch.setEnabled(true);
                }

                javax.swing.JOptionPane.showMessageDialog(null, "Make FIR Handle Success");
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "File load fail");
        }
    }//GEN-LAST:event_btnLoad1ActionPerformed

    private void btnLoad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoad2ActionPerformed
        javax.swing.JFileChooser fs = new javax.swing.JFileChooser();

        fs.setCurrentDirectory(new java.io.File(System.getProperty("user.dir")));
        fs.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(java.io.File f) {
                return f.getName().toLowerCase().endsWith(".wsq") || f.isDirectory();
            }

            public String getDescription() {
                return "NITGEN WSQ data";
            }
        });

        fs.setMultiSelectionEnabled(false);
        fs.setDialogTitle("Load WSQ data");
        fs.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);

        if (fs.showOpenDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION)  {
            byte[] loadData;
            int nLoadLen = 0;
            java.io.FileInputStream fis = null;
            long nFileLen = fs.getSelectedFile().length();

            loadData = new byte[(int) nFileLen];

            try  {
                fis = new java.io.FileInputStream(fs.getSelectedFile());

                java.io.File fp = fs.getSelectedFile();

                nLoadLen = fis.read(loadData);
            }
            catch (Exception e)  {
                javax.swing.JOptionPane.showMessageDialog(null, "FIle IO Error!!");
                return ;
            }
            finally  {
                try  {
                    fis.close();
                }
                catch (java.io.IOException e)
                {
                    javax.swing.JOptionPane.showMessageDialog(null, "FIle IO Error!!");
                    return ;
                }
            }

            if (nLoadLen > 0)  {
                NBioBSPJNI.Export.AUDIT exportAudit = exportEngine.new AUDIT();
                NBioBSPJNI.FIR_HANDLE hAudtiFIR;

                exportEngine.ConvertWsqToRaw(loadData, nLoadLen, exportAudit);

                if (CheckError())
                    return ;

                if (hWSQFIR2 != null)  {
                    hWSQFIR2.dispose();
                    hWSQFIR2 = null;
                }

                hAudtiFIR = bsp.new FIR_HANDLE();

                exportEngine.ImportAudit(exportAudit, hAudtiFIR);

                if (CheckError())
                    return ;

                NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
                
                inputFIR.SetFIRHandle(hAudtiFIR);
                hWSQFIR2 = bsp.new FIR_HANDLE();

                bsp.Process(inputFIR, hWSQFIR2);

                if (CheckError())
                    return ;
                
                if (hWSQFIR1 != null)  {
                    btnMatch.setEnabled(true);
                }
                
                javax.swing.JOptionPane.showMessageDialog(null, "Make FIR Handle Success");
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "File load fail");
        }
    }//GEN-LAST:event_btnLoad2ActionPerformed

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
        NBioBSPJNI.INPUT_FIR inputFIR2 = bsp.new INPUT_FIR();
        Boolean bResult = new Boolean(false);

        inputFIR.SetFIRHandle(hWSQFIR1);
        inputFIR2.SetFIRHandle(hWSQFIR2);

        bsp.VerifyMatch(inputFIR2, inputFIR, bResult, null);

        if (CheckError())
            return ;

        if (bResult)
            javax.swing.JOptionPane.showMessageDialog(null, "Verify OK");
        else
            javax.swing.JOptionPane.showMessageDialog(null, "Verify Failed");
    }//GEN-LAST:event_btnMatchActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NBioAPI_WSQDemo dialog = new NBioAPI_WSQDemo(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }

    NBioBSPJNI                          bsp;
    NBioBSPJNI.Export                   exportEngine;
    NBioBSPJNI.Export.TEMPLATE_DATA     SaveWSQData;
    NBioBSPJNI.FIR_HANDLE               hWSQFIR1;
    NBioBSPJNI.FIR_HANDLE               hWSQFIR2;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad1;
    private javax.swing.JButton btnLoad2;
    private javax.swing.JButton btnMakeWSQ;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnSaveWSQ;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
