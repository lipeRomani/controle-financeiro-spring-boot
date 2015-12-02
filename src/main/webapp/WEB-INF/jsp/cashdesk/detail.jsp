<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<myTag:webTemplate title="Detalhe Caixa">

    <h1>${cashDesk.name}</h1>

    <p>${cashDesk.description}</p>

    <div class="btn-group" role="group" aria-label="...">
        <a href="${spring:mvcUrl("CDC#saveForm").build()}?id=${cashDesk.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
        <a href="${spring:mvcUrl("TC#saveForm").build()}${cashDesk.id}" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span> Nova Transação</a>
    </div>
    <hr/>

    <div class="col-md-8">
        <div class="panel panel-default">
            <table class="table">

            </table>
        </div>
    </div>
    <div class="col-md-4">


    </div>

</myTag:webTemplate>
