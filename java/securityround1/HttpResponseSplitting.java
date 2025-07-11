/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.http_response_splitting;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpResponseSplitting {
    // {fact rule=http-response-splitting@v1.0 defects=1}
    public void headerSplittingProtectionDisabledNoncompliant() {
        final DefaultHttpHeaders headers = new DefaultHttpHeaders(false);
        headers.clear();
    }
    // {/fact}

    // {fact rule=http-response-splitting@v1.0 defects=1}
    public void addToCookieWithoutSanitizationNoncompliant(HttpServletRequest request, HttpServletResponse response) {
        final String name = request.getParameter("name");
        Cookie cookie = new Cookie("name", name);
        cookie.setSecure(true);
        response.addCookie(cookie);
    }
    // {/fact}

}
