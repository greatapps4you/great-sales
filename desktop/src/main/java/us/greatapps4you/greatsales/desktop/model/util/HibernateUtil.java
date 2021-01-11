/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.desktop.model.util;

import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        try {
            sessionFactory = DBConnector.buildSessionFactory();
        } catch (Exception var1) {
            System.err.println("Initial SessionFactory creation failed." + var1);
            throw new ExceptionInInitializerError(var1);
        }
    }
}
