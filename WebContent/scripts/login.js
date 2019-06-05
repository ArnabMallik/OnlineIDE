/**
 * 
 */
$(document).ready(
		function() {
			
			var validator = new Validator("loginform");
			
			validator.EnableOnPageErrorDisplaySingleBox();
			//validator.EnableOnPageErrorDisplay();
		    validator.EnableMsgsTogether();
			
			validator.addValidation("username", "req", "please enter username");
			validator.addValidation("password", "req", "please enter password");
			
			
		
		}



);