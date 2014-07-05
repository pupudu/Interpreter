
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class shellView extends javax.swing.JFrame {

    ComposeJava comp = new ComposeJava();                     //new instance of ComposeJava which contains the methods which build up the backbone

    public shellView() {                                    //constructor 
        initComponents();                                   //initialize GUI components
        LblDirectory.setText(System.getProperty("user.dir"));       // Shows the current directory on the interface
        comp.readDirectory();                               //read files in the root directory
        updateClassList();                                  //adds class list to the combo box
    }

    /*
     * This method adds class Names to the dropdown combobox
     */
    private void updateClassList() {
        ArrayList<String> fileList = comp.getFileList();      //Reference to the arraylist which contains the names list of Files imported
        for (String file : fileList) {
            if (file.length() <= 5) {
                continue;                               //if number of characters is less than 5, then it's not a java file(refer to .java)
            }
            file = file.substring(0, file.length() - 5);         //extract the name without the .java extension
            cmbClass.addItem(file);                         //add name to the dropdown combo box
        }
    }

    /*
     * This Method extracts the methods from the selected class(from the
     * dropdown box) and adds to another dropdown menu
     */
    public void listMethods(String className) {
        comp.compile();                                     //compiles the list of java files in the root directory(Files are assumed to be stored according to package view

        try {
            Class<?> cls = Class.forName(className);        //Obtain a class instance from the selected file
            Method[] methods = cls.getDeclaredMethods();    //gets ONLY the methods that were declared manually

            cmbMethods.removeAllItems();                    //clear the "methods" combo box before adding the methods

            for (Method method : methods) {                 //iterate through the methods and adds them to the combo box
                cmbMethods.addItem(method);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);                         //prints exception to the cmd
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShell = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCompile = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        LblDirectory = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmbClass = new javax.swing.JComboBox();
        cmbMethods = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        btnExec = new javax.swing.JButton();
        btnCopyToShell = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewer = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        jLabel6.setText("Available Methods");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(811, 509));

        txtShell.setColumns(20);
        txtShell.setRows(5);
        jScrollPane1.setViewportView(txtShell);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);

        btnCompile.setText("Compile");
        btnCompile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompileActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompile);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);

        LblDirectory.setText("Current Directory :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblDirectory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblDirectory)
                .addContainerGap())
        );

        cmbClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClassActionPerformed(evt);
            }
        });

        cmbMethods.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel5.setText("Available Classes");

        btnExec.setText("Execute");
        btnExec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecActionPerformed(evt);
            }
        });

        btnCopyToShell.setText("Copy to Shell");
        btnCopyToShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyToShellActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMethods, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCopyToShell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnExec, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbMethods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCopyToShell)
                    .addComponent(btnExec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearBtn)
                .addContainerGap())
        );

        jLabel1.setText("Shell Window");

        viewer.setColumns(20);
        viewer.setRows(5);
        jScrollPane2.setViewportView(viewer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompileActionPerformed
        comp.compile();                                     //compiles files in the root directory. Assumes package structure is present
    }//GEN-LAST:event_btnCompileActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);                                     //Quits the program successfully 
    }//GEN-LAST:event_btnExitActionPerformed

    /*
     * Updates the methods comboBox when a class is selected
     */
    private void cmbClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClassActionPerformed
        String javaClass = this.cmbClass.getSelectedItem().toString();            //gets the name of the slected class  
        javaClass = comp.getPackage(javaClass) + javaClass;                         //Get absolute name of the class(package.class)
        listMethods(javaClass);                                                 //update combo box with the corresponding methods
    }//GEN-LAST:event_cmbClassActionPerformed

    /*
     * Executes the method written in the text shell, line by line
     */
    private void btnExecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecActionPerformed

        try {
            for (String line : txtShell.getText().split("\n")) {    //line by line
                if (line.compareTo("") == 0) {
                    continue;                       // nothing to execute in empty lines
                }
                String StrCls = "";                 // corresponding class, not yet selected
                String StrMthd = "";                //method to execute, not yet selected
                int tokenCount = 0;

                StringTokenizer st = new StringTokenizer(line, ".");   //tokenize using dot to build up absolute name

                String nxt;                         //temporary string to build up the absolute class name
                while (st.hasMoreTokens()) {
                    tokenCount++;
                    nxt = st.nextToken();
                    StrMthd = nxt;                  //String after the last dot will be taken as the method name
                    if (!st.hasMoreTokens()) {
                        break;
                    }
                    StrCls = StrCls + "." + nxt;    //add a dot to get the absolute class name, step by step
                }
                if (StrCls.length() < 1) {
                    viewer.setText("Error: Class Name Not Given");
                    continue;
                }
                StrCls = StrCls.substring(1);     // removes the dot at the begining of the class name

                if (tokenCount <= 1) {
                    viewer.setText("invalid call");
                    continue;
                }

                String params = extractParam(StrMthd, 1);  //gets the parameers as a single string seperated by commas
                StrMthd = extractParam(StrMthd, 0);        //gets the method name

                Class<?> cls = Class.forName(StrCls);   //instance of the class from the selected class name
                Object obj = cls.newInstance();           //instantiate an object from the class(to be passed to invoke the method)

                Class<?>[] parameters;                  //list of classes for the parameters

                Method[] mthds = cls.getDeclaredMethods();//gets the list of methods which were declared manually by the programmer
                for (Method test : mthds) {                //finds the correct method by string comparrison
                    if (test.getName().compareTo(StrMthd) == 0) {
                        parameters = test.getParameterTypes();            //types of the paramters in the method extracted as Classes
                        Method mthd = cls.getMethod(StrMthd, parameters);  //A new method which corresponds to the method name and correct parameters
                        invoke(params, mthd, obj, parameters);           //invokes the method
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(shellView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExecActionPerformed

    private void invoke(String params, Method mthd, Object obj, Class<?>[] types) { //params is a string which contains all the paramters seperated by a comma
        try {
            int count = 0;                                        //variable which states the index of the parameter(position of each)
            StringTokenizer st = new StringTokenizer(params);     //tokenize parameters
            String[] par = params.split(",");                     //tokenize parameters
            int items = par.length;                               //number of paramters

            /*
             * next 8 lines is optional Variable declaration to store parameters
             * according to each type parameters can be stored in a single
             * arraylist without storing in these variable arrays
             */
            int[] n = new int[items];
            char[] c = new char[items];
            String[] s = new String[items];
            Double[] d = new Double[items];
            Float[] f = new Float[items];
            Boolean[] b = new Boolean[items];
            long[] l = new long[items];
            short[] sh = new short[items];

            ArrayList<Object> var = new ArrayList<>();

            /*
             * After the following loop parameters will be parsed to their
             * correct type and will be added to an arraylist paramters can be
             * accessed by popping elements from the arraylist
             */
            for (Class<?> type : types) {
                String sType = type.toString();
                switch (sType) {                                  //this switch adds each parameter identified, into an arraylist, after parsing it to the correct Variable type
                    case "int":
                        n[count] = Integer.parseInt(par[count]);  //parase variable to int 
                        var.add(n[count]);
                        break;
                    case "Double":
                        d[count] = Double.parseDouble(par[count]);  //parase variable to double
                        var.add(d[count]);
                        break;
                    case "Float":
                        f[count] = Float.parseFloat(par[count]);        //parase variable to float
                        var.add(f[count]);
                        break;
                    case "short":
                        sh[count] = Short.parseShort(par[count]);       //parase variable to short
                        var.add(s[count]);
                        break;
                    case "long":
                        l[count] = Long.parseLong(par[count]);      //parase variable to long
                        var.add(l[count]);
                        break;
                    case "boolean":
                        b[count] = Boolean.parseBoolean(par[count]);    //parase variable to boolean
                        var.add(b[count]);
                        break;
                    case "String":
                        var.add(sType);                               //doestn't have to parse for strings
                        break;
                    case "char":
                        if (par.length != 1) {
                            viewer.setText("invalid input as a Character"); //check whether it is a character
                            return;
                        }
                        c[count] = par[count].charAt(0);          //gets the first (and only) character as the parametr
                        var.add(c[count]);
                        break;
                    default:
                        break;
                }
                count++;
            }
            /*
             * Next 4 lines(without the comments) is used to capture the output
             * from the System.out
             */
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            // IMPORTANT: Save the old System.out!
            PrintStream old = System.out;
            // Tell Java to use your special stream
            System.setOut(ps);
            // Print some output: goes to your special stream

            switch (items) {                      //this switch invokes the method considering the number of paramters given
                case 1:
                    mthd.invoke(obj);
                    break;
                case 2:
                    mthd.invoke(obj, var.get(0), var.get(1));
                    break;
                case 3:
                    mthd.invoke(obj, var.get(0), var.get(1), var.get(2));
                    break;
                case 4:
                    mthd.invoke(obj, var.get(0), var.get(1), var.get(2), var.get(3));
                    break;
                case 5:
                    mthd.invoke(obj, var.get(0), var.get(1), var.get(2), var.get(3), var.get(4));
                    break;
                default:
                    viewer.setText("Too Many Parameters");
            }
            // Put things back
            System.out.flush();
            System.setOut(old);
            // Show what happened
            viewer.setText(baos.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
     * Copies the method name to the shell Window to be executed
     */
    private void btnCopyToShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyToShellActionPerformed

        try {
            if (txtShell.getText().compareTo("") != 0) {                                    //Optional code- to avoid an empty new line when a method is copied
                System.out.println("\n");
            }
            txtShell.setText(cmbMethods.getSelectedItem().toString().split(" ")[2]);    //drops access modifiers before copying
        } catch (Exception e) {
            System.out.println("btn Copy exeption:\n" + e);
        }
    }//GEN-LAST:event_btnCopyToShellActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        viewer.setText("");                 //clear viewer
        txtShell.setText("");               //clear shell
    }//GEN-LAST:event_clearBtnActionPerformed

    /*
     * Method to extract parameters from the users input to the text shell
     */
    private String extractParam(String method, int option) {  //returns method name if option==0, returns parameter set if option==1
        try {
            String params;
            params = method.split("\\(|\\)")[option]; // idenifies parameters with the existance of "(" or ")"
            return params;
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String args[]) {

        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(shellView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(shellView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(shellView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(shellView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new shellView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblDirectory;
    private javax.swing.JButton btnCompile;
    private javax.swing.JButton btnCopyToShell;
    private javax.swing.JButton btnExec;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbMethods;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtShell;
    private javax.swing.JTextArea viewer;
    // End of variables declaration//GEN-END:variables
}
