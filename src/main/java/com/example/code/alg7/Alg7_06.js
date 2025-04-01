const readline = require("readline").promises;

const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

async function ask(query) {
    const res = await rl.question(query);
    return parseInt(res);
}

(async () => {
    let n;
    do {
        n = await ask("Dar cantidad de numeros: ");
    } while (n <= 0);

    const numbers = [];
    while (numbers.length < n) {
        const x = await ask("Dar un valor entero distinto de cero: ");
        if (x !== 0 && !isNaN(x)) numbers.push(x);
    }

    const productEven = numbers.filter(x => x % 2 === 0 && ![2, 4].includes(Math.abs(x % 10)))
        .reduce((acc, x) => acc * x, 1);

    const maxOdd = numbers.filter(x => x % 2 !== 0)
        .reduce((max, x) => max === null ? x : Math.max(max, x), null);

    numbers.filter(x => x > 0).forEach(x => {
        const divisors = Array.from({length: Math.floor(x/2) - 1}, (_, i) => i + 2)
            .filter(d => x % d === 0);
        divisors.forEach(d => console.log(`${d} es divisor de ${x}`));
        console.log(`${x} tuvo ${divisors.length} divisores`);
    });

    console.log(productEven !== 1 ? `El producto de pares es: ${productEven}` : "No hubo producto de pares");
    console.log(maxOdd !== null ? `El mayor de los impares es: ${maxOdd}` : "No se dieron impares");
    rl.close();
})();
