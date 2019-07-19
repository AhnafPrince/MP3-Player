
package mp3player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
//import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

import org.tritonus.share.sampled.TAudioFormat;
import org.tritonus.share.sampled.file.TAudioFileFormat;

/**
 *
 * @author SHUVO
 */
public class MP3Player extends javax.swing.JFrame {

    MP3 song;
    DefaultTableModel dm;
    String name;
    String path;
    
    ArrayList list = new ArrayList();
    String line;
    File file = new File("songTitle.txt");
    
    int   currentSecond = 0;
    int currentMinutes = 0;
    int min;
    int sec;
    Timer timer;
    
    public MP3Player() {
        initComponents();
        song = null;
        createColumns();
    }
    
    private void createColumns(){
       dm=(DefaultTableModel)jTable1.getModel();
       dm.addColumn("Title");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        Display = new javax.swing.JLabel();
        Duration = new javax.swing.JLabel();
        Left = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Add = new javax.swing.JMenuItem();
        saveList = new javax.swing.JMenuItem();
        showList = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(415, 440));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("                    ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 10, 180, 30);

        playButton.setBackground(new java.awt.Color(255, 255, 255));
        playButton.setFont(new java.awt.Font("Tekton Pro Cond", 0, 14)); // NOI18N
        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/PlayNormal.png"))); // NOI18N
        playButton.setContentAreaFilled(false);
        playButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/PlayDisabled.png"))); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        jPanel1.add(playButton);
        playButton.setBounds(130, 190, 50, 50);

        stopButton.setBackground(new java.awt.Color(153, 153, 153));
        stopButton.setFont(new java.awt.Font("Tekton Pro Cond", 0, 14)); // NOI18N
        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/StopNormalBlue.png"))); // NOI18N
        stopButton.setContentAreaFilled(false);
        stopButton.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/Stop1Disabled.png"))); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jPanel1.add(stopButton);
        stopButton.setBounds(200, 190, 50, 50);

        pauseButton.setBackground(new java.awt.Color(153, 153, 153));
        pauseButton.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        pauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/PauseNormalRed.png"))); // NOI18N
        pauseButton.setContentAreaFilled(false);
        pauseButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/PauseDisabled.png"))); // NOI18N
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pauseButton);
        pauseButton.setBounds(60, 190, 50, 50);

        resumeButton.setBackground(new java.awt.Color(153, 153, 153));
        resumeButton.setFont(new java.awt.Font("Tekton Pro", 1, 14)); // NOI18N
        resumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/StepForwardNormalBlue.png"))); // NOI18N
        resumeButton.setContentAreaFilled(false);
        resumeButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/StepForwardDisabled.png"))); // NOI18N
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(resumeButton);
        resumeButton.setBounds(280, 190, 50, 50);

