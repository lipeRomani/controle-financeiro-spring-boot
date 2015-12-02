<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<myTag:webTemplate title="Novo Caixa">


    <div class="col-md-6">
        <h1>${cashDesk.name}</h1>
        <div class="panel panel-default">

            <div class="panel-heading">Inserir Transação</div>

            <div class="panel-body">
                <form:form commandName="transactionDto" action='${spring:mvcUrl("TC#saveData").build()}' method="POST">

                    <div class="form-group">
                        <form:label path="value">Valor</form:label>
                        <form:input cssClass="form-control" path="value"/>
                    </div>

                    <form:errors path="value" cssClass="alert alert-danger" element="p"></form:errors>


                    <div class="form-group">
                        <form:label path="flow">Fluxo da transação</form:label>
                        <form:select cssClass="form-control" path="flow">
                            <form:option value=""> - Selecione uma opção - </form:option>
                            <form:options items="${flowList}" />
                        </form:select>
                    </div>

                    <div class="form-group">
                        <form:label path="date">Data</form:label>
                        <form:input cssClass="form-control" path="date" />
                    </div>

                    <form:errors path="flow" cssClass="alert alert-danger" element="p"></form:errors>

                    <input type="hidden" name="cashDeskId" value="${cashDesk.id}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

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
