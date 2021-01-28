/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsaltes.desktop.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.PrintWriter;
import java.io.StringWriter;

@Configuration
public class AppJavaConfig {
    
    @Bean(name = "stringPrintWriter") @Scope("prototype")
    public PrintWriter printWriter(){
        return new PrintWriter(new StringWriter());
    }

}
