const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (q) =>
    new Promise((resolve) => rl.question(q, (ans) => resolve(Number(ans))));

(async () => {
    let m = 0, n = 0;
    while (m < 1 || m > 25 || n < 1 || n > 25) {
        m = await ask("Filas (1-25): ");
        n = await ask("Columnas (1-25): ");
    }

    console.log("\nDar los elementos uno a uno (por filas):");

    const arr = [];
    for (let i = 0; i < m; i++) {
        const row = [];
        for (let j = 0; j < n; j++) {
            const val = await ask(`Elemento (${i + 1},${j + 1}): `);
            row.push(val);
        }
        arr.push(row);
    }

    const pkfila = arr[m - 1].reduce((a, b) => a * b, 1);
    const menor = Math.min(...arr.flat());

    console.log(`\nProducto fila ${m}: ${pkfila.toFixed(2)}`);
    console.log(`Menor elemento: ${menor.toFixed(2)}`);

    rl.close();
})();
