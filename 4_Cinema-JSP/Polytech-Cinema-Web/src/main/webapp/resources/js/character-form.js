function checkInputs() {
	var error = false;
	
    if (document.characterForm.movieId.value == "") {
	    	alert("Please enter your movie");
	    	error = true;
    }
    
    if (document.characterForm.actorId.value == "") {
	    	alert("Please enter your actor");
	    	error = true;
    }
    
    if (document.characterForm.name.value == "") {
	    	alert("Please enter your name");
	    	error = true;
	}
    
    return !error;
}