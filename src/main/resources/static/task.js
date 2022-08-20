
// let value = document.getElementById('greeting').innerHTML = "<span>Perrote</span>";

// return value;

var greeting = "people/20";


for (let i=0; i < 40; i++) {
    fetch(`https://swapi.dev/api/people/${i}`)
        .then(res => { 
            if(res.ok) {
                console.log('SUCCESS')
                res.json()
                // .then(data => console.log(data.name))
                .then(data => document.getElementById('list1').innerHTML += `<br><div class="task" draggable="true">
                <h3>${data.name}</h3><br>
                <p>${data.birth_year}</p><br>
                <div class="button" type="submit"><button>Complete</button></div>
                </div>`)
            } else {
            console.log('Not succesful')
        }
    })}



    // .then(data => console.log(data))

// document.getElementById('greeting').innerHTML = value;

// console.log(value);