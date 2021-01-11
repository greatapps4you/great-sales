/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.view.sales;

import us.greatapps4you.greatsales.desktop.controller.bean.SaleBean;
import us.greatapps4you.greatsales.entities.sale.Sale;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class SalesListView extends JDialog {
    private SalesListTM salesListTM;
    private SaleBean saleBean;
    private JButton atualizarTabelaJB;
    private JButton excluirJB;
    private JScrollPane jScrollPane1;
    private JButton novoJB;
    private JTable salesJT;

    public SalesListView(Frame parent, boolean modal) {
        super(parent, modal);
        this.inicializarModelo();
        this.initComponents();
        this.addDuploClickTabela();
    }

    private void editar() {
        int linha = this.salesJT.getSelectedRow();
        Sale saleHeader = (Sale)this.salesListTM.getValueAt(linha, 4);
        SalesAgentView editDlg = new SalesAgentView(new JFrame(), false, saleHeader);
        editDlg.setVisible(true);
    }

    private void novo() {
        SalesAgentView editDlg = new SalesAgentView(new JFrame(), true, (Sale)null);
        editDlg.setVisible(true);
    }

    private void excluir() {
        int option = JOptionPane.showConfirmDialog(this.rootPane, "Tem certeza que deseja excluir a venda selecionada?");
        if (option == 0) {
            try {
                int linha = this.salesJT.getSelectedRow();
                Sale saleDel = (Sale)this.salesListTM.getValueAt(linha, 4);
                SaleBean saleDelBean = new SaleBean();
                if (saleDelBean.excluir(saleDel)) {
                    this.atualizarTabela();
                    JOptionPane.showMessageDialog(this.rootPane, "Excluído com sucesso");
                } else {
                    JOptionPane.showMessageDialog(this.rootPane, "Registro não pode ser excluído\npois está sendo referenciado em outra tabela!");
                }
            } catch (Exception var5) {
                System.out.println("Tentou excluir registro sem selecionar linha.");
            }
        }

    }

    private void atualizarTabela() {
        this.inicializarModelo();
        this.salesListTM.fireTableDataChanged();
        this.salesJT.setModel(this.salesListTM);
    }

    private void addDuploClickTabela() {
        this.salesJT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    SalesListView.this.editar();
                }

            }
        });
    }

    private void inicializarModelo() {
        this.saleBean = new SaleBean();
        List<Sale> sales = this.saleBean.getLista();
        if (sales != null) {
            this.salesListTM = new SalesListTM(sales);
        }

    }

    private void initComponents() {
        this.novoJB = new JButton();
        this.excluirJB = new JButton();
        this.atualizarTabelaJB = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.salesJT = new JTable();
        this.setDefaultCloseOperation(2);
        this.setTitle("Pedidos Enviados");
        this.novoJB.setText("Novo");
        this.novoJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesListView.this.novoJBActionPerformed(evt);
            }
        });
        this.excluirJB.setText("Excluir");
        this.excluirJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesListView.this.excluirJBActionPerformed(evt);
            }
        });
        this.atualizarTabelaJB.setText("Atuallizar Tabela");
        this.atualizarTabelaJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SalesListView.this.atualizarTabelaJBActionPerformed(evt);
            }
        });
        this.salesJT.setModel(this.salesListTM);
        this.jScrollPane1.setViewportView(this.salesJT);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.novoJB).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.excluirJB).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.atualizarTabelaJB).addContainerGap(-1, 32767)).addComponent(this.jScrollPane1, -1, 796, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.novoJB).addComponent(this.excluirJB).addComponent(this.atualizarTabelaJB)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 367, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void novoJBActionPerformed(ActionEvent evt) {
        this.novo();
    }

    private void excluirJBActionPerformed(ActionEvent evt) {
        this.excluir();
    }

    private void atualizarTabelaJBActionPerformed(ActionEvent evt) {
        this.atualizarTabela();
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
            Logger.getLogger(SalesListView.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(SalesListView.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(SalesListView.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(SalesListView.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SalesListView dialog = new SalesListView(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
