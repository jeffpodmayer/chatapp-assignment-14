//CREATING A USER AND STORES IT IN THE SESSION AND SERVER SIDE
console.log("Reading script.")
var username = sessionStorage.getItem('username');
var userId = sessionStorage.getItem('userId');

if (!username) {
	console.log("Prompting for username.")
	username = prompt("Enter your username: ");
	sessionStorage.setItem('username', username);
	alert("Welcome back, " + username);
} else {
	alert("Welcome back, " + username);
}

createUser();

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
			sessionStorage.setItem('userId', userId);
			console.log(data);
			console.log("User sent and saved!");
		});
}

//CREATES A CHANNEL
function joinOrCreateChannel() {
	var channelId = sessionStorage.getItem('channelId');
	if (!channelId) {
		createChannel();
	} else {
		joinUserToChannel(channelId);
	}
};
function createChannel() {
	fetch(`/createChannel`, {
		method: "POST"
	})
		.then((response) => response.json())
		.then((data) => {
			const channelId = data.channelId;
			sessionStorage.setItem('channelId', channelId);
			console.log("Channel created and saved!");
			joinUserToChannel(channelId);
			console.log("User has joined the channel.");
			console.log(data);
		});
}

function joinUserToChannel(channelId) {
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
			console.log("User joined to channel!");
			console.log(data);
		});
}


//OLD JAVA SCRIPT CODE -- Don't think that I need this...
//const channel = {
//	channelId: sessionStorage.getItem('channelId'),
//	users: [],
//	messages: []
//};

//function addUserToChannel(userId, username) {
//	const newUser = {
//		userId: userId,
//		username: username
//	};
//	channel.users.push(newUser);
//}









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




