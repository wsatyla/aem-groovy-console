package com.icfolson.aem.groovy.console.api.impl

import com.icfolson.aem.groovy.console.api.context.ServletScriptContext
import groovy.transform.TupleConstructor
import org.apache.sling.api.SlingHttpServletRequest
import org.apache.sling.api.SlingHttpServletResponse
import org.apache.sling.api.resource.ResourceResolver

import static com.icfolson.aem.groovy.console.constants.GroovyConsoleConstants.DATA

/**
 * Script context for request-based (i.e. via the console) script executions.
 */
@TupleConstructor
class RequestScriptContext implements ServletScriptContext {

    SlingHttpServletRequest request

    SlingHttpServletResponse response

    ByteArrayOutputStream outputStream

    PrintStream printStream

    String script

    @Override
    ResourceResolver getResourceResolver() {
        request.resourceResolver
    }

    @Override
    String getUserId() {
        request.resourceResolver.userID
    }

    @Override
    String getData() {
        request.getParameter(DATA)
    }
}
