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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.greatapps4you.greatsales.entities.registration.Email;
import us.greatapps4you.greatsales.repositories.EmailRepository;

import javax.inject.Inject;

@Service
public class EmailService {

    @Inject
    private Mailer mailer;
    @Autowired
    private EmailRepository repository;

    public boolean send(Email email) {
        try {
            repository.save(email);

            // for (String to : email.getTo()) {
            mailer.send(Mail.withText(email.getTo(),
                    email.getSubject(),
                    email.getText()));
            // }


            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
