const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (query) => new Promise(resolve => rl.question(query, resolve));

(async () => {
    const L = await (async () => {
        let val;
        do {
            val = parseInt(await ask("Dar el orden del arreglo (max 50): "));
        } while (isNaN(val) || val <= 0 || val > 50);
        return val;
    })();

    const arr = [];
    for (let i = 0; i < L; i++) {
        const num = parseInt(await ask(`Elemento ${i + 1}: `));
        arr.push(num);
    }

    const pm3List = arr.filter(x => x % 3 === 0 && x !== 0);
    const pm3 = pm3List.reduce((a, b) => a * b, 1);
    const pm3Display = pm3List.length ? pm3 : "No hubo";

    const piepList = arr.map((v, i) => (i % 2 === 0 && v % 2 === 0 && v !== 0 ? v : null)).filter(x => x !== null);
    const piep = piepList.reduce((a, b) => a * b, 1);
    const piepDisplay = piepList.length ? piep : "No hubo";

    const sorted = [...arr].sort((a, b) => a - b);

    console.log("\n--- Functional ---");
    console.log("Producto de multiplos de 3:", pm3Display);
    console.log("Producto de posicion impar, valor par:", piepDisplay);
    console.log("Arreglo ordenado:", sorted.join(", "));

    rl.close();
})();
