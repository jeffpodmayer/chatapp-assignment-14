//CREATING A USER AND STORES IT IN THE SESSION AND SERVER SIDE

console.log("Reading script.")
var username = sessionStorage.getItem('username');
var userId = sessionStorage.getItem('userId');

if (!username) {
	console.log("Prompting for username.")
	username = prompt("Enter your username: ");
	createUser();
} else {
	alert("Welcome back, " + username);
}


//CREATES A USER
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
			userId = data.userId;
			username = data.username;
			sessionStorage.setItem('username', username);
			sessionStorage.setItem('userId', userId);
			console.log(data);
//			console.log("User sent and saved!");
		});
}

//CREATES THE GENERAL CHANNEL & JOINS IT
function joinOrCreateGeneralChannel() {
	fetch(`/joinOrCreateGeneralChannel?username=` + username, {
		method: 'POST',
	})
		.then(response => response.json())
		.then(data => {
			const channelId = data.channelId;
			sessionStorage.setItem('channelId', channelId);
//			console.log("User has joined the channel!");
			console.log(data);
			joinChannel(1);
		});
}

//CREATES CHANNEL 2 & JOINS IT
function joinOrCreateChannel2() {
	fetch('/joinOrCreateChannel2?username=' + username, {
		method: 'POST',
	})
		.then(response => response.json())
		.then(data => {
			const channelId = data.channelId;
			sessionStorage.setItem('channelId', channelId);
//			console.log("User has joined the channel!");
			console.log(data);
			joinChannel(2);
		});
}

function joinChannel(channelId) {
	sessionStorage.setItem('channelId', channelId);
	var channelData = {
		channelId: channelId,
		users: [
			{ userId: userId, username: username }
		]
	};

	fetch(`/joinChannel/${channelId}`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(channelData)
	})
		.then((response) => response.json())
		.then((data) => {
			var channelId = channelData.channelId;
			window.location.href = `/channel/${channelId}`;
			console.log(data);
		});
}
