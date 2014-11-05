<%@ include file="/WEB-INF/header.jspf" %>
<form method="post" action="<c:url value="/login"/>" class="form-horizontal" >
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<p>${connexionImpossible}</p>
<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="EmailID">E-mail adress</label>
  <div class="controls">
    <input id="EmailID" name="EmailID" type="email" placeholder="Enter your e-mail" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label" for="PasswordID">Password </label>
  <div class="controls">
    <input id="PasswordID" name="PasswordID" type="password" placeholder="Enter your password" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Button -->
<div class="control-group">
  <label class="control-label" for="validRegister"></label>
  <div class="controls">
    <button id="validRegister" name="validRegister" class="btn btn-primary">Valid</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="/WEB-INF/footer.jspf" %>