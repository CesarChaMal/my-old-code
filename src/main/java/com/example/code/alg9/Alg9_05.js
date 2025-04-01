const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (query) => new Promise(resolve => rl.question(query, resolve));

(async () => {
    let L;
    do {
        L = parseInt(await ask("Dar el orden del arreglo (max 50): "));
    } while (isNaN(L) || L <= 0 || L > 50);

    const arr = [];
    for (let i = 0; i < L; i++) {
        const num = parseInt(await ask(`Elemento ${i + 1}: `));
        arr.push(num);
    }

    let pm3 = 1;
    let piep = 1;
    let hasParImpar = false;

    for (let i = 0; i < arr.length; i++) {
        if (i % 2 === 0 && arr[i] % 2 === 0 && arr[i] !== 0) {
            piep *= arr[i];
            hasParImpar = true;
        }
        if (arr[i] % 3 === 0 && arr[i] !== 0) {
            pm3 *= arr[i];
        }
    }

    const sorted = [...arr].sort((a, b) => a - b);

    console.log("\n--- Procedural ---");
    console.log("Producto de multiplos de 3:", pm3 !== 1 ? pm3 : "No hubo");
    console.log("Producto de posicion impar, valor par:", hasParImpar ? piep : "No hubo");
    console.log("Arreglo ordenado:", sorted.join(", "));

    rl.close();
})();
