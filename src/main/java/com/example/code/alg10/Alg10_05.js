const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

function question(query) {
    return new Promise(resolve => readline.question(query, resolve));
}

(async () => {
    let m, n;
    do {
        m = parseInt(await question("Filas (1-25): "));
        n = parseInt(await question("Columnas (1-25): "));
    } while (isNaN(m) || isNaN(n) || m < 1 || n < 1 || m > 25 || n > 25);

    const matrix = Array.from({ length: m }, () => Array(n));

    console.log("Elementos por columnas:");
    for (let c = 0; c < n; c++)
        for (let f = 0; f < m; f++)
            matrix[f][c] = parseFloat(await question(`Elemento (${f + 1},${c + 1}): `));

    let prodOddRows = 1, hasProd = false;
    for (let f = 0; f < m; f += 2) {
        for (let c = 0; c < n; c++) {
            if (matrix[f][c] !== 0) {
                prodOddRows *= matrix[f][c];
                hasProd = true;
            }
        }
    }
    console.log(hasProd ? `Producto filas impares: ${prodOddRows}` : "No hay producto filas impares");

    if (m === n) {
        let prodDiag = 1, hasDiag = false;
        for (let i = 0; i < m; i++)
            if (matrix[i][i] !== 0) {
                prodDiag *= matrix[i][i];
                hasDiag = true;
            }
        console.log(hasDiag ? `Producto diagonal principal: ${prodDiag}` : "No hay producto diagonal principal");
    } else {
        let sumPenultimate = matrix[m - 2].reduce((a, b) => a + b, 0);
        console.log(`Suma penúltima fila: ${sumPenultimate}`);
    }

    console.log("Matriz leída:");
    matrix.forEach(row => console.log(row.join(' ')));
    readline.close();
})();
