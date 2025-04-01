function isLucas(x) {
    let p = 1, seg = 3;
    while (p < x) {
        let sig = p + seg;
        p = seg;
        seg = sig;
    }
    return p === x;
}

async function main() {
    const readline = require("readline").createInterface({
        input: process.stdin,
        output: process.stdout
    });

    const ask = (q) => new Promise(resolve => readline.question(q, resolve));

    let n;
    do {
        n = parseInt(await ask("Dar cantidad de numeros: "));
    } while (n <= 0);

    let count = 0;
    let cluc = 0;
    let supap = 0;
    let pm3 = 1;
    let hasMult3 = false;

    while (count < n) {
        let x;
        do {
            x = parseFloat(await ask("Dar un numero: "));
            if (x !== Math.floor(x)) {
                console.log("error numero decimal");
            }
        } while (x !== Math.floor(x));

        count++;

        if (x > 0 && x % 2 === 0) supap += x;
        if (x !== 0 && x % 3 === 0) {
            pm3 *= x;
            hasMult3 = true;
        }

        if (x > 0 && isLucas(x)) {
            cluc++;
            console.log(`${x.toFixed(2)} es de lucas`);
            console.log(`En la posicion : ${count}`);
        }
    }

    console.log(`La suma de pares positivos : ${supap.toFixed(2)}`);
    console.log(`Los numeros pares de lucas fueron : ${cluc}`);
    if (hasMult3)
        console.log(`El producto de los multiplos de 3 es : ${pm3.toFixed(2)}`);
    else
        console.log("No hubo producto de multiplos de 3");

    readline.close();
}

main();
