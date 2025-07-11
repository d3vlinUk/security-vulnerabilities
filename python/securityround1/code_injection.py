
#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=code-injection@v1.0 defects=1}
from flask import app


@app.route('/')
def execute_input_noncompliant():
    from flask import request
    module_version = request.args.get("module_version")
    exec("import urllib%s as urllib" % module_version)
# {/fact}


