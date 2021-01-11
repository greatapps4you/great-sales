/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.common.wait;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JDialog;

public class MailWait extends JDialog implements Runnable {
    public MailWait(JDialog parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Aguarde...");
        this.add(new MailBoard());
        this.setUndecorated(true);
        this.setModal(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.pack();
    }

    public static void main(String[] args) {
        JDialog ex = new MailWait((JDialog)null, true);
        ex.setVisible(true);
    }

    public void run() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog ex = new MailWait((JDialog)null, true);
                ex.setVisible(true);
            }
        });
    }
}