        Display.setBackground(new java.awt.Color(255, 255, 255));
        Display.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        Display.setForeground(new java.awt.Color(153, 102, 255));
        Display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Display);
        Display.setBounds(30, 40, 340, 30);

        Duration.setForeground(new java.awt.Color(153, 102, 255));
        jPanel1.add(Duration);
        Duration.setBounds(320, 70, 40, 20);

        Left.setForeground(new java.awt.Color(153, 102, 255));
        jPanel1.add(Left);
        Left.setBounds(24, 74, 40, 20);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mp3player/avenged-sevenfold.jpg"))); // NOI18N
        jPanel1.add(Background);
        Background.setBounds(0, 0, 400, 250);

        jTable1.setBackground(new java.awt.Color(51, 51, 255));
        jTable1.setFont(new java.awt.Font("Century Schoolbook", 0, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 250, 400, 130);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 255));
        jMenuBar1.setFont(new java.awt.Font("Palatino Linotype", 0, 10)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jMenu1.setOpaque(true);

        Open.setBackground(new java.awt.Color(204, 204, 255));
        Open.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        jMenuBar1.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(204, 204, 255));
        jMenu2.setText("PlayList");
        jMenu2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jMenu2.setOpaque(true);

        Add.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jMenu2.add(Add);

        saveList.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        saveList.setText("Save");
        saveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveListActionPerformed(evt);
            }
        });
        jMenu2.add(saveList);

        showList.setText("Show");
        showList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showListActionPerformed(evt);
            }
        });
        jMenu2.add(showList);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        try{
        song.play();
        Display.setText(name);
        Duration.setText(String.format("%d:%d",min,sec));
        playButton.setEnabled(false);
        pauseButton.setEnabled(true);
        
        
        timer = new Timer(1000, new ActionListener(){
        public void actionPerformed( ActionEvent e ) {      
                if( currentSecond == 60 ) {
                    currentMinutes++;
                    currentSecond = 0;
                }
                Left.setText( String.format("%d:%d",currentMinutes, currentSecond ));
                currentSecond++;
               if(min==currentMinutes && sec+1==currentSecond){
                timer.stop();           
                }
            }
        });
        timer.start();
        
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_playButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        song.close();
        Display.setText("");
        Duration.setText("");
        Left.setText("");
        currentMinutes=0;
        currentSecond=0;
        playButton.setEnabled(true);
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);
        
        timer.stop();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        song.pause();
        timer.stop();
        resumeButton.setEnabled(true);
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        song.resume();
        timer.start();
        resumeButton.setEnabled(false);
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        try{
       JFileChooser fileChooser = new JFileChooser();
       int result=fileChooser.showOpenDialog(null);
       File selectedFile=fileChooser.getSelectedFile();
       
       AudioFileFormat baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(selectedFile);
       
       if (baseFileFormat instanceof TAudioFileFormat) {
        Map<?, ?> properties = ((TAudioFileFormat) baseFileFormat).properties();
        String key = "duration";
        Long microseconds = (Long) properties.get(key);
        int mili = (int) (microseconds / 1000);
        sec = (mili / 1000) % 60;
        min = (mili / 1000) / 60;
       } 
       else {
        throw new UnsupportedAudioFileException();
     }
            
       //System.out.println("Selected File: "+selectedFile.getAbsolutePath());       
       name = fileChooser.getSelectedFile().getName();      
       Display.setText(name);            
       song = new MP3(selectedFile.getAbsolutePath());       
       path=selectedFile.getAbsolutePath();
           
        pauseButton.setEnabled(false);
        resumeButton.setEnabled(false);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
       populate(path);
       list.add(path);
                       
    }//GEN-LAST:event_AddActionPerformed

    private void saveListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveListActionPerformed
        try{
          FileWriter fw = new FileWriter(file);
          Writer output = new BufferedWriter(fw);
          
          for(int i=0;i<list.size();i++){
              output.write(list.get(i).toString()+ "\n");
          }
          output.close();
       }catch(Exception e){
           
       }
    }//GEN-LAST:event_saveListActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        dm = (DefaultTableModel)jTable1.getModel();
        String selected=dm.getValueAt(jTable1.getSelectedRow(), 0).toString();
        //System.out.println(selected);
        song = new MP3(selected);
        name=selected;
    }//GEN-LAST:event_jTable1MouseClicked

    private void showListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showListActionPerformed
       try{
          BufferedReader input = new BufferedReader(new FileReader(file));
          if(!input.ready()){
              throw new IOException();
          } 
          while((line = input.readLine())!=null){
              list.add(line);
          }
          input.close();
       }catch(Exception e){
           
       }
      
       for(int i=0;i<list.size();i++){
           populate(list.get(i).toString());
       }
       
    }//GEN-LAST:event_showListActionPerformed
    
    private void populate(String name){
        dm = (DefaultTableModel)jTable1.getModel();
        String[] rowData={name};
        dm.addRow(rowData);      
    }
    
       
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(MP3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MP3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MP3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MP3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MP3Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Add;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Display;
    private javax.swing.JLabel Duration;
    private javax.swing.JLabel Left;
    private javax.swing.JMenuItem Open;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JButton resumeButton;
    private javax.swing.JMenuItem saveList;
    private javax.swing.JMenuItem showList;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
