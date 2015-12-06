<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ attribute name="alert" required="true" type="br.com.romani.helpers.AlertHelper" %>

<c:if test="${not empty alert.successMsg}">
    <div class="alert alert-success">
            ${alert.successMsg}
    </div>
</c:if>

<c:if test="${not empty alert.errorMsg}">
    <div class="alert alert-danger">
            ${alert.errorMsg}
    </div>
</c:if>
