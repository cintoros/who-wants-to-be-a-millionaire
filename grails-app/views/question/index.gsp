<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

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
        <th>Question Text</th>
        <th>Correct</th>
        <th>Second Answer</th>
        <th>Third Answer</th>
        <th>Fourth Answer</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <g:each status="i" var="question" in="${questions}">
        <tr>
            <td>
                %{-- TODO change max-width?--}%
                <div class="d-inline-block text-truncate" style="max-width: 40rem">
                    <a class="btn btn-link btn-sm" href="/question/show/${question.id}">
                        #${question.id} ${question.questionText}
                    </a>
                </div>
            </td>
            <td>${question.correct}</td>
            <td>${question.second}</td>
            <td>${question.third}</td>
            <td>${question.fourth}</td>
            <td>
                <g:form resource="${question}" method="DELETE">
                    <a class="btn btn-outline-info btn-sm" href="/question/show/${question.id}">Show</a>
                    <a class="btn btn-outline-info btn-sm" href="/question/edit/${question.id}">Edit</a>

                    <g:submitButton class="save btn btn-outline-danger btn-sm" name="delete"
                                    value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
                </g:form>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>


%{--<div class="pagination">--}%
%{--    <g:paginate total="${questionCount ?: 0}"/>--}%
%{--</div>--}%
</body>
</html>