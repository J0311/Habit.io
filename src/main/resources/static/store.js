
// let value = document.getElementById('greeting').innerHTML = "<span>Perrote</span>";

// return value;

// var greeting = "people/20";



fetch(`https://swapi.dev/api/people/69`)
    .then(res => { 
        if(res.ok) {
            console.log('SUCCESS')
            res.json()
            // .then(data => console.log(data.name))
            .then(data => document.getElementById('greeting').innerHTML = `Hello ${data.name}`)
        } else {
            console.log('Not succesful')
        }
    })
    // .then(data => console.log(data))

// document.getElementById('greeting').innerHTML = value;

// console.log(value);