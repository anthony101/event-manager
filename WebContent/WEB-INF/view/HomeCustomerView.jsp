<%@ include file="/WEB-INF/header.jspf" %>
<p>Bonjour ${authentification.customerFirstname} ${authentification.customerLastname} ! :)</p>

<p><a class="btn btn-lg btn-success" href="<c:url value="/event/new" />" role="button">New Event</a></p>

<p>Liste de tes événements : </p>

<ul>
<c:forEach items="${listOfCreatedEvent}" var="event"> 
	<li><a href="<c:url value="/event/${event.eventId}" />">${event.eventName} at ${event.eventLocation}</a></li>
</c:forEach>
</ul>


<%@ include file="/WEB-INF/footer.jspf" %>