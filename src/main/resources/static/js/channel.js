var messageToSend = document.querySelector("#messageBox");
var chatBox = document.querySelector("#chatBox");
var senderName = document.getElementById('username').value || 'username'

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


	fetch(`/sendMessage`, {
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

