
// let value = document.getElementById('greeting').innerHTML = "<span>Perrote</span>";
// http://juggernats-env.eba-m8epbgdq.us-east-1.elasticbeanstalk.com/user
// return value;

// var greeting = "people/20";

// const emaildom = document.getElementById('createemail').value;
// const passdom = document.getElementById('createpassword').value;
// const confirmpassdom = document.getElementById('createconfirmpass').value;

    // let accInfo = {
    // "email": `${document.getElementById('email').value}`,
    // "password": `${document.getElementById('password').value}`
    // }
// alert(document.getElementById('createemail').value);
// alert(document.getElementById('createpassword').value);
// // alert(document.getElementById('cre').value);

    if (5 === 8) {
        createAccount('http://localhost:8080/user', accInfo)
        .then(function(res){ console.log(res) })
        .catch(function(res){ console.log(res) })
    } else {
        alert(document.getElementById(emaildom))
        alert(document.getElementById(passdom))
        alert('Passwords don\'t match');
    }

    alert("dkjfsoipdjpsodjvsp");

    // const data = {"email": `${document.getElementById('email').value}`,
    // "password": `${document.getElementById('password').value}`}
    // const options = {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify(data)
    // }

    // fetch(`http://localhost:8080/user`, options)
    // .then(res => { 
    //     if(res.ok) {
    //         console.log('SUCCESS')
    //         res.json()
    //         // .then(data => console.log(data.name))
    //         .then(data => document.getElementById('greeting').innerHTML = `Hello ${data.name}`)
    //     } else {
    //         console.log('Not succesful')
    //     }
    // })
    // .then(data => console.log(data))




// fetch(`https://swapi.dev/api/people/69`)
//     .then(res => { 
//         if(res.ok) {
//             console.log('SUCCESS')
//             res.json()
//             // .then(data => console.log(data.name))
//             .then(data => document.getElementById('greeting').innerHTML = `Hello ${data.name}`)
//         } else {
//             console.log('Not succesful')
//         }
//     })
//     .then(data => console.log(data))

// document.getElementById('greeting').innerHTML = value;

// console.log(value);

// async function createAccount(url = '', data = {}) {
//     // Default options are marked with *
//     const response = await fetch(url, {
//       method: 'POST', // *GET, POST, PUT, DELETE, etc.
//       headers: {
//         'Content-Type': 'application/json'
//         // 'Content-Type': 'application/x-www-form-urlencoded',
//       },
//       body: JSON.stringify(data),
//       mode: 'no-cors' // body data type must match "Content-Type" header
//     });
//     // return response.json(); // parses JSON response into native JavaScript objects
//   }

