function checkInputs() {
	var error = false;
	
    if (document.movieForm.title.value == "") {
	    	alert("Please enter your title");
	    	error = true;
    }
    
    if (document.movieForm.duration.value == "") {
	    	alert("Please enter your duration");
	    	error = true;
    }
    
    if (document.movieForm.releaseDate.value == "") {
	    	alert("Please enter your release date");
	    	error = true;
	}
    
    if (document.movieForm.budget.value == "") {
	    	alert("Please enter your budget");
	    	error = true;
	}
    
    if (document.movieForm.amountOfRevenue.value == "") {
	    	alert("Please enter your amount of revenue");
	    	error = true;
	}
    
    if (document.movieForm.directorId.value == "") {
	    	alert("Please enter your director");
	    	error = true;
	}
    
    if (document.movieForm.categoryId.value == "") {
	    	alert("Please enter your category");
	    	error = true;
	}
    
    return !error;
}