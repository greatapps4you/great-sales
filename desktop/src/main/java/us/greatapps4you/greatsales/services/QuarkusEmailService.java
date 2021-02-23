/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 *
 * Team:
 * José Esteves de Souza Neto (Lead Engineer)
 * Renato Magrini (Front-End Developer)
 * Nathan Parra Ramos (Designer)
 *
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.services;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class QuarkusEmailService {

    @Inject
    private Mailer mailer;

    public void send(String to, String subject, String text) {
        mailer.send(Mail.withText(to, subject, text));
    }

}
