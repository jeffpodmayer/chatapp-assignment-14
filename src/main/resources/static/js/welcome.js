//prompts the user for thier username
console.log("Reading script.")
var username = sessionStorage.getItem('username');

if (!username) {
	console.log("Prompting for username.")
	username = prompt("Enter your username: ");
	sessionStorage.setItem('username', username);
	alert("Welcome back, " + username);
} else {
	alert("Welcome back, " + username);
}

createUser();

//this gets called after the initial logic is completed
function createUser() {
	fetch(`/createUser`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(username)
	})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
		});

}


//creates a channel named General Channel
//function createChannel(channelName){
//	fetch(`/createChannel/${channelName}`, {
//    method: "POST"
//    })
//    .then((response) => response.json())
//    .then((data) => {
//        const channelId = data.channelId;
//        window.location.href = `/channel/${channelId}`
//        console.log(data);
//    });
//	
//}

//Karen's example JavaScript

//const messageForm = document.getElementById("messageForm");
//    messageForm.addEventListener("submit", function(event) {
//        event.preventDefault();
//        const content = messageInput.value.trim();
//        if (content) {
//            const message = { sender: user, content };
//            fetch(`/channels/${channelName}/sendMessage`, {
//                method: "POST",
//                headers: {
//                    "Content-Type": "application/json"
//var name = sessionStorage.getItem("userName");
//
//	if (name) {
//		alert("Welcome back, " + name + "!");
//	} else {
//		name = prompt("Please enter your name", "John Doe");
//		if (name) {
//
//			sessionStorage.setItem("userName", name);
//			alert("Welcome, " + name + "!");
//		} else {
//			alert("Welcome!");
//		}
//	}




//TO MAKE EACH TAB SESSION INDPENDENT --> From ChatGPT
//var sessionId = sessionStorage.getItem('sessionId');
//if (!sessionId) {
//    sessionId = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);
//    sessionStorage.setItem('sessionId', sessionId);
//}
//
//// Use the session ID in the storage key
//var username = sessionStorage.getItem('username_' + sessionId);
//
//if (!username) {
//    console.log("Prompting for username.");
//    username = prompt("Enter your username:");
//    sessionStorage.setItem('username_' + sessionId, username);
//    alert("Welcome back, " + username);
//} else {
//    alert("Welcome back, " + username);
//}
//
//createUser();




