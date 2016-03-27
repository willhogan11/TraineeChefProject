// Pop up window code that triggers the launch of the 'AddIngredients.html' page
function popup(mylink, windowname) { 
	if (! window.focus)
		return true; 
		var href; 
	if (typeof(mylink) == 'string') 
		href = mylink; 
	else 
		href = mylink.href; 
	window.open(href, windowname, 'width=1000, height=600, scrollbars=yes'); 
	return false; 
}





// Add Ingredient on page when "+" button is clicked
function addIngredient() {
    var ingredient = document.getElementById("myText").value;
    document.getElementById("demo").innerHTML = ingredient;
}





// Function to Check if Input is Valid
function validateFunc(){
	var x;
	x = document.getElementById("age").value;
	if( isNaN(x) || x < 1 || x > 20 ){
		window.alert("Input is Not Valid");
		document.getElementById("age").value = "";
	}
} // End of validateFunc()


function validateForm() {
    var x = document.forms["submitForm"]["name"].value;
    var y = document.forms["submitForm"]["surname"].value;
    var z = document.forms["submitForm"]["age"].value;
    
    if ( (x == null || x == "") || (y == null || y == "") (z == null || z == "") ){
        alert("Form Must be Filled out Correctly");
        return false;
    }
}


// Return result of page to main page (W.I.P)
function HandlePopupResult(result) {
    alert("result of popup is: " + result);
}
