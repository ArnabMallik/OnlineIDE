/**
 * 
 */

$(document).ready(
		
  function() {
	  
	  var validator=new Validator("Gmailform");
	  
	validator.EnableOnPageErrorDisplaySingleBox();
	//validator.EnableOnPageErrorDisplay();
	  validator.EnableMsgsTogether();
	  
	  
	  
	  
	  validator.addValidation("fname", "req", "Enter firstname");
	  validator.addValidation("lname", "req", "Enter lastname");
	  validator.addValidation("uname","email");
	  validator.addValidation("pwd", "minlen=8");
	  
	  
	   
	  
	   
  }


);




