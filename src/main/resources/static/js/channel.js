var senderName = sessionStorage.getItem('username');
var senderId = sessionStorage.getItem('userId');
var channelId = sessionStorage.getItem('channelId');

checkIfUserExistsInSession();

function checkIfUserExistsInSession() {
	if (sessionStorage.getItem('username') === "null" || sessionStorage.getItem('username') === null) {
		return window.location.replace("http://localhost:8080/welcome")
	} else {
		console.log("User on channel: " + senderName);
		console.log("UserId of User on channel: " + senderId);
		console.log("Current Channel you are on: " + channelId);
	}
}

//SENDS MESSAGE WHEN "ENTER" IS PRESSED.
var messageToSend = document.getElementById("messageBox");
var chatBox = document.querySelector("#chatBox");

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
			username: senderName
		},
		channel: channelId,
		messageBody: messageToSend.value.trim(),
		timestamp: new Date().toISOString()
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

//DISPLAYS NEW MESSAGES EVERY SECOND
function fetchNewMessages() {
	const previousMessages = JSON.parse(localStorage.getItem("messages"));
	console.log("Fetching new messages...")
	fetch(`/getNewMessages/${channelId}`)
		.then((response) => response.json())
		.then((messages) => {
			const newMessages = messages.filter((message) => {
				return message.channelId == channelId;
			});
			if (newMessages.length > previousMessages?.length)
				renderMessages(newMessages);

			localStorage.setItem("messages", JSON.stringify(newMessages));

		});
}
function renderMessages(newMessages) {
	chatBox.innerHTML = "";

	//ADD A sort to the newMessages array.

	newMessages.forEach((message) => {
		const messageElement = document.createElement('p');
		messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
		chatBox.append(messageElement);
	});
}

setInterval(fetchNewMessages, 500);

document.addEventListener("DOMContentLoaded", () => {
	fetchNewMessages();
	const messagesFromLocalStorage = JSON.parse(localStorage.getItem("messages"));
	renderMessages(messagesFromLocalStorage);
});



