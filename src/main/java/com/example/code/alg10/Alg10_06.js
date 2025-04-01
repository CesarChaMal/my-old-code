const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});
const question = (query) => new Promise(resolve => readline.question(query, resolve));

(async () => {
    let m, n;
    do {
        m = parseInt(await question("Filas (1-25): "));
        n = parseInt(await question("Columnas (1-25): "));
    } while ([m, n].some(v => isNaN(v) || v < 1 || v > 25));

    console.log("Dar los elementos uno a uno por columnas:");
    const matrix = Array.from({ length: m }, () => Array(n).fill(0));
    for (let c = 0; c < n; c++) {
        for (let f = 0; f < m; f++) {
            matrix[f][c] = parseFloat(await question(`Elemento (${f+1},${c+1}): `));
        }
    }

    const prodOddRows = matrix
        .filter((_, i) => i % 2 === 0)
        .flat()
        .filter(x => x !== 0)
        .reduce((a, b) => a * b, 1);

    console.log(`\nProducto filas impares: ${prodOddRows}`);

    if (m === n) {
        const prodDiag = matrix.map((row, i) => row[i])
            .filter(x => x !== 0)
            .reduce((a, b) => a * b, 1);
        console.log(`Producto diagonal principal: ${prodDiag}`);
    } else {
        const sumPenultimate = matrix[m - 2].reduce((a, b) => a + b, 0);
        console.log(`Suma penúltima fila: ${sumPenultimate}`);
    }

    console.log("\nMatriz leída:");
    matrix.forEach(row => console.log(row.map(x => x.toFixed(2)).join(' ')));
    readline.close();
})();
