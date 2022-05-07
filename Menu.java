/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
/**
 *
 * @author HP
 */
public class Menu extends javax.swing.JFrame {
    String teacherName = "";
    String courseName = "";
    teacherList teachers; //= new teacherList(10); 
    Ratings rating;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
         readData();
        this.setTitle("Teacher Evaluation System");
    }
    public void readData(){
             String[] comments = new String[30];
             String[] teacherNames = new String[75];
             String[] courseNames = new String[28];
            
             //reading comments from file
           try {
             File myObj = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\DSProject\\src\\dsproject\\commentsData.txt");
             Scanner myReader = new Scanner(myObj);
             int i = 2;
             int j = 0;
             while(myReader.hasNextLine()) {
             String data = myReader.nextLine();
             if(i%2==0 && !data.isBlank()){
             comments[j] = data;
             j++;
             }
             i++;
             }
             myReader.close();
            } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
              }
              //reading teacher names from file
              try {
             File myObj = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\DSProject\\src\\dsproject\\teachersData.txt");
             Scanner myReader = new Scanner(myObj);
             int i = 0;
             int j = 0;
             while(myReader.hasNextLine()) {
             String data = myReader.nextLine();
             if(i%8==0 && !data.isBlank()){
              data = data.replace("Dr.", " ");
              data = data.replace(" ", "");
              String[] teacherdata = data.split(",");
              String fullname = "";
              for(int k=teacherdata.length-1;k>=0;k--){ // to write family name in the end (eg: binzubairhisham to hishambinzubair)
              fullname = fullname + teacherdata[k];
              }
              teacherNames[j] = fullname;
              teacherNames[j] = teacherNames[j].toLowerCase();
             j++;
             }
             i++;
             }
             myReader.close();
            } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
              }
              //reading course names from file
             try {
             File myObj = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\DSProject\\src\\dsproject\\coursesData.txt");
             Scanner myReader = new Scanner(myObj);
             int i = 0;
             while(myReader.hasNextLine()) {
             String[] data = myReader.nextLine().split(" ");
             if(!data[0].isBlank()){
             courseNames[i] = data[1].toLowerCase();
             i++;
             }
             }
             myReader.close();
            } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
              }
              teachers = new teacherList(teacherNames.length);
              
              //insert data in hashtables here
              for(int i=0;i<teacherNames.length;i++){
                  courseList c = new courseList(teacherNames[i], 28);
                 // for(int j =0;j<5;j++){
                 for(int j =0;j<28;j++){  //entering all courses for all teachers instead of entering random 5 courses for each teacher
                   Ratings r = new Ratings(teacherNames[i],courseNames[j],""+(int)(Math.random()*6),""+(int)(Math.random()*6),""+(int)(Math.random()*6),createRandomCommentObj(comments));
                  // c.insertRatings(courseNames[(int)(Math.random()*29)], r);
                  c.insertRatings(courseNames[j], r);
                  }
                  teachers.insertCourseList(teacherNames[i], c);
              }
 
            
          /* Ratings hishamLArating = new Ratings("Hisham Bin Zubair","linearalgebra", "5", "5", "5",createRandomCommentObj(comments));
           Ratings hishamDMrating = new Ratings("Hisham Bin Zubair", "discretemaths", "4.5", "3.8", "5",createRandomCommentObj(comments));
           courseList hishamcourselist = new courseList("hishambinzubair",5);
           hishamcourselist.insertRatings("linearalgebra", hishamLArating);
           hishamcourselist.insertRatings("discretemaths", hishamDMrating);

           Ratings maqsoodNArating = new Ratings("Maqsood Alam","numericalanalysis", "3.7", "4.5","4",createRandomCommentObj(comments));
           Ratings maqsoodDMrating = new Ratings("Maqsood Alam","discretemaths", "4", "5","5",createRandomCommentObj(comments));
           courseList maqsoodcourselist = new courseList("maqsoodalam",5);  
           maqsoodcourselist.insertRatings("numericalanalysis", maqsoodNArating);
           maqsoodcourselist.insertRatings("discretemaths", maqsoodDMrating);

           teachers.insertCourseList("hishambinzubair", hishamcourselist);
           teachers.insertCourseList("maqsoodalam", maqsoodcourselist); */
    }
    public Comments createRandomCommentObj(String[] comments){
        Comments comment = new Comments();
        for(int i=0;i<10;i++){
            comment.insertComment(comments[(int)(Math.random()*30)]);
        }
        return comment;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(115, 12, 28));
        jLabel1.setText("Instructor Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(115, 12, 28));
        jLabel2.setText("Course Name:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(115, 12, 28));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(115, 12, 28));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dsproject/iba2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // for(int i=0;i<teachers.Table.length;i++)
          // System.out.println(teachers.Table[i]);
   
        teacherName = jTextField1.getText();
        courseName = jTextField2.getText();
        teacherName = teacherName.replace(" ", "");
        teacherName = teacherName.toLowerCase();
        courseName = courseName.replace(" ", "");
        courseName = courseName.toLowerCase();
        rating = teachers.search(teacherName, courseName);
        if(rating==null){
            jLabel3.setText("Instructor/Course Not Found! Make sure you enter full names!");
        }
        else{
        DisplayRatingMenu displayrating = new DisplayRatingMenu();
        displayrating.setRating(rating);
        displayrating.setVisible(true);
        this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
