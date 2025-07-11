/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.ldap_injection;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.naming.NamingEnumeration;

public class LdapInjection {

    // {fact rule=ldap-injection@v1.0 defects=1}
    public void ldapSearchNoncompliant(HttpServletRequest request) {
        try {
            DirContext directoryContext = new InitialDirContext();
            SearchControls controls = new SearchControls();
            final String filter = request.getParameter("filter");
            Object[] args = new Object[]{"Some object"};
            String base = "some base";
            NamingEnumeration<SearchResult> results =
                    directoryContext.search(base, filter, args, controls);
            System.out.println(results);
        } catch (NamingException e) {
            System.out.println(e);
        }
    }
    // {/fact}
}
