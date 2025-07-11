#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

import os
from os import name
from flask import request, Flask
import docker
app = Flask(name)


# {fact rule=docker-arbitrary-container-run@v1.0 defects=1}
@app.route('/someUrl')
def docker_arbitrary_container_run_noncompliant():
    client = docker.from_env()
    img = request.args.get("image")
    client.containers.run(img, 'echo non compliant')
# {/fact}
