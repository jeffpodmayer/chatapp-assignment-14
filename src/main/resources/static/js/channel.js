var messageToSend = document.getElementById("messageBox");
var chatBox = document.querySelector("#chatBox");
var senderName = sessionStorage.getItem('username');
var channelId = sessionStorage.getItem('channelId');

console.log(senderName);
console.log(channelId);

messageToSend.addEventListener('keydown', (event) => {
		if (event.key === "Enter") {
			event.preventDefault();
			sendMessage();
		}
	});

function sendMessage() {
	var message = messageToSend.value.trim();

	if (message !== '') {
		chatBox.innerHTML += '<p>' + '<strong>' + senderName + ": " +  '</strong>' + message + '</p>';
		messageToSend.value = '';
		
		console.log("You sent a message");
	}


	fetch(`/sendMessage/${channelId}`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(message)
	})
		.then((response) => response.json())
		.then((data) => {
			console.log(data);
		});

}

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

