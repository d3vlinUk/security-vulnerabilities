/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.untrusted_deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class UntrustedDeserialization {
    // {fact rule=untrusted-deserialization@v1.0 defects=1}
    public List ObjectMapperNoncompliant(final File input) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        return mapper.readValue(input, List.class);
    }
    // {/fact}

}
