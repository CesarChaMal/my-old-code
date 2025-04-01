const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

let n = 0;
const numbers = [];

function ask(question) {
    return new Promise(resolve => readline.question(question, input => resolve(parseInt(input))));
}

(async function main() {
    while (n <= 0) {
        n = await ask("Dar cantidad de numeros: ");
        if (isNaN(n) || n <= 0) console.log("Cantidad invalida.");
    }

    while (numbers.length < n) {
        const x = await ask("Dar un valor entero (distinto de cero): ");
        if (!isNaN(x) && x !== 0) {
            numbers.push(x);
        } else {
            console.log("Valor invalido. Debe ser entero distinto de cero.");
        }
    }

    readline.close();

    // Functional processing
    const productEven = numbers.filter(x => x % 2 === 0).reduce((a, b) => a * b, 1);
    const oddFiltered = numbers.filter(x => x % 2 !== 0 && Math.abs(x) % 10 !== 3);
    const productOdd = oddFiltered.length > 0 ? oddFiltered.reduce((a, b) => a * b, 1) : null;
    const min = Math.min(...numbers);
    const max = Math.max(...numbers);
    const posMax = numbers.indexOf(max) + 1;

    console.log(`\nEl producto de pares es : ${productEven.toFixed(2)}`);
    console.log(`El producto de impares es (menos los terminados en 3) : ${productOdd !== null ? productOdd.toFixed(2) : "N/A"}`);
    console.log(`El menor : ${min}         El mayor es : ${max}`);
    console.log(`La posicion del mayor es : ${posMax}`);
})();
