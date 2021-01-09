package br.com.greatsoft.greaterp.view.sales.relatorio;

import br.com.greatsoft.greaterp.model.entity.sales.SaleHeader;
import br.com.greatsoft.greaterp.model.entity.sales.SaleItem;
import br.com.greatsoft.greaterp.model.persistence.rn.SaleItemRn;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.MaskFormatter;

public class RelatorioVendasMaster extends JFrame {
    private RelatorioVendasTM relatorioTM = new RelatorioVendasTM(new ArrayList());
    private JFormattedTextField dataFinJFTF;
    private JFormattedTextField dataInJFTF;
    private JButton filtrarJB;
    private JLabel jLabel1;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JTable pedidosJT;
    private JTextField totalComissoes;

    public RelatorioVendasMaster() {
        this.initComponents();
        this.addDuploClickTabela();
        this.formatJFTF();
    }

    private void filtrar() {
        this.initRelatorioTM();
        this.relatorioTM.fireTableDataChanged();
        this.pedidosJT.setModel(this.relatorioTM);
    }

    private void formatJFTF() {
        try {
            MaskFormatter dtIn = new MaskFormatter("##/##/####");
            dtIn.install(this.dataInJFTF);
            MaskFormatter dtFin = new MaskFormatter("##/##/####");
            dtFin.install(this.dataFinJFTF);
        } catch (ParseException var4) {
            System.out.println(var4.getLocalizedMessage());
        }

    }

    private void detalharComissao() {
        int linha = this.pedidosJT.getSelectedRow();
        SaleHeader venda = (SaleHeader)this.relatorioTM.getValueAt(linha, 0);
        JOptionPane.showMessageDialog(this.rootPane, "Total: " + venda.getTotal() + "\nComissão (" + venda.getComissaoPercent() + "%): R$ " + venda.getComissaoDinheiro());
    }

    private void addDuploClickTabela() {
        this.pedidosJT.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    RelatorioVendasMaster.this.detalharComissao();
                }

            }
        });
    }

    private void limparCampos() {
        this.dataInJFTF.setText("");
        this.dataFinJFTF.setText("");
    }

    private boolean validarCampos() {
        if (this.dataInJFTF != null && this.dataFinJFTF != null) {
            return this.dataInJFTF.getText().replaceAll("/", "").trim().length() == 8 && this.dataFinJFTF.getText().replaceAll("/", "").trim().length() == 8;
        } else {
            return false;
        }
    }

    private void initRelatorioTM() {
        Object saleItems = new ArrayList();

        try {
            String dataInicial = "";
            String dataFinal = "";
            if (this.dataInJFTF != null && this.dataFinJFTF != null) {
                dataInicial = this.dataInJFTF.getText();
                dataFinal = this.dataFinJFTF.getText();
            }

            SimpleDateFormat formatter;
            Date dataIn;
            if (dataInicial.replaceAll("/", "").trim().length() != 8 && dataFinal.replaceAll("/", "").trim().length() != 8) {
                formatter = new SimpleDateFormat("dd/MM/yyyy");
                dataIn = new Date();
                dataIn.setDate(1);
                dataInicial = formatter.format(dataIn);
                dataFinal = formatter.format(new Date());
            }

            formatter = new SimpleDateFormat("dd/MM/yyyy");
            dataIn = formatter.parse(dataInicial);
            Date dataFin = formatter.parse(dataFinal);
            saleItems = (new SaleItemRn()).listarRelatorioComissoes(dataIn, dataFin, "SaleItem");
            this.totalComissoes.setText(Double.toString(this.calcularComissoes((List)saleItems)));
        } catch (Exception var7) {
            System.out.println("Erro ao tentar inicializar RelatorioVendasTM com as vendas deste mes");
        }

        this.relatorioTM = new RelatorioVendasTM((List)saleItems);
    }

    private double calcularComissoes(List<SaleItem> itens) {
        double totCom = 0.0D;
        Iterator var4 = itens.iterator();

        while(var4.hasNext()) {
            SaleItem si = (SaleItem)var4.next();

            try {
                totCom += si.getSaleHeader().getComissaoDinheiro();
            } catch (Exception var7) {
                totCom += 0.0D;
                System.out.println("Valor null no SaleHeader o SaleItem " + si.getId());
            }
        }

        return totCom;
    }

    private void initComponents() {
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.pedidosJT = new JTable();
        this.filtrarJB = new JButton();
        this.dataFinJFTF = new JFormattedTextField();
        this.dataInJFTF = new JFormattedTextField();
        this.totalComissoes = new JTextField();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setTitle("Relatório de Vendas");
        this.setIconImage((new ImageIcon("img/greatcalc.png")).getImage());
        this.setResizable(false);
        this.addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent evt) {
                RelatorioVendasMaster.this.formWindowStateChanged(evt);
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent evt) {
                RelatorioVendasMaster.this.formWindowClosed(evt);
            }
        });
        this.jLabel5.setText("Data Inicial");
        this.jLabel6.setText("Data Final");
        this.pedidosJT.setModel(this.relatorioTM);
        this.pedidosJT.setToolTipText("Dê duplo click na linha para ver a comissão.");
        this.jScrollPane1.setViewportView(this.pedidosJT);
        this.filtrarJB.setText("Filtrar");
        this.filtrarJB.setToolTipText("Clique para filtrar os resultados.");
        this.filtrarJB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RelatorioVendasMaster.this.filtrarJBActionPerformed(evt);
            }
        });
        this.dataFinJFTF.setToolTipText("Entre com a data final.");
        this.dataInJFTF.setToolTipText("Entre com a data Inicial.");
        this.totalComissoes.setEditable(false);
        this.totalComissoes.setToolTipText("Total das comissões para a presente pesquisa");
        this.jLabel1.setText("Total Comissões");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.dataInJFTF, -2, 135, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel6).addGap(3, 3, 3).addComponent(this.dataFinJFTF, -2, 104, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.filtrarJB)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.totalComissoes, -2, 191, -2))).addContainerGap(277, 32767)));
        layout.linkSize(0, new Component[]{this.dataFinJFTF, this.dataInJFTF});
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.filtrarJB).addComponent(this.dataFinJFTF, -2, -1, -2).addComponent(this.dataInJFTF, -2, -1, -2)).addGap(27, 27, 27).addComponent(this.jScrollPane1, -2, 275, -2).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.totalComissoes, -2, -1, -2).addComponent(this.jLabel1)).addContainerGap(-1, 32767)));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    private void formWindowClosed(WindowEvent evt) {
    }

    private void formWindowStateChanged(WindowEvent evt) {
    }

    private void filtrarJBActionPerformed(ActionEvent evt) {
        try {
            if (this.validarCampos()) {
                this.filtrar();
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(this.rootPane, "Informe as datas inicial e final corretamente");
            }
        } catch (HeadlessException var3) {
        }

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
            Logger.getLogger(RelatorioVendasMaster.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new RelatorioVendasMaster()).setVisible(true);
            }
        });
    }
}
