const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

let n = 0;
let numbers = [];

const askNumber = () => {
    if (numbers.length < n) {
        readline.question("Dar un valor entero: ", input => {
            const x = parseInt(input);
            if (!isNaN(x) && x !== 0) {
                numbers.push(x);
            } else {
                console.log("Valor invalido. Debe ser un entero distinto de cero.");
            }
            askNumber();
        });
    } else {
        readline.close();
        processNumbers(numbers);
    }
};

readline.question("Dar cantidad de numeros: ", input => {
    n = parseInt(input);
    if (!isNaN(n) && n > 0) {
        askNumber();
    } else {
        console.log("Cantidad invalida");
        readline.close();
    }
});

function processNumbers(numbers) {
    let pp = 1, pim = 1, hasOdd = false;
    let min = numbers[0], max = numbers[0], posMax = 1;

    numbers.forEach((x, i) => {
        if (x % 2 === 0) {
            pp *= x;
        } else if (Math.abs(x) % 10 !== 3) {
            pim *= x;
            hasOdd = true;
        }

        if (x > max) {
            max = x;
            posMax = i + 1;
        }
        if (x < min) {
            min = x;
        }
    });

    console.log(`El producto de pares es : ${pp.toFixed(2)}`);
    console.log(`El producto de impares es (menos los terminados en 3) : ${hasOdd ? pim.toFixed(2) : "N/A"}`);
    console.log(`El menor : ${min}         El mayor es : ${max}`);
    console.log(`La posicion del mayor es : ${posMax}`);
}
