var ingredientDetails = [];
var cookiesArray = [];
var jsonString;
var jsonParse;

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


function storeIngredientDetails(concatDetails){
	ingredientDetails.push(concatDetails);	
}


String.prototype.escapeSpecialChars = function() {
    return this.replace(/\\n/g, "\\n")
               .replace(/\\'/g, "\\'")
               .replace(/\\"/g, '\\"')
               .replace(/\\&/g, "\\&")
               .replace(/\\r/g, "\\r")
               .replace(/\\t/g, "\\t")
               .replace(/\\b/g, "\\b")
               .replace(/\\f/g, "\\f");
};

/*function getCookie(){
	
    cookiesSplitArray = document.cookie.split("; ");
    
	   
    for(var i=0; i < cookiesArray.length; i++){
    	// var returnedValue = cookiesArray[i].split("; ");
    	
    	// document.getElementById("concatResult").value = cookiesArray[i];
    	
    	document.getElementById("tableDetailsID").innerHTML = cookiesArray[0];
    	console.log(cookiesArray[i]);
	} 
}*/

function getCookie(){
	for(var i=0; i < 10; i++){
		jsonString = document.cookie.split(",");
	}
	
	jsonParse = JSON.parse(jsonString);
	document.getElementById("tableDetailsID").innerHTML = jsonParse;
}

window.onunload = unloadPage;
function unloadPage(){
	console.log("unload event fired!");
	getCookie();
}

/*function setCookie(){
	jsonString = JSON.stringify(ingredientDetails);
	document.cookie = jsonString;
}*/



// Function that concatenates each Ingredients Item, Measurement Type & Quantity
function concatIngred(){
	
	// Create Variables to get the elements by ID, then concatenate them
	var item = "[Item]: " + document.getElementById("item").value + " "
	var measure = "[Measure]: " + document.getElementById("measure").value + " "
	var quantity = "[Quantity]: " + parseInt(document.getElementById("quantity").value);
	var concatDetails = item + measure + quantity;
	
	ingredientDetails.push(concatDetails);
		// setCookie();
	
	jsonString = JSON.stringify(ingredientDetails);
	document.cookie = jsonString;

	// Create a New Node to keep visual track of all entered Ingredients details
	var paragraph = document.createElement("p");
	var node = document.createTextNode(concatDetails);
	paragraph.appendChild(node);
	var element = document.getElementById("tableDetailsID");
	element.appendChild(paragraph);
	
} // End Function




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
/*function HandlePopupResult(result) {
    alert("result of popup is: " + result);
}*/
