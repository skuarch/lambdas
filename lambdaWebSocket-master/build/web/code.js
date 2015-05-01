var socket = new WebSocket("ws://localhost:8080/LambdaWebSocketApp/lambdaWebSocket");

socket.onmessage = function (event) {
    var chatMessage = event.data;
    var substr = chatMessage.toString().substring(0,10);
    var color = chatMessage.toString().substr(11,15); 
    var toMatch = "background";
    console.log("message: " + chatMessage.toString() + chatMessage.toString().length);
    console.log("substr: " + substr + substr.length);
    console.log("color:" + color + color.length);
    if(substr === toMatch) {
        console.log("I entered here");
        document.body.style.backgroundColor = color;
    }
    else {
        var messageElement = document.getElementsByTagName("footer");
        messageElement[0].innerHTML = "<b>" + chatMessage + "<br>";
    }
};

function Person(givenName, surname, age, gender, email) {
		this.givenName = givenName;
                this.surname = surname;
		this.age = age;
		this.gender = gender;
                this.email = email;
} 

function sendMessage(e) {
    var givenName = document.getElementById("givenName");
    var surname = document.getElementById("surname");
    var age = document.getElementById("age");
    var gender = document.getElementById("gender");
    var email = document.getElementById("email");
    var person = new Person(givenName.value,surname.value,age.value,gender.value,email.value);
    console.log("person object:" + person.givenName + person.surname + person.age + person.gender + person.email);
    socket.send(JSON.stringify(person));
    document.getElementById("myFieldSet").disabled = "disabled";
    e.preventDefault();
}