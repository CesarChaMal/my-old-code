const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const ask = (query) => new Promise(resolve => rl.question(query, ans => resolve(Number(ans))));

(async () => {
    let m, n;
    do {
        m = await ask("Filas (max 25): ");
        n = await ask("Columnas (max 25): ");
    } while (isNaN(m) || isNaN(n) || m < 1 || m > 25 || n < 1 || n > 25);

    const arr = [];
    for (let i = 0; i < m; i++) {
        arr[i] = [];
        for (let j = 0; j < n; j++) {
            const val = await ask(`Elemento (${i+1},${j+1}): `);
            arr[i][j] = val;
        }
    }

    let pkfila = 1;
    let menor = arr[0][0];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i === m - 1) pkfila *= arr[i][j];
            if (arr[i][j] < menor) menor = arr[i][j];
        }
    }

    console.log(`Producto fila ${m}: ${pkfila.toFixed(2)}`);
    console.log(`Menor elemento: ${menor.toFixed(2)}`);

    rl.close();
})();
