const readline = require("readline");

function isLucas(x) {
    return Array.from(function* () {
        let [a, b] = [1, 3];
        while (a <= x) {
            yield a;
            [a, b] = [b, a + b];
        }
    }()).includes(x);
}

async function readValidatedInputs(n) {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    const ask = (q) => new Promise(resolve => rl.question(q, resolve));
    const results = [];

    while (results.length < n) {
        const input = parseFloat(await ask("Dar un numero: "));
        if (input !== Math.floor(input)) {
            console.log("error numero decimal");
            continue;
        }
        results.push(input);
    }

    rl.close();
    return results.map(x => Math.floor(x));
}

async function main() {
    const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
    const ask = (q) => new Promise(resolve => rl.question(q, resolve));

    let n;
    do {
        n = parseInt(await ask("Dar cantidad de numeros: "));
    } while (n <= 0);

    rl.close();

    const inputs = await readValidatedInputs(n);

    const sumEvenPos = inputs.filter(x => x > 0 && x % 2 === 0)
        .reduce((a, b) => a + b, 0);

    const mult3List = inputs.filter(x => x !== 0 && x % 3 === 0);
    const hasMult3 = mult3List.length > 0;
    const prodMult3 = hasMult3 ? mult3List.reduce((a, b) => a * b, 1) : 1;

    const evenLucasCount = inputs.map((x, idx) => {
        if (x > 0 && isLucas(x)) {
            console.log(`${x.toFixed(2)} es de lucas`);
            console.log(`En la posicion : ${idx + 1}`);
            return x;
        }
        return null;
    }).filter(x => x !== null && x % 2 === 0).length;

    console.log(`La suma de pares positivos : ${sumEvenPos.toFixed(2)}`);
    console.log(`Los numeros pares de lucas fueron : ${evenLucasCount}`);
    console.log(
        hasMult3
            ? `El producto de los multiplos de 3 es : ${prodMult3.toFixed(2)}`
            : "No hubo producto de multiplos de 3"
    );
}

main();
