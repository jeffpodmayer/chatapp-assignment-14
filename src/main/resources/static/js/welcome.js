
//prompts the user for thier username
var username = prompt("What's your name?");

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


//creates a channel named General Channel
function createChannel(channelName){
	fetch(`/createChannel/${channelName}`, {
    method: "POST"
    })
    .then((response) => response.json())
    .then((data) => {
        const channelId = data.channelId;
        window.location.href = `/channel/${channelId}`
        console.log(data);
    });
	
}

//Karen's example JavaScript
//a chunk of my js:
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




