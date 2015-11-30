<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<myTag:webTemplate title="Novo Caixa">


    <div class="col-md-6">
        <div class="panel panel-default">

            <c:choose>
                <c:when test="${not empty cashDesk.id}">
                    <div class="panel-heading">Atualizar caixa</div>
                </c:when>
                <c:when test="${empty cashDesk.id}">
                    <div class="panel-heading">Cadastro de caixa</div>
                </c:when>
            </c:choose>

            <div class="panel-body">
                <form:form commandName="cashDesk" action='${spring:mvcUrl("CDC#saveData").build()}' method="POST">

                    <c:if test="${not empty cashDesk.id}">
                        <input name="id" type="hidden" value="${cashDesk.id}" />
                    </c:if>

                    <div class="form-group">
                        <form:label path="name">Nome</form:label>
                        <form:input cssClass="form-control" path="name" />
                    </div>

                    <form:errors path="name" cssClass="alert alert-danger" element="p"></form:errors>



                    <div class="form-group">
                        <form:label path="description">Descrição</form:label>
                        <form:textarea cssClass="form-control" path="description" cols="2" rows="5" />
                    </div>

                    <form:errors path="description" cssClass="alert alert-danger" element="p"></form:errors>


                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                    <c:choose>
                        <c:when test="${not empty cashDesk.id}">
                            <input type="submit" value="Salvar Alterações" class="btn btn-primary">
                        </c:when>
                        <c:when test="${empty cashDesk.id}">
                            <input type="submit" value="Salvar Novo" class="btn btn-primary">
                        </c:when>
                    </c:choose>
                </form:form>
            </div>
        </div>
    </div>

</myTag:webTemplate>
