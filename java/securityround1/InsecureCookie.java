/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.insecure_cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class InsecureCookie {
    // {fact rule=insecure-cookie@v1.0 defects=1}
    public static void cookieInsecureByDefaultNoncompliant(HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "value");
        response.addCookie(cookie);
    }
    // {/fact}

}
