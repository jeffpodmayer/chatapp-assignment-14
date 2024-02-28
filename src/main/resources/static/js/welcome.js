//CREATING A USER AND STORES IT IN THE SESSION AND SERVER SIDE
//prompts the user for thier username
console.log("Reading script.")
var username = sessionStorage.getItem('username');

if (!username) {
	console.log("Prompting for username.")
	username = prompt("Enter your username: ");
	sessionStorage.setItem('username', username);
	alert("Welcome back, " + username);
} else {
	alert("Welcome back, " + username);
}

createUser();

//createsUser
//this gets called after the initial logic is completed
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
			console.log(data);
		});
}

/////////////////////////////////////////////////////////////////////////////////////

//CREATES A CHANNEL
var channel = sessionStorage.getItem('channel');

function joinOrCreateChannel() {
	if (channel != null) {
		joinChannel(channel);
	} else {
		createChannel();
	}
}

function joinChannel(channelId, username) {
	fetch(`/joinChannel/${channelId}/${username}`, {
		method: "POST"
	})
		.then((response) => response.json())
		.then((data) => {
			const channelId = data.channelId;
			sessionStorage.setItem('channel', channelId);
			window.location.href = `/channel/${channelId}`;
			console.log(data);
		});
}

function createChannel() {
	fetch(`/createChannel`, {
		method: "POST"
	})
		.then((response) => response.json())
		.then((data) => {
			const channelId = data.channelId;
			sessionStorage.setItem('channel', channelId);
			window.location.href = `/channel/${channelId}`;
			console.log(data);
		});
}

//Karen's example JavaScript





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




