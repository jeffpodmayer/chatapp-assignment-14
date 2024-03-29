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
	};

	if (message.messageBody !== '') {
		chatBox.innerHTML += '<p>' + '<strong>' + senderName + ": " + '</strong>' + message.messageBody + '</p>';
		messageToSend.value = '';
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

//DISPLAYS NEW MESSAGES EVERY 500 MILLISECONDS
function fetchNewMessages() {
	const previousMessages = JSON.parse(localStorage.getItem("messages")) || [];
	fetch(`/getNewMessages/${channelId}`)
		.then((response) => response.json())
		.then((messages) => {
			const newMessages = messages.filter((message) => {
				return message.channelId == channelId;
			});

//			console.log(newMessages.length);
//			console.log(previousMessages.length);

			if (newMessages.length > previousMessages?.length) { }
			renderMessages(newMessages);

			localStorage.setItem("messages", JSON.stringify(newMessages));

		});
}
function renderMessages(newMessages) {
	chatBox.innerHTML = "";

	newMessages.forEach((message) => {
		const messageElement = document.createElement('p');
		messageElement.textContent = `${message.sender.username} : ${message.messageBody}`;
		chatBox.append(messageElement);
	});
}

setInterval(fetchNewMessages, 500);


//LOADS ALL NEW MESSAGES WHEN NEW USER JOINS PAGE
document.addEventListener("DOMContentLoaded", () => {
	fetchNewMessages();
	const messagesFromLocalStorage = JSON.parse(localStorage.getItem("messages")) || [];

	if (messagesFromLocalStorage > 0) {
		renderMessages(messagesFromLocalStorage);
	}

});



