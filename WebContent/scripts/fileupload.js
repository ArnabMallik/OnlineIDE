/**
 * 
 */

$('#fileUploadform').validate (
		
   {
	   
	   rules: {
		   
		   program: {
			   
			   required:true,
			   
			   extension:'java,cpp,c',
			   
			   uploadfile:true
		   }
		   
	   }
	  
	  
		  
	  
  }

);


