package us.greatapps4you.greatsales.desktop.view.config;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class ConfigView extends JDialog {
    private JTextField database;
    private JTextField host;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JComboBox mode;
    private JTextField port;
    private JToggleButton salvar;

    public ConfigView(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.host = new JTextField();
        this.jLabel2 = new JLabel();
        this.port = new JTextField();
        this.database = new JTextField();
        this.jLabel3 = new JLabel();
        this.salvar = new JToggleButton();
        this.jLabel5 = new JLabel();
        this.mode = new JComboBox();
        this.setDefaultCloseOperation(2);
        this.setTitle("Configurações");
        this.jLabel1.setText("Host");
        this.jLabel2.setText("Porta");
        this.jLabel3.setText("BD");
        this.salvar.setText("Salvar");
        this.jLabel5.setText("Modo");
        this.mode.setModel(new DefaultComboBoxModel(new String[]{"server", "client"}));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1, Alignment.TRAILING).addComponent(this.jLabel2, Alignment.TRAILING).addComponent(this.jLabel5, Alignment.TRAILING)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.mode, -2, 267, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.salvar)).addComponent(this.host).addGroup(layout.createSequentialGroup().addComponent(this.port, -2, 107, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.database))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.host, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.port, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.database, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.mode, -2, -1, -2).addComponent(this.salvar)).addContainerGap(-1, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
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
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException var5) {
            Logger.getLogger(ConfigView.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigView dialog = new ConfigView(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void addSalvarListener(ActionListener salvarListener) {
        this.salvar.addActionListener(salvarListener);
    }

    public String getDatabase() {
        return this.database.getText();
    }

    public void setDatabase(String database) {
        this.database.setText(database);
    }

    public String getHost() {
        return this.host.getText();
    }

    public void setHost(String host) {
        this.host.setText(host);
    }

    public String getPort() {
        return this.port.getText();
    }

    public void setPort(String port) {
        this.port.setText(port);
    }

    public String getMode() {
        return this.mode.getSelectedItem().toString();
    }

    public void setMode(String mode) {
        this.mode.setSelectedItem(mode);
    }
}
