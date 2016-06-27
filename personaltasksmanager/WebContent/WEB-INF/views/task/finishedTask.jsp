<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<td>${task.id}</td>
<td>${task.description}</td>
<td>Finished</td>
<td>
	<fmt:formatDate value="${task.finishedDate.time }" pattern="yyyy-MM-dd" />
</td>
<td>
	<a href="removeTask?id=${task.id}">Remove</a>
</td>
<td>
	<a href="showTask?id=${task.id}">Edit</a>
</td>	