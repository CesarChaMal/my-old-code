const readline = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (q) => new Promise(res => readline.question(q, ans => res(parseInt(ans))));

(async () => {
    let n = 0;
    while (n <= 0) {
        n = await ask("Dar cantidad de numeros: ");
    }

    const numbers = [];
    while (numbers.length < n) {
        const x = await ask("Dar un numero: ");
        if (x !== 0 && !isNaN(x)) numbers.push(x);
    }
    readline.close();

    const isLucas = (n) => {
        if (n < 0) return false;
        let a = 2, b = 1;
        while (a < n) [a, b] = [b, a + b];
        return a === n;
    };

    const product3 = numbers.filter(x => x % 3 === 0).reduce((a, b) => a * b, 1);
    const has3 = numbers.some(x => x % 3 === 0);
    const sumEvenPos = numbers.filter(x => x > 0 && x % 2 === 0).reduce((a, b) => a + b, 0);
    const lucasEven = numbers.filter(x => x % 2 === 0 && isLucas(x)).length;

    console.log(`\nLa suma de pares positivos: ${sumEvenPos}`);
    console.log(`Los numeros pares de lucas fueron: ${lucasEven}`);
    console.log(has3 ? `El producto de los múltiplos de 3 es: ${product3}` : "No hubo múltiplos de 3");
})();
