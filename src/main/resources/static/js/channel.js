var messageToSend = document.getElementById("messageBox");

var chatBox = document.querySelector("#chatBox");

var senderName = sessionStorage.getItem('username');
var senderId = sessionStorage.getItem('userId');
var channelId = sessionStorage.getItem('channelId');

console.log("User on channel: " + senderName);
console.log("UserId of User on channel: " + senderId);
console.log("Current Channel you are on: " + channelId);

messageToSend.addEventListener('keydown', (event) => {
	if (event.key === "Enter") {
		event.preventDefault();
		sendMessage();
	}
});

function sendMessage() {
	var message = {
		sender: {
			userId: senderId, 
			username : senderName
			},
		channel: channelId,
		messageBody: messageToSend.value.trim(),
		timeStamp: new Date().toISOString()
	};

	if (message.messageBody !== '') {
		chatBox.innerHTML += '<p>' + '<strong>' + senderName + ": " + '</strong>' + message.messageBody + '</p>';
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
			console.log("Message saved on server side!")
		});

}

function displayNewMessages(messages) {
	fetch(`/getNewMessages/${channelId}`)
		.then(response => response.json())
		.then(messages.forEach(message => {
			const messageElement = document.createElement('p');
			messageElement.textContent = `${message.senderName} : ${message.messageBody}`;
			chatBox.append(messageElement);
		}));
}

setInterval(displayNewMessages, 1000);



