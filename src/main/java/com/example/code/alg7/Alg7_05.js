const readline = require("readline").promises;

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

async function ask(query) {
    const res = await rl.question(query);
    return parseInt(res);
}

(async () => {
    let n;
    do {
        n = await ask("Dar cantidad de numeros: ");
    } while (isNaN(n) || n <= 0);

    let pp = 1;
    let maxOdd = Number.MIN_SAFE_INTEGER;
    let hasEven = false;
    let hasOdd = false;

    for (let i = 0; i < n; i++) {
        let x;
        do {
            x = await ask("Dar un valor entero distinto de cero: ");
        } while (isNaN(x) || x === 0);

        if (x % 2 === 0 && ![2, 4].includes(Math.abs(x % 10))) {
            pp *= x;
            hasEven = true;
        } else if (x % 2 !== 0) {
            if (!hasOdd || x > maxOdd) {
                maxOdd = x;
                hasOdd = true;
            }
        }

        if (x > 0) {
            let divisors = [];
            for (let d = 2; d <= Math.floor(x / 2); d++) {
                if (x % d === 0) divisors.push(d);
            }
            divisors.forEach(d => console.log(`${d} es divisor de ${x}`));
            console.log(`${x} tuvo ${divisors.length} divisores`);
        }
    }

    console.log(hasEven ? `El producto de pares es: ${pp}` : "No hubo producto de pares");
    console.log(hasOdd ? `El mayor de los impares es: ${maxOdd}` : "No se dieron impares");

    rl.close();
})();
