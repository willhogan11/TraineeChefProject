var ingredientDetails = [];
var cookiesArray = [];
var jsonString;
var jsonParse;


function popup(mylink, windowname) { 
	if (! window.focus)
		return true; 
		var href; 
	if (typeof(mylink) == 'string') 
		href = mylink; 
	else 
		href = mylink.href; 
	window.open(href, windowname, 'width=700, height=600, scrollbars=yes'); 
	return false; 
}


//Pop up window code that triggers the launch of the 'AddIngredients.html' page
function addIngredientsPopUp(param){
	var x = screen.width/2 - 700/2;
	var y = screen.height/2 - 550/2;
	window.open(param.href, 'sharegplus','height=485,width=700,left='+x+',top='+y);
}


// Close the Pop up window
function closePopUp(){
	window.close();
}

// Function to Clear localStorage upon page load
function clearLocalStorage(){
	localStorage.clear();
}

// Function to setLocalStorage 
function setLocalStorage(){
	jsonString = JSON.stringify(ingredientDetails);
	localStorage.setItem("jsonString", jsonString);
}

// Function to getLocalStorage
function getLocalStorage(){
	var tempString = localStorage.getItem("jsonString");
	jsonParse = JSON.parse(tempString);
	document.getElementById("ingredientsReturned").innerHTML = jsonParse;
}


// Function to store details of Each ingredient in an Array
function storeIngredientDetails(concatDetails){
	ingredientDetails.push(concatDetails);	
}


// Function that concatenates each Ingredients Item, Measurement Type & Quantity
function concatIngred() {
	
	// Create Variables to get the elements by ID, then concatenate them
	var quantity = parseInt(document.getElementById("quantity").value) + " ";
	var measure = document.getElementById("measure").value + " ";
	var item = document.getElementById("item").value;
	var concatDetails = quantity + measure + item;

	// Store value in function and launch setLocalStorage function to store json string
	storeIngredientDetails(concatDetails);
	setLocalStorage();

	// Create a New Node to keep visual track of all entered Ingredients details
	var paragraph = document.createElement("p");
	var node = document.createTextNode(concatDetails);
	paragraph.appendChild(node);
	var element = document.getElementById("tableDetailsID");
	element.appendChild(paragraph);
	
} // End Function



// Function to get and display the session details in the HTML text boxes in the RecipeEntry page
function getSessionName(){
	var retrieveSession = sessionStorage.getItem("name");
	
	if(sessionStorage.length == 0){
		
		document.getElementById("sessionName").innerHTML = "No Name"
		document.getElementById("sessionSurname").innerHTML = "No Surname";
	}
	else{
		var nameSplit = retrieveSession.split(" ");
		document.getElementById("sessionName").innerHTML = nameSplit[0];
		document.getElementById("sessionSurname").innerHTML = nameSplit[1];
	}
}


// Function to Check if Input is Valid
function validateFunc(){
	var x;
	x = document.getElementById("ingredientsReturned").value;
	if( isNaN(x) || x < 1 || x > 20 ){
		window.alert("Input is Not Valid");
		document.getElementById("ingredientsReturned").value = "";
	}
} // End of validateFunc()



// Function to Validate form onsubmit
// Will stop the POST method and inform the user to insert correct information
function validateForm() {
	
	// Recipe Entry Form
    var ingredRet = document.forms["submitForm"]["ingredientsReturned"].value;
    var foodTypeSelect = document.forms["submitForm"]["foodType"].value;
    var foodOrigin = document.forms["submitForm"]["foodOrigin"].value;
    var prepTimeHours = document.forms["submitForm"]["prepTimeHours"].value;
    var prepTimeMins = document.forms["submitForm"]["prepTimeMins"].value;
    
    if ( (ingredRet == null) || (ingredRet == "") || (foodTypeSelect == "-Select-") ||
    	 (foodOrigin == "-Select-") || (prepTimeHours == "-Select-") || (prepTimeMins == "-Select-") ) {     
	    		alert("You have left some fields blank");
		        return false;
    }
}

// Function to validate the AddIngredients form
// If Valid values entered, Concatenate the ingredients into a string
function validateIngredients(){
	
	// Add Ingredients Form
    var itemTypeSelect = document.getElementById("item").value;
    var measureTypeSelect = document.getElementById("measure").value;
    var quantity = document.getElementById("quantity").value;
    
    if ( (itemTypeSelect == "-Select-") || (measureTypeSelect == "-Select-") || (quantity == "-Select-") ) {     
   	    		alert("You have left some fields blank");
   		        return false;
       }
    else {
    	concatIngred();
    }
}



// Used for Parsing
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