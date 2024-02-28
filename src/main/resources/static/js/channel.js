var messageToSend = document.getElementById("messageBox");
var chatBox = document.querySelector("#chatBox");
var senderName = sessionStorage.getItem('username');
var channelId = sessionStorage.getItem('channel');

console.log(senderName);
console.log(channelId);

messageToSend.addEventListener('keydown', (event) => {
	if (event.key === "Enter") {
		event.preventDefault();
		sendMessage();
	}
});

function sendMessage() {
	var message = {
		sender: senderName,
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
		});

}

setInterval(() => {
	fetch(`/getNewMessages/${channelId}`)
		.then(response => response.json())
		.then(data => {
			displayNewMessages(data);
		})
		.catch(error => {
			console.error('Error fetching new messages:', error);
		});
}, 500);

function displayNewMessages(messages) {
	messages.forEach(message => {
		const messageElement = document.createElement('p');
		messageElement.textContent = `${message.senderName} : ${message.messageBody}`;
		chatBox.append(messageElement);
	});
}





//KAREN'S CODE
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

