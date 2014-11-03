<%@ include file="/WEB-INF/header.jspf" %>
<form method="post" action="<c:url value="/event"/>" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Create an event</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="NameID">Name</label>
  <div class="controls">
    <input id="NameID" name="NameID" type="text" placeholder="" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="LocationID">Location</label>
  <div class="controls">
    <input id="LocationID" name="LocationID" type="text" placeholder="" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="StartID">Start</label>
  <div class="controls">
    <input id="StartID" name="StartID" type="text" placeholder="10-12-14" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="EndID">End</label>
  <div class="controls">
    <input id="EndID" name="EndID" type="text" placeholder="11-12-14" class="input-xlarge" required="">
    <p class="help-block">help</p>
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="ValidID"></label>
  <div class="controls">
    <button id="ValidID" name="ValidID" class="btn btn-primary">Valid</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="/WEB-INF/footer.jspf" %>