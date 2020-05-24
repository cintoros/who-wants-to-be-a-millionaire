<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<div class="nav navbar" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th style="max-width: 6rem">Question Text</th>
        <th style="max-width: 6rem">Correct</th>
        <th style="max-width: 6rem">Second Answer</th>
        <th style="max-width: 6rem">Third Answer</th>
        <th style="max-width: 6rem">Fourth Answer</th>
        <th style="max-width: 6rem">Action</th>
    </tr>
    </thead>
    <tbody>
    <g:each status="i" var="question" in="${questions}">
        <tr>
            <td>
                <div class="d-inline-block text-truncate" style="max-width: 20rem">
                    <a class="btn btn-link btn-sm" href="/question/show/${question.id}">
                        #${question.id} ${question.questionText}
                    </a>
                </div>
            </td>
            <td>
                <div class="d-inline-block text-truncate" style="min-width: 3rem; max-width: 8.5rem">
                    ${question.correct}
                </div>
            </td>
            <td>
                <div class="d-inline-block text-truncate" style="min-width: 3rem; max-width: 8.5rem">
                    ${question.second}
                </div>
            </td>
            <td>
                <div class="d-inline-block text-truncate" style="min-width: 3rem; max-width: 8.5rem">
                    ${question.third}
                </div>
            </td>
            <td>
                <div class="d-inline-block text-truncate" style="min-width: 5rem; max-width: 8.5rem">
                    ${question.fourth}
                </div>
            </td>
            <td>

                <form method="post" action="/question/delete/${question.id}">
                    <a class="btn btn-outline-info btn-sm" href="/question/show/${question.id}">Show</a>
                    <a class="btn btn-outline-info btn-sm" href="/question/edit/${question.id}">Edit</a>

                    <input type="hidden" name="_method" value="DELETE" id="_method${i}"/>
                    <input type="submit" class="save btn btn-outline-danger btn-sm" name="delete${i}" value="Delete"
                           onclick="return confirm('Are you sure?');" id="delete${i}"/>
                </form>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>