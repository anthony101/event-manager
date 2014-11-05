<%@ include file="/WEB-INF/header.jspf" %>

<ul class="list-group">
  <li class="list-group-item">Name : ${event.eventName}</li>
  <li class="list-group-item">Location : ${event.eventLocation}</li>
  <li class="list-group-item">Start : ${event.eventStartDatetime} / End : ${event.eventEndDatetime}</li>
</ul>

<p>
<a href="<c:url value="/event/subscribe/${event.eventId}" />">Subscribe</a>
<p>

<%@ include file="/WEB-INF/footer.jspf" %>