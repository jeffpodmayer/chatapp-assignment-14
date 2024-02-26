var messageToSend = document.querySelector("#messageBox");
var chatBox = document.querySelector("#chatBox");
var username = 


messageToSend.addEventListener('keydown', (event) => {
	if (event.key === "Enter") {
		event.preventDefault();

		var message = messageToSend.value.trim();

		if (message !== '') {
			chatBox.innerHTML += '<p>' + message + '</p>';
			messageInput.value = '';
			console.log("You sent a message");
		}
		}
		//ADD fetch down here to send messages to server side
	});