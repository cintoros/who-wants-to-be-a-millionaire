<%@ page import="org.springframework.validation.FieldError" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title>Edit Question</title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

%{--Very Similar to create.gsp--}%
<div class="card card-outline-secondary">
    <div class="card-header">
        <h3 class="mb-1">Edit a Question</h3>
    </div>

    <div class="card-body" role="main">

        <g:hasErrors bean="${this.question}">
            <g:eachError bean="${this.question}" var="error">
                <div <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>>
                    <div class="alert alert-danger alert-dismissible fade show" role="status"><g:message error="${error}"/></div>
                </div>
            </g:eachError>
        </g:hasErrors>

        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>

        <g:form resource="${this.question}" method="PUT">
            <g:hiddenField name="version" value="${this.question?.version}"/>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Question Text</label>
                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.questionText}"
                                 name="questionText" required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Correct Answer</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.correct}" name="correct" required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Second Answer</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.second}" name="second"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Third Answer</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.third}" name="third"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Fourth Answer</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.fourth}" name="fourth"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label"></label>
                <div class="col-lg-9">
                    <g:submitButton class="save btn btn-primary" name="create" value="Update Changes"/>
                </div>
            </div>
        </g:form>

    </div>
</div>


</body>
</html>
