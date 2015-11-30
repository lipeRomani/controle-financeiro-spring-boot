<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTag"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<myTag:webTemplate title="Lista de transações">

    <div class="col-md-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Valor</th>
                <th>Fluxo</th>
                <th>Caixa</th>
            </tr>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>

</myTag:webTemplate>