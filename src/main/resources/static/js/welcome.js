var username = prompt("What's your name?");

fetch(`/saveUser`, {
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

