#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=xpath-injection@v1.0 defects=1}
from flask import request, app


@app.route('/user')
def find_users_noncompliant():
    from flask import request
    import xml.etree.ElementTree as ET
    tree = ET.parse('users.xml')
    root = tree.getroot()
    username = request.args['username']
    query = "./users/user/[@name='"+username+"']/location"
    elements = root.findall(query)
    return 'Location %s' % list(elements)
# {/fact}

