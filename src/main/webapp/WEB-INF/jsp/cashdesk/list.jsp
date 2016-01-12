<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<myTag:webTemplate title="Lista de Caixas">

    <myTag:alertMessages alert="${alertHelper}" />

    <div class="col-md-12">

        <h1>Listagem de caixas</h1>
        <p>Nesta pagina encontra-se os caixas, cada caixa criado tem sua próprias transações financeiras, clique no nome do caixa para visualizar todas as movimentações.</p>
        
        
        <myTag:paginator page="${cashDesks}" url='${spring:mvcUrl("CDC#list").build()}'/>

        <div class="panel panel-default">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Caixa</th>
                        <th>Descrição</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cashDesks.content}" var="cash">
                        <tr id="cash-${cash.id}">
                            <td><a href="${spring:mvcUrl("CDC#detail").build()}${cash.name}">${cash.name}</a></td>
                            <td>${cash.description}</td>
                            <td>
                                <div class="btn-group">
                                    <a href='${spring:mvcUrl("CDC#saveForm").build()}?id=${cash.id}' class="btn btn-sm btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a class="btn btn-sm btn-danger" onclick="remover(${cash.id})"><span class="glyphicon glyphicon-remove-circle"></span></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script>

        function remover(id){
           if(confirm("Deseja realmente apagar esta caixa? todas transações serão perdidas!")){
                $.ajax({
                    url:"/cash-desk/" + id,
                    method:'DELETE'
                }).done(function (msg){
                    $('#cash-'+id).remove();
                    alert(msg);
                });
            }
        }
    </script>

</myTag:webTemplate>
