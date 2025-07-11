#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

import tarfile
from flask import Flask, request
app = Flask(__name__)


# {fact rule=zip-bomb-attack@v1.0 defects=1}
@app.route('/someUrl')
def zip_bomb_attack_noncompliant():
    file = request.files['file']
    filename = file.filename
    file.save(filename)
    tfile = tarfile.open(filename)
    tfile.extractall('./tmp/')
    tfile.close()
# {/fact}

