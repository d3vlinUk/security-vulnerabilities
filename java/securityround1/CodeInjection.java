/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package detectors.code_injection;

import javax.servlet.http.HttpServletRequest;
import javax.script.ScriptException;
import javax.script.ScriptEngineManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import javax.script.ScriptEngine;

public class CodeInjection {

    // {fact rule=code-injection@v1.0 defects=1}
    public void evaluateJavaScriptNoncompliant(HttpServletRequest request) throws ScriptException {
        final String parameter = request.getParameter("parameter");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(parameter);
    }
    // {/fact}

}
