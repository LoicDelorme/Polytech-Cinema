function checkInputs() {
	var error = false;
	
    if (document.categoryForm.restrictedLabel.value == "") {
	    	alert("Please enter your restricted label");
	    	error = true;
    }
    
    if (document.categoryForm.fullLabel.value == "") {
	    	alert("Please enter your full label");
	    	error = true;
    }
    
    return !error;
}