/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.os_command_injection;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class OsCommandInjection {

    // {fact rule=os-command-injection@v1.0 defects=1}
    public void createProcessNoncompliant(HttpServletRequest request) {
        String favoriteColor = request.getParameter("favoriteColor");
        ProcessBuilder pb = new ProcessBuilder("/usr/local/bin/program", "--color", favoriteColor);
        try {
            pb.start();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    // {/fact}
}
