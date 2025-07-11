#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=untrusted-deserialization@v1.0 defects=1}
def untrusted_deserialization_noncompliant():
    import jsonpickle
    userobj = input("user")
    obj = jsonpickle.decode(userobj)
    return obj
# {/fact}
