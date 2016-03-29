var ingredientDetails = [];

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


// Test Alert
function successAlert() {
    alert("Successfully added");
}


// Add Ingredient on page when "+" button is clicked
function addIngredient() {
    var ingredient = document.getElementById("myText").value;
    document.getElementById("demo").innerHTML = ingredient;
}


/*function storeIngredientDetails(concatDetails){
	ingredientDetails.push(concatDetails);	
}

var Functions = 
{
	DoThis: function(concatDetails)
	{
		ingredientDetails.push(concatDetails);
	}
};*/


// Function that concatenates each Ingredients Item, Measurement Type & Quantity
function concatIngred(){
	
	// Create Variables to get the elements by ID, then concatenate them
	var item = "[Item]: " + document.getElementById("item").value + " "
	var measure = "[Measure]: " + document.getElementById("measure").value + " "
	var quantity = "[Quantity]: " + parseInt(document.getElementById("quantity").value);
	var concatDetails = item + measure + quantity;
	
	console.log("Concat Details: " + concatDetails);
	ingredientDetails.push(concatDetails);
	
	ingredientDetails.join("|");
	// console.log(ingredientDetails);
	
	// document.cookie = 
	
	// console.log("Value of Function call: " + storeIngredientDetails(concatDetails));
	// console.log("Value of Anonymous Function call: " + Functions.DoThis());
	// storeIngredientDetails(concatDetails);
	// Functions.DoThis(concatDetails); // Testing
	
	
	// document.getElementById("concatResult").innerHTML = concatDetails;
	
	// Create a New Node to keep visual track of all entered Ingredients details
	var paragraph = document.createElement("p");
	var node = document.createTextNode(concatDetails);
	paragraph.appendChild(node);
	var element = document.getElementById("tableDetailsID");
	element.appendChild(paragraph);
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
