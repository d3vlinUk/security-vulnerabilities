#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=loose-file-permissions@v1.0 defects=1}
def change_file_permissions_noncompliant():
    import os
    import stat
    os.chmod("sample.txt", stat.S_IRWXU | stat.S_IRWXG | stat.S_IRWXO)
# {/fact}
