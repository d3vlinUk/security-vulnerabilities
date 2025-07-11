/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.ldap_authentication;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class LdapAuthentication {

    // {fact rule=ldap-authentication@v1.0 defects=1}
    public void createDirContextNoncompliant(String password) throws NamingException {
        Hashtable<String, Object> environment = new Hashtable<>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "ldap context factory");
        environment.put(Context.PROVIDER_URL, "context provider url");
        environment.put(Context.SECURITY_AUTHENTICATION, "none");
        DirContext dirContext = new InitialDirContext(environment);
    }
    // {/fact}

}
