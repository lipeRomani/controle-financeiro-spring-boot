<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="url" required="true"%>
<%@ attribute name="size" required="false" type="java.lang.Integer" %>

<!-- Paginacao incio -->
<c:if test="${page.totalPages > 0}">
    <nav>
        <ul class="pagination">

            <!-- Previus buttom -->
            <c:set var="previusPage" value="${page.number - 1}" />
            <c:choose>
                <c:when test="${previusPage < 0}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${previusPage >= 0}">
                    <spring:url value='${url}' var="previus">
                        <spring:param name="page" value="${previusPage}"></spring:param>
                        <c:if test="${not empty size}">
                            <spring:param name="size" value="${size}"></spring:param>
                        </c:if>
                    </spring:url>
                    <li>
                        <a href="${previus}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:when>
            </c:choose>

            <!-- Number buttoms -->
            <c:forEach var="i" begin="0" end="${page.totalPages - 1}">
                <spring:url value='${url}' var="nextNumber">
                    <spring:param name="page" value="${i}"></spring:param>
                    <c:if test="${not empty size}">
                        <spring:param name="size" value="${size}"></spring:param>
                    </c:if>
                </spring:url>

                <c:choose>
                    <c:when test="${i eq page.number}">
                        <li class="active"><a href="${nextNumber}">${i}</a></li>
                    </c:when>
                    <c:when test="${i ne page.number}">
                        <li><a href="${nextNumber}">${i}</a></li>
                    </c:when>
                </c:choose>

            </c:forEach>

            <!-- Next buttom -->
            <c:set var="nextPage" value="${page.number + 1}" />
            <c:choose>
                <c:when test="${nextPage >= page.totalPages}">
                    <li class="disabled">
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
                <c:when test="${nextPage <= page.totalPages}">
                    <li>
                        <spring:url value='${url}' var="next">
                            <spring:param name="page" value="${nextPage}" />
                            <c:if test="${not empty size}">
                                <spring:param name="size" value="${size}"></spring:param>
                            </c:if>
                        </spring:url>
                        <a href="${next}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:when>
            </c:choose>
        </ul>
    </nav>
</c:if>
<!-- Paginação fim-->