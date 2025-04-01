const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function ask(question) {
    return new Promise(resolve => rl.question(question, resolve));
}

(async function main() {
    let n;
    do {
        n = parseInt(await ask("Dar el orden del arreglo (max 50): "));
    } while (isNaN(n) || n <= 0 || n > 50);

    const arr = [];
    for (let i = 0; i < n; i++) {
        let num;
        do {
            num = parseFloat(await ask(`Elemento ${i + 1}: `));
        } while (isNaN(num));
        arr.push(num);
    }

    let max = arr[0];
    let posMax = 1;
    let productEvenPos = 1;
    let productOddVals = 1;
    let hasEvenPos = false;
    let hasOddVals = false;

    for (let i = 0; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
            posMax = i + 1;
        }

        if ((i + 1) % 2 === 0 && arr[i] !== 0) {
            productEvenPos *= arr[i];
            hasEvenPos = true;
        }

        if (arr[i] % 2 !== 0) {
            productOddVals *= arr[i];
            hasOddVals = true;
        }
    }

    console.log(`El mayor = ${max.toFixed(2)} su posicion es ${posMax}`);

    if (hasEvenPos)
        console.log(`Producto de posicion de pares ${productEvenPos.toFixed(2)}`);
    else
        console.log("No hubo producto positivo de pares");

    if (hasOddVals)
        console.log(`Producto de elementos impares ${productOddVals.toFixed(2)}`);
    else
        console.log("No hubo producto de elementos impares");

    rl.close();
})();
