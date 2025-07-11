/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.insecure_connection;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsecureConnection {

    // {fact rule=insecure-connection@v1.0 defects=1}
    public void createConnectionNoncompliant() {
        try {
            URL url = new URL("http://www.example.com/");
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.connect();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    // {/fact}

}
