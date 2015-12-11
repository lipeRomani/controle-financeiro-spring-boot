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
                        <form:input cssClass="form-control" path="value" />
                    </div>
                    <form:errors path="value" cssClass="alert alert-danger" element="p"></form:errors>

                    <div class="form-group">
                        <form:label path="flow">Fluxo da transação</form:label>
                        <form:select cssClass="form-control" path="flow">
                            <form:option value=""> - Selecione uma opção - </form:option>
                            <form:options items="${flowList}" />
                        </form:select>
                    </div>
                    <form:errors path="flow" cssClass="alert alert-danger" element="p"></form:errors>

                    <div class="form-group">
                        <form:label path="typeId">Tipo da transação   <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal">Adicionar Tipo</a></form:label>
                        <form:select cssClass="form-control" id="type" path="typeId">
                            <form:option value=""> - Selecione um tipo - </form:option>
                            <form:options items="${typeList}" />
                        </form:select>
                    </div>
                    <form:errors path="typeId" cssClass="alert alert-danger" element="p"></form:errors>


                    <div class="form-group">
                        <form:label path="date">Data</form:label>
                        <form:input cssClass="form-control datetime-calendar" path="date" />
                    </div>
                    <form:errors path="date" cssClass="alert alert-danger" element="p"></form:errors>

                    <div class="form-group">
                        <form:label path="description">Descrição</form:label>
                        <form:textarea cssClass="form-control" path="description" rows="10" />
                    </div>
                    <form:errors path="description" cssClass="alert alert-danger" element="p"></form:errors>



                    <input type="hidden" name="cashDeskId" value="${cashDesk.id}"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <c:choose>
                        <c:when test="${not empty transaction.id}">
                            <input type="submit" value="Salvar Alterações" class="btn btn-primary">
                        </c:when>
                        <c:when test="${empty transaction.id}">
                            <input type="submit" value="Salvar Novo" class="btn btn-primary">
                        </c:when>
                    </c:choose>
                </form:form>
            </div>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Adicionar tipo de Transação</h4>
                </div>
                <div class="modal-body">
                    <p>
                        Escreve o nome da nova categoria de transações, em seguida clique em salvar para gravar e carregar na listagem de tipos no formulário de transações.
                    </p>
                        <div class="form-group" id="form-div-type">
                            <form id="type-form" name="transactionTypeDto">
                                <label for="type-name">Nome</label>
                                <input type="text" name="name" id="type-name" class="form-control" />
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-primary" id="save-btn" onclick="saveType()">Salvar</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        function saveType() {
            event.preventDefault();
            var field = $("#type-name");
            var boxForm = $("#form-div-type");
            var errorBox = $("#error-type");
            var modal = $("#myModal");
            var form = $("#type-form");
            var select = $("#type");

            //get form data in a json object and convert to string
            var info = form.serializeFormJSON();
            info = JSON.stringify(info);

            $.ajax({
                url: '/type',
                datatype: 'json',
                type: "post",
                contentType: "application/json",
                data: info,
                success: function (msg) {
                    field.val("");
                    console.log(msg);
                    if(msg.object.status == 400){
                       errorBox.remove();
                        boxForm.after("<p class='alert-danger alert' id='error-type'>" + msg.object.fields.name + "</p>")
                    }else{
                        errorBox.remove();
                        modal.modal('hide');
                        select.append("<option value = '" + msg.object.id + "'>" + msg.object.name + "</option>");
                        select.val(msg.object.id);
                    }
                }
            });
        }
    </script>

</myTag:webTemplate>
