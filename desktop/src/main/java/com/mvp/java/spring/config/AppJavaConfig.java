/*
 * Copyright (c) 2021 GreatApps4you LLC
 * This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package com.mvp.java.spring.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppJavaConfig {
    
    @Bean(name = "stringPrintWriter") @Scope("prototype")
    public PrintWriter printWriter(){
        // useful when dumping stack trace to file
        return new PrintWriter(new StringWriter());
    }

}
