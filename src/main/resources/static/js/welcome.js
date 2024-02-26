
//prompts the user for thier username
var username = prompt("What's your name?");

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


//creates a channel named General Channel
function createChannel(channelName){
	fetch(`/createChannel/${channelName}`, {
    method: "POST"
    })
    .then((response) => response.json())
    .then((data) => {
        const channelId = data.channelId;
        window.location.href = `/channel/${channelId}`
        console.log(data);
    });
	
}


