<%@ include file="/WEB-INF/header.jspf" %>
<form method="post" action="<c:url value="/register"/>" class="form-horizontal">

<fieldset>

<!-- Form Name -->
<legend>Register</legend>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="FirstNameID">First Name</label>
  <div class="controls">
    <input id="FirstNameID" name="FirstNameID" type="text" placeholder="" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="NameID">Last Name</label>
  <div class="controls">
    <input id="NameID" name="NameID" type="text" placeholder="" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="EmailID">E-mail</label>
  <div class="controls">
    <input id="EmailID" name="EmailID" type="text" placeholder="example@gmail.com" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="CompanyID">Company</label>
  <div class="controls">
    <input id="CompanyID" name="CompanyID" type="text" placeholder="" class="input-xlarge">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="PasswordID">Password</label>
  <div class="controls">
    <input id="PasswordID" name="PasswordID" type="password" placeholder="" class="input-xlarge" required="">
    
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