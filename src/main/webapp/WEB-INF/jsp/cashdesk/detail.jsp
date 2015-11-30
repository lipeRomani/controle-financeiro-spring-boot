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
        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> Editar</button>
        <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-ok-circle"></span> Gráficos
        </button>
    </div>
    <hr/>

    <div class="col-md-8">
        <div class="panel panel-default">
            <table class="table">

            </table>
        </div>
    </div>
    <div class="col-md-4">

        <div class="panel panel-default">
            <div class="panel-heading">Adicionar Transação</div>
            <div class="panel-body">
                <form action="" method="post">
                    <div class="form-group">
                        <label for="value">Valor</label>
                        <input name="value" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="flow">Fluxo</label>
                        <select name="flow" class="form-control">

                        </select>
                    </div>

                    <input type="hidden" name="cashDeskId" value="${cashDesk.id}" />

                    <div class="form-group">
                        <label for="description">Descrição</label>
                        <textarea name="value" class="form-control"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

</myTag:webTemplate>
