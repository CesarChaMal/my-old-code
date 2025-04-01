const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

let n = 0;
let numbers = [];

const ask = (msg) => new Promise(resolve => readline.question(msg, input => resolve(parseInt(input))));

(async function () {
    while (n <= 0) {
        n = await ask("Dar cantidad de numeros: ");
        if (isNaN(n) || n <= 0) console.log("Cantidad invalida.");
    }

    while (numbers.length < n) {
        const x = await ask("Dar un numero: ");
        if (x !== 0 && !isNaN(x)) numbers.push(x);
        else console.log("El número debe ser entero y distinto de cero.");
    }

    readline.close();

    let product3 = 1, sumEvenPos = 0, lucasCount = 0;
    let hasMult3 = false;

    numbers.forEach((x, i) => {
        if (x % 3 === 0) {
            product3 *= x;
            hasMult3 = true;
        }
        if (x > 0 && x % 2 === 0) sumEvenPos += x;
        if (isLucas(x)) {
            lucasCount++;
            console.log(`${x} es de lucas en la posición ${i + 1}`);
        }
    });

    console.log(`\nLa suma de pares positivos: ${sumEvenPos}`);
    console.log(`Los numeros pares de lucas fueron: ${lucasCount}`);
    console.log(hasMult3 ? `El producto de los múltiplos de 3 es: ${product3}` : "No hubo múltiplos de 3");

    function isLucas(n) {
        if (n < 0) return false;
        let a = 2, b = 1;
        while (a < n) {
            [a, b] = [b, a + b];
        }
        return a === n;
    }
})();
