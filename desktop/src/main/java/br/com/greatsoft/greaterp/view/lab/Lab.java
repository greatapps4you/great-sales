package br.com.greatsoft.greaterp.view.lab;

import br.com.greatsoft.greaterp.common.wait.MailBoard;
import br.com.greatsoft.greaterp.common.wait.MailWait;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;

public class Lab extends JDialog {
    private Thread runner;
    private JDialog mailWait;
    private volatile Lab.Progress prog;
    private JButton start;
    private JButton stop;

    public Lab(Frame parent, boolean modal) {
        super(parent, modal);
        this.getContentPane().add(new MailBoard());
        this.initComponents();
    }

    private void initComponents() {
        this.start = new JButton();
        this.stop = new JButton();
        this.setDefaultCloseOperation(2);
        this.start.setBackground(new Color(55, 184, 23));
        this.start.setText("Start");
        this.start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Lab.this.startActionPerformed(evt);
            }
        });
        this.stop.setBackground(new Color(254, 11, 1));
        this.stop.setText("Stop");
        this.stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Lab.this.stopActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(this.start).addGap(83, 83, 83).addComponent(this.stop).addContainerGap(123, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.start).addComponent(this.stop)).addContainerGap(50, 32767)));
        this.pack();
    }

    private void startActionPerformed(ActionEvent evt) {
        this.prog = new Lab.Progress();
        this.prog.start();
        Lab.AcaoPesada acao = new Lab.AcaoPesada();
        acao.start();
    }

    private void stopActionPerformed(ActionEvent evt) {
        this.prog.parar();
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lab dialog = new Lab(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    class AcaoPesada extends Thread {
        AcaoPesada() {
        }

        public void run() {
            try {
                for(int i = 0; i < 1000000; ++i) {
                    System.out.println(i);
                    if (i == 100000 || i == 300000) {
                        Lab.this.prog.parar();
                    }
                }
            } catch (Exception var2) {
                Logger.getLogger(Lab.class.getName()).log(Level.SEVERE, (String)null, var2);
            }

        }
    }

    class Progress extends Thread {
        private JDialog wait;

        Progress() {
        }

        public void run() {
            this.wait = new MailWait((JDialog)null, true);
            this.wait.setVisible(true);
        }

        public void parar() {
            this.wait.dispose();
        }
    }
}
