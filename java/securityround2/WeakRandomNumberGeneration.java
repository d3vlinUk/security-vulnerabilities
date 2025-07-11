/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.weak_random_number_generation;

import java.security.SecureRandom;

public class WeakRandomNumberGeneration {
    // {fact rule=weak-random-number-generation@v1.0 defects=1}
    static void secureRandomSpecificAlgorithmNoncompliant() throws Exception {
        final String ALGORITHM_NAME = "DES";
        SecureRandom generator = SecureRandom.getInstance(ALGORITHM_NAME);
        System.out.println(generator.nextInt());
    }
    // {/fact}

}
