
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