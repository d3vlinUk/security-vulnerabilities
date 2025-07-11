#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: Apache-2.0

# {fact rule=module-injection@v1.0 defects=1}
def module_injection_noncompliant():
    import importlib
    module_name = input('module name')
    importlib.import_module(module_name)
# {/fact}
