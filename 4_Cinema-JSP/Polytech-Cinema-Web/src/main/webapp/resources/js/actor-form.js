function checkInputs() {
	var error = false;
	
    if (document.actorForm.lastname.value == "") {
	    	alert("Please enter your last name");
	    	error = true;
    }
    
    if (document.actorForm.firstname.value == "") {
	    	alert("Please enter your first name");
	    	error = true;
    }
    
    return !error;
}