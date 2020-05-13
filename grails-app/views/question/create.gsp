<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}"/>
    <title>Create a Question</title>
</head>

<body>
<a href="#create-question" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<!-- create a question form -->
%{--EXTERNAL: form layouting from this example: https://www.codeply.com/p/xjn4SoQjD6--}%
<div class="card card-outline-secondary">
    <div class="card-header">
        <h3 class="mb-0">Create a Question</h3>
    </div>

    <div class="card-body" role="main">
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${this.question}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.question}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                            error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>

        <g:form resource="${this.question}" method="POST">
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Question Text</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.questionText}"
                                 name="questionText" />
                </div>
            </div>

            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Correct Answer</label>

                <div class="col-lg-9">
                    <g:textField class="form-control" type="text" value="${this.question.correct}" name="correct"
                                 required="required"/>
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
                    <input type="reset" class="btn btn-secondary" value="Cancel">
                    <g:submitButton class="save btn btn-primary" name="create" value="Save Changes"/>
                </div>
            </div>
        </g:form>

    </div>
</div>
</body>
</html>
