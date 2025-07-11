/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.cross_site_request_forgery;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class CrossSiteRequestForgery {

    // {fact rule=cross-site-request-forgery@v1.0 defects=1}
    public void configureCsrfNoncompliant(HttpSecurity security) throws Exception {
        security.csrf().disable();
    }
    // {/fact}

}
