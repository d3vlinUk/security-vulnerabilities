/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.path_traversal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class PathTraversal {

    // {fact rule=path-traversal@v1.0 defects=1}
    public void createFileNoncompliant(HttpServletRequest request, HttpServletResponse response) {
        String basePath = "/var/data/images/";
        String desiredCategory = request.getParameter("category");
        File fileTarget = new File(basePath + desiredCategory);
    }
    // {/fact}

}
