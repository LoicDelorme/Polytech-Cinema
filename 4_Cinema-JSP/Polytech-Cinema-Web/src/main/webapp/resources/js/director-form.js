function checkInputs() {
	var error = false;
	
    if (document.directorForm.lastname.value == "") {
	    	alert("Please enter your last name");
	    	error = true;
    }
    
    if (document.directorForm.firstname.value == "") {
	    	alert("Please enter your first name");
	    	error = true;
    }
    
    return !error;
}