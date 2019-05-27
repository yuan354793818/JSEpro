<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><html>
<body>
<% pageContext.setAttribute("aa",false);
  request.getServletContext().setAttribute("bb",true);
   %>
<c:if test="${!bb}">
    <c:out value="sdsd"></c:out>
    ${pageScope.entrySet()}
</c:if>
</body>
</html>
