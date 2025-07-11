/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.insecure_cors_policy;

import javax.servlet.http.HttpServletResponse;

public class InsecureCorsPolicy {
    // {fact rule=insecure-cors-policy@v1.0 defects=1}
    public void allowOriginNoncompliant(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }
    // {/fact}

}
