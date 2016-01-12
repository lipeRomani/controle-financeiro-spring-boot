<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<myTag:webTemplate title="Detalhe Caixa">

    <myTag:alertMessages alert="${alertHelper}" />

    <h1>${cashDesk.name}</h1>

    <p>${cashDesk.description}</p>

    <div class="btn-group" role="group" aria-label="...">
        <a href="${spring:mvcUrl("CDC#saveForm").build()}?id=${cashDesk.id}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> Editar</a>
        <a href="${spring:mvcUrl("TC#saveForm").build()}${cashDesk.id}" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span> Nova Transação</a>
    </div>
    <hr/>

    <div class="col-md-12">

        <div class="panel panel-default">
            <table class="table table-responsive">
                <tr>
                    <th>Valor</th>
                    <th>Fluxo</th>
                    <th>Tipo</th>
                    <th>Descrição</th>
                    <th>Data</th>
                    <th>Ações</th>
                </tr>
                <fmt:setLocale value="pt_BR" />
                <c:forEach items="${transactions.content}" var="transaction">
                    <tr>
                        <td><fmt:formatNumber value="${transaction.value}" type="currency"/></td>
                        <td>${transaction.flow.description}</td>
                        <td>${transaction.transactionType.name}</td>
                        <td>${transaction.description}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${transaction.date.time}"/></td>
                        <td>
                            <a href="" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-transfer" data-toggle="tooltip" data-placement="top" title="Enviar transação para outro caixa"></span>
                            </a>
                            <a href="" data-toggle="tooltip" data-placement="top" title="Apagar transação">
                                <span class="glyphicon glyphicon-remove-circle"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Selecione o caixa de destino</h4>
                </div>
                <div class="modal-body">
                    <p>
                        Selecione o nome do caixa para qual essa transação seria enviada.
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-transfer"></span> Transferir</button>
                </div>
            </div>
        </div>
    </div>

</myTag:webTemplate>
