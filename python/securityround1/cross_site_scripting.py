#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=cross-site-scripting@v1.0 defects=1}
from flask import app


@app.route('/redirect')
def redirect_url_noncompliant():
    from flask import request, redirect
    endpoint = request.args['url']
    return redirect(endpoint)
# {/fact}

